# Simple SmartFoxServer Finite State Machine
This is a simple finite state machine ready for SmartFoxServer.

**Usage:**

*See the test folder for more info*

```java
//Instantiate the main FSM class
FSM fsm = new FSM();

//Add states
fsm.addState(new RedState(this));
fsm.addState(new YellowState(this));
fsm.addState(new GreenState(this));

//Set the initial state
fsm.changeState("RED");

//Start the FSM internal timer for updates
fsm.start(1, TimeUnit.SECONDS);
```

An State can implements the FSMState or just extends the BaseState.
