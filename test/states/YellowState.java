package states;

import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import me.jangarita.sfs.fsm.BaseState;
import me.jangarita.sfs.fsm.FSM;

public class YellowState extends BaseState
{
	private int m_maxTime;
	private int m_currentTime;

	public YellowState(SFSExtension _extension)
	{
		super(_extension);
	}

	@Override
	public void enter(FSM _fsm)
	{
		super.enter(_fsm);

		m_maxTime = 3;
		m_currentTime = 0;
	}

	@Override
	public void update()
	{
		m_currentTime++;

		if (m_currentTime >= m_maxTime)
		{
			getFSM().changeState("GREEN");

		}
	}

	@Override
	public void exit()
	{

	}

	@Override
	public String getName()
	{
		return "YELLOW";
	}

	@Override
	protected SFSObject getStateData()
	{
		SFSObject info = new SFSObject();
		info.putInt("time", m_maxTime - m_currentTime);

		return info;
	}

}
