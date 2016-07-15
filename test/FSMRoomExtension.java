import java.util.concurrent.TimeUnit;

import com.smartfoxserver.v2.extensions.SFSExtension;

import me.jangarita.sfs.fsm.FSM;
import states.GreenState;
import states.RedState;
import states.YellowState;

public class GemGoLobbyRoomExtension extends SFSExtension
{
	@Override
	public void init()
	{
		FSM fsm = new FSM();
		fsm.addState(new RedState(this));
		fsm.addState(new YellowState(this));
		fsm.addState(new GreenState(this));

		fsm.changeState("RED");
		fsm.start(1, TimeUnit.SECONDS);
	}
}
