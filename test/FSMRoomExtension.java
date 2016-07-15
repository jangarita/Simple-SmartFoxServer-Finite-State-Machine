import java.util.concurrent.TimeUnit;

import com.smartfoxserver.v2.extensions.SFSExtension;

import me.jangarita.sfs.fsm.FSM;
import states.GreenState;
import states.RedState;
import states.YellowState;

public class FSMRoomExtension extends SFSExtension
{
	private FSM m_fsm;
	
	@Override
	public void init()
	{
		m_fsm = new FSM();
		m_fsm.addState(new RedState(this));
		m_fsm.addState(new YellowState(this));
		m_fsm.addState(new GreenState(this));

		m_fsm.changeState("RED");
		m_fsm.start(1, TimeUnit.SECONDS);
	}
	
	@Override
	public void destroy()
	{
		m_fsm.destroy();

		super.destroy();
	}
}
