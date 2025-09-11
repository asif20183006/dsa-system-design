package org.example.system.factory.design.pattern;

public class AbsTractMethodFactoryDesignPattern {
    public static void main(String[] args) {

        AbsTractFactory absTractFactory = new kingsBurger();

        Bread bread = absTractFactory.prepareBread("Small");
        Burger burger = absTractFactory.prepareBurger("Small");
        bread.prepare();
        burger.prepare();

    }
    
}

interface Bread {
    void prepare();
}

class SmallBread implements Bread {

    @Override
    public void prepare() {
        System.out.println("Preparing small Bread");
    }
}

class LargeBread implements Bread {

    @Override
    public void prepare() {
        System.out.println("Preparing Large Bread");
    }
}



class StandardBread implements Bread {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Bread");
    }
}

class WheatSmallBread implements Bread {

    @Override
    public void prepare() {
        System.out.println("Preparing small Wheat Bread");
    }
}

class WheatLargeBread implements Bread {

    @Override
    public void prepare() {
        System.out.println("Preparing Large Wheat Bread");
    }
}
class WheatStandardBread implements Bread {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Bread");
    }
}



interface AbsTractFactory {
    Bread prepareBread(String type);
    Burger prepareBurger(String type);
}

class singsBurger implements AbsTractFactory {


    @Override
    public Burger prepareBurger(String type) {
        return switch (type) {
            case "Small" -> new SmallBurger();
            case "Large" -> new LargeBurger();
            case "Standard" -> new StandardBurger();
            default -> null;
        };
    }

    @Override
    public Bread prepareBread(String type) {
        return switch (type) {
            case "Small" -> new SmallBread();
            case "Large" -> new LargeBread();
            case "Standard" -> new StandardBread();
            default -> null;
        };
    }
}

class kingsBurger implements AbsTractFactory {


    @Override
    public Burger prepareBurger(String type) {
        return switch (type) {
            case "Small" -> new WheatSmallBurger();
            case "Large" -> new WheatLargeBurger();
            case "Standard" -> new WheatStandardBurger();
            default -> null;
        };
    }

    @Override
    public Bread prepareBread(String type) {
        return switch (type) {
            case "Small" -> new WheatSmallBread();
            case "Large" -> new WheatLargeBread();
            case "Standard" -> new WheatStandardBread();
            default -> null;
        };
    }
}

