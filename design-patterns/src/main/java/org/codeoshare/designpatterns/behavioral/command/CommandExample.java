package org.codeoshare.designpatterns.behavioral.command;

/**
 * The Command design pattern is a behavioral pattern that 
 * encapsulates a request as an object, allowing for deferred 
 * execution or manipulation of requests. It is a behavioral 
 * design pattern that turns a request into a stand-alone object 
 * that contains all information about the request. 
 * This transformation lets you pass requests as a method arguments, 
 * delay or queue a request’s execution, and support undoable operations.
 * Here's an example of the Command pattern in Java: 
 * 
 * This example defines a Light class, a TurnOnLightCommand class that 
 * implements the Command interface, and a RemoteControl class that uses 
 * a Command object to turn on a light. The Client class creates an instance 
 * of the Light class and an instance of the TurnOnLightCommand class, and 
 * then it uses the RemoteControl class to turn on the light. 
 * By encapsulating the request in an object, you can pass around the request 
 * with all the information necessary to execute it, rather than just the request 
 * itself.
 * 
 * @author chatGBT
 */

public class CommandExample {

	public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command turnOnLivingRoomLight = new TurnOnLightCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOnLivingRoomLight);
        remote.pressButton();
    }

}

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
