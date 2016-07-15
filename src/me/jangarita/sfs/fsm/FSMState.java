package me.jangarita.sfs.fsm;

public interface FSMState
{
	public void enter(FSM _fsm);

	public void update();

	public void exit();

	public String getName();
}
