package states;

import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

import me.jangarita.sfs.fsm.BaseState;
import me.jangarita.sfs.fsm.FSM;

public class GreenState extends BaseState
{
	public GreenState(SFSExtension _extension)
	{
		super(_extension);
	}

	@Override
	public void enter(FSM _fsm)
	{
		super.enter(_fsm);
	}

	@Override
	public void update()
	{

	}

	@Override
	public void exit()
	{

	}

	@Override
	public String getName()
	{
		return "GREEN";
	}

	@Override
	protected SFSObject getStateData()
	{
		SFSObject info = new SFSObject();

		return info;
	}

}
