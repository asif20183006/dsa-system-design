package org.example.system.factory.design.pattern;

public class MethodFactoryDesignPattern {
    public static void main(String[] args) {

        MethodBurgerFactory burgerFactory = new SinghBurgerFactory();

        Burger burger = burgerFactory.prepareBurger("Small");

        burger.prepare();

    }

}

interface MethodBurgerFactory {
    Burger prepareBurger(String type);
}

class WheatSmallBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing small wheat burger");
    }
}

class WheatLargeBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Large Wheat burger");
    }
}
class WheatStandardBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat burger");
    }
}


class SinghBurgerFactory implements MethodBurgerFactory {

    @Override
    public Burger prepareBurger(String type) {
        return switch (type) {
            case "Small" -> new SmallBurger();
            case "Large" -> new LargeBurger();
            case "Standard" -> new StandardBurger();
            default -> null;
        };
    }
}

class KingBurgerFactory implements MethodBurgerFactory {

    @Override
    public Burger prepareBurger(String type) {
        return switch (type) {
            case "Small" -> new WheatSmallBurger();
            case "Large" -> new WheatLargeBurger();
            case "Standard" -> new WheatStandardBurger();
            default -> null;
        };
    }
}