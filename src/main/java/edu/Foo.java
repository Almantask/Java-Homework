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
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.c);
    }

    public void Bar() {
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.c);
    }
    public void FooBar() {
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.c);
    }

}
