package edu;

public class Foo {

    int a;
    String b;
    double c;

    public Foo(int a, String b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void Foo() {
        System.out.println("Subtract");
        System.out.println(this.a - this.c);
    }

    public void Bar() {
        System.out.println("add and print string");
        System.out.println(this.a + this.c);
        System.out.println(this.b);
    }
    public void FooBar() {
        System.out.println("multiply and print something");
        System.out.println(this.a * this.c);
        System.out.println(this.b + "ne");
    }

}
