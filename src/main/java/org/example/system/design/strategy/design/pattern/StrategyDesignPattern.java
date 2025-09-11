package org.example.system.strategy.design.pattern;

public class StrategyDesignPattern {

    public static void main(String[] args) {

        CompanionRobot companionRobot = new CompanionRobot(new NormalTalk(), new NormalWalk(), new DoesNotFly());

        companionRobot.fly();
        companionRobot.talk();
        companionRobot.walk();
        companionRobot.project();



    }
}

interface Talkable {
    void talk();
}

interface Walkable {
    void walk();
}


interface Flyable {
    void fly();
}


class NormalFly implements Flyable {

    @Override
    public void fly() {
        System.out.println("Hi I can fly normal");
    }
}

class DoesNotFly implements Flyable {

    @Override
    public void fly() {
        System.out.println("Hi I can not fly normal");
    }
}

class NormalWalk implements Walkable {

    @Override
    public void walk() {
        System.out.println("Hi I can walk normal");
    }
}

class DoesNotWalk implements Walkable {

    @Override
    public void walk() {
        System.out.println("Hi I can not Walk normal");
    }
}

class DoesNotTalk implements Talkable {

    @Override
    public void talk() {
        System.out.println("Hi I can not talk normal");
    }
}


class NormalTalk implements Talkable {

    @Override
    public void talk() {
        System.out.println("Hi I can talk normal");
    }
}

abstract class Robot {
    Talkable talkable;
    Walkable walkable;
    Flyable flyable;

    Robot(Talkable talkable, Walkable walkable, Flyable flyable) {
        this.flyable = flyable;
        this.talkable = talkable;
        this.walkable = walkable;
    }

    void talk() {
        talkable.talk();
    }

    void walk() {
        walkable.walk();
    }

    void fly() {
        flyable.fly();
    }

    abstract void project();
}


class CompanionRobot extends Robot {

    CompanionRobot(Talkable talkable, Walkable walkable, Flyable flyable) {
        super(talkable, walkable, flyable);
    }
    @Override
    void project() {

        System.out.println("This is CompanionRobot");
    }
}
