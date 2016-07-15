package me.jangarita.sfs.fsm;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.SFSExtension;

public abstract class BaseState implements FSMState
{
	private SFSExtension m_extension;
	private FSM m_fsm;

	public BaseState(SFSExtension _extension)
	{
		m_extension = _extension;
	}

	@Override
	public void enter(FSM _fsm)
	{
		m_fsm = _fsm;

		System.out.println("STATE: " + getName());

		sendState(null);
	}

	public void sendState(User _user)
	{
		SFSObject params = new SFSObject();
		params.putUtfString("name", getName());
		params.putSFSObject("data", getStateData());

		if (_user == null)
		{
			getExtension().send("state-change", params, getExtension().getParentRoom().getUserList());
		}
		else
		{
			getExtension().send("state-change", params, _user);
		}
	}

	public SFSExtension getExtension()
	{
		return m_extension;
	}

	public FSM getFSM()
	{
		return m_fsm;
	}

	protected abstract SFSObject getStateData();
}
