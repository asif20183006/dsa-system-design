package org.example.system.singelton.design.pattern;

public class SingleTonDesignPatternExample {

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.createInstance();
        SingleTon singleTon1 = SingleTon.createInstance();

        System.out.println(singleTon1 == singleTon);
    }

}


class SingleTon {

    private SingleTon() {
        System.out.println("new object created for ");
    }

    static SingleTon singleTon = null;

    public static SingleTon createInstance() {

        if (singleTon == null)
        {
            synchronized (SingleTon.class) { // or use lazy initialization
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }

        }

        return singleTon;
    }
}





