package me.jangarita.sfs.fsm;

import java.util.Hashtable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.smartfoxserver.v2.SmartFoxServer;

/**
 * @author Johanny Angarita
 * @version 1.0
 *          {@link http://www.jangarita.me/maquina-de-estados-para-smartfoxserver}
 *          {@link https://github.com/jangarita/Simple-SmartFoxServer-Finite-State-Machine}
 */
public class FSM
{
	private class TaskRunner implements Runnable
	{
		public void run()
		{
			try
			{
				update();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private FSMState m_currentState;
	private Hashtable<String, FSMState> m_states;
	private ScheduledFuture<?> m_timer;

	public FSM()
	{
		m_currentState = null;

		m_states = new Hashtable<String, FSMState>();
	}

	public void addState(FSMState _state)
	{
		m_states.put(_state.getName(), _state);
	}

	public void addState(String _stateName, FSMState _state)
	{
		m_states.put(_stateName, _state);
	}

	public FSMState getStateByName(String _stateName)
	{
		if (m_states.containsKey(_stateName))
		{
			return m_states.get(_stateName);
		}

		return null;
	}

	public FSMState getCurrentState()
	{
		return m_currentState;
	}

	public void changeState(String _stateName)
	{
		if (m_states.containsKey(_stateName))
		{
			changeState(m_states.get(_stateName));
		}
		else
		{
			System.err.println("State '" + _stateName + "' doesn't exist.");
		}
	}

	public void changeState(FSMState _state)
	{
		if (m_currentState != null)
		{
			m_currentState.exit();
		}

		m_currentState = _state;

		if (m_currentState != null)
		{
			m_currentState.enter(this);
		}
	}

	public void update()
	{
		if (m_currentState != null)
		{
			m_currentState.update();
		}
	}

	public void start(int _period, TimeUnit _timeUnit)
	{
		m_timer = SmartFoxServer.getInstance().getTaskScheduler().scheduleAtFixedRate(new TaskRunner(), 0, _period,
				_timeUnit);
	}

	public void stop()
	{
		if (m_timer != null)
		{
			m_timer.cancel(true);
			m_timer = null;
		}
	}

	public void destroy()
	{
		stop();
		m_currentState = null;
		m_states.clear();
	}
}
