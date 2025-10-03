package org.example.system.design.chain.of.responsibility.design.pattern;

public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {

        ThousandHandler thousandHandler = new ThousandHandler(3);
        FiveHundredsHandler fiveHundredsHandler = new FiveHundredsHandler(10);
        OneHundredHandler oneHundredHandler = new OneHundredHandler(20);

        thousandHandler.setNextHandler(fiveHundredsHandler);
        fiveHundredsHandler.setNextHandler(oneHundredHandler);


        thousandHandler.dispatchAmount(2600);


    }

}

interface MoneyHandler {
    void dispatchAmount(int amount);
    void setNextHandler(MoneyHandler nextHandler);
}

class ThousandHandler implements MoneyHandler {

    private MoneyHandler nextMoneyHandler;
    private int numberOfNotes = 0;

    public ThousandHandler(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    @Override
    public void dispatchAmount(int amount) {

        int notRequired = amount / 1000;


        if (notRequired > numberOfNotes) {
            notRequired = numberOfNotes;
            numberOfNotes = 0;
        } else {
            numberOfNotes -= notRequired;
        }

        if (notRequired > 0) {
            System.out.println("Dispatching "+ notRequired + " * 1000");
        }

        int remainingMoney= amount - notRequired*1000;

        if (remainingMoney > 0) {
            if (nextMoneyHandler != null) {
                nextMoneyHandler.dispatchAmount(remainingMoney);
            } else {
                System.out.println("Money can not be dispatched further: " + remainingMoney);
            }
        }

    }

    @Override
    public void setNextHandler(MoneyHandler nextHandler) {
        this.nextMoneyHandler = nextHandler;
    }
}

class FiveHundredsHandler implements MoneyHandler {

    private MoneyHandler nextMoneyHandler;
    private int numberOfNotes = 0;

    public FiveHundredsHandler(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    @Override
    public void dispatchAmount(int amount) {

        int notRequired = amount / 500;


        if (notRequired > numberOfNotes) {
            notRequired = numberOfNotes;
            numberOfNotes = 0;
        } else {
            numberOfNotes -= notRequired;
        }


        if (notRequired > 0) {
            System.out.println("Dispatching "+ notRequired + " * 500");
        }

        int remainingMoney= amount - notRequired*500;

        if (remainingMoney > 0) {
            if (nextMoneyHandler != null) {
                nextMoneyHandler.dispatchAmount(remainingMoney);
            } else {
                System.out.println("Money can not be dispatched further: " + remainingMoney);
            }
        }

    }

    @Override
    public void setNextHandler(MoneyHandler nextHandler) {
        this.nextMoneyHandler = nextHandler;
    }
}
class OneHundredHandler implements MoneyHandler {

    private MoneyHandler nextMoneyHandler;
    private int numberOfNotes = 0;

    public OneHundredHandler(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    @Override
    public void dispatchAmount(int amount) {

        int notRequired = amount / 100;


        if (notRequired > numberOfNotes) {
            notRequired = numberOfNotes;
            numberOfNotes = 0;
        } else {
            numberOfNotes -= notRequired;
        }


        if (notRequired > 0) {
            System.out.println("Dispatching "+ notRequired + " * 100");
        }

        int remainingMoney= amount - notRequired*100;

        if (remainingMoney > 0) {
            if (nextMoneyHandler != null) {
                nextMoneyHandler.dispatchAmount(remainingMoney);
            } else {
                System.out.println("Money can not be dispatched further: " + remainingMoney);
            }
        }

    }

    @Override
    public void setNextHandler(MoneyHandler nextHandler) {
        this.nextMoneyHandler = nextHandler;
    }
}
