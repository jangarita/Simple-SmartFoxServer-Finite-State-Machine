# Simple SmartFoxServer Finite State Machine
This is a simple finite state machine ready for SmartFoxServer.

> More info: [jangarita.me](http://www.jangarita.me/maquina-de-estados-para-smartfoxserver).

**Usage:**

*See the test folder for a usage example.*

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
//Or call the update manually
//fsm.update();

//Don't forget to call destroy() when the FSM is not more necessary
fsm.destroy();
```

An State can implements the FSMState or just extends the BaseState.
