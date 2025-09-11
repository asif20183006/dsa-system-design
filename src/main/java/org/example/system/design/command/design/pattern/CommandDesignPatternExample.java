package org.example.system.design.command.design.pattern;

public class CommandDesignPatternExample {

    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();

        Light light = new Light();
        Fan fan = new Fan();

        FanCommand fanCommand = new FanCommand(fan);
        LightCommand lightCommand = new LightCommand(light);

        remoteController.setCommands(0, fanCommand);
        remoteController.setCommands(2, lightCommand);

        remoteController.pressButton(0);
        remoteController.pressButton(0);

        remoteController.pressButton(2);
        remoteController.pressButton(2);

        remoteController.pressButton(3);
        remoteController.pressButton(1);
    }


}

interface ICommand {
    void execute();
    void undo();
}

class Light {
    public void om() {
        System.out.println("Light switched on");
    }

    public void off() {
        System.out.println("Light switched Off");
    }
}

class Fan {
    public void on(){
        System.out.println("Fan turned on");
    }

    public void off() {
        System.out.println("Fan turned off");
    }
}

class FanCommand implements ICommand {

    Fan fan;

    FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class LightCommand implements ICommand {

    Light light;
    LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.om();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class RemoteController {

    int button = 4;

    ICommand[] commands = new ICommand[button];

    boolean[] status = new boolean[button];

    public void setCommands(int index, ICommand command) {
        commands[index] = command;
        status[index] = false;
    }
    
    public void pressButton(int index) {
        ICommand command = commands[index];
        if (command == null) {
            System.out.println("Please select the proper button");
        } else if (status[index]){
            command.undo();
        } else {
            command.execute();
            status[index] = true;
        }
    }

}