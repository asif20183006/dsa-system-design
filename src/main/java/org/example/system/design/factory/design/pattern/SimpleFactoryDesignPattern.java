package org.example.system.factory.design.pattern;

public class SimpleFactoryDesignPattern {
    public static void main(String[] args) {
        Burger burger = BurgerFactory.createBurger("Standard");
        burger.prepare();
    }

}

interface Burger {
    void prepare();
}

class SmallBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing small burger");
    }
}

class LargeBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Large burger");
    }
}
class StandardBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard burger");
    }
}

class BurgerFactory {

    public static Burger createBurger(String type) {

        return switch (type) {
            case "Small" -> new SmallBurger();
            case "Large" -> new LargeBurger();
            case "Standard" -> new StandardBurger();
            default -> null;
        };

    }

}

