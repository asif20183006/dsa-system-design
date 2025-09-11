package org.example.system.design.decorator.design.pattern;

public class DecoratorDesignPattern {

    public static void main(String[] args) {
        ICharacter mario = new Mario("Mario");
        System.out.println(mario.getAbility());

        mario = new HeightUpDecorator(mario);
        System.out.println(mario.getAbility());

        mario = new SpeedUpDecorator(mario);
        System.out.println(mario.getAbility());

        mario = new StarDecorator(mario);
        System.out.println(mario.getAbility());

        ICharacter sonic = new Mario("Sonic");

        sonic = new HeightUpDecorator(new SpeedUpDecorator(new StarDecorator(sonic)));
        System.out.println(sonic.getAbility());

    }

}

interface ICharacter {
    String getAbility();
}

interface Decorator extends ICharacter {

    @Override
    String getAbility();
}

class Mario implements ICharacter {

    String name;
    Mario(String name) {
        this. name = name;
    }
    @Override
    public String getAbility() {
        return name;
    }
}

class HeightUpDecorator implements Decorator {

    ICharacter ch;
    public HeightUpDecorator(ICharacter ch) {
        this.ch = ch;
    }

    @Override
    public String getAbility() {
        return ch.getAbility() + " with HeightUp";
    }
}

class SpeedUpDecorator implements Decorator {

    ICharacter ch;
    public SpeedUpDecorator(ICharacter ch) {
        this.ch = ch;
    }

    @Override
    public String getAbility() {
        return ch.getAbility() + " with SpeedUp";
    }
}

class StarDecorator implements Decorator {

    ICharacter ch;
    public StarDecorator(ICharacter ch) {
        this.ch = ch;
    }

    @Override
    public String getAbility() {
        return ch.getAbility() + " with Start power for 10 days";
    }
}

