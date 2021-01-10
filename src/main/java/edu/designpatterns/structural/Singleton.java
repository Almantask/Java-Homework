package edu.designpatterns.structural;

public class Singleton {

    private final Object data1;
    private final Object data2;

    private static Singleton instance;

    public Singleton(Object data1, Object data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton(new Object(), new Object());
        }
        return instance;
    }

    public Object getData1() {
        return data1;
    }

    public Object getData2() {
        return data2;
    }
}
