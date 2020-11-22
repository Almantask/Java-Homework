package edu.Revision;

public class Demo {
    public static void run(){
        Child child1 = new Child();
        Parent parent1 = new Parent();
        Child child2 = new Child();
        Parent parent2 = new Parent();
        Child child3 = new Child();
        Parent parent3 = new Parent();

        // Polymorphism
        Parent[] parents = {child1, parent1, child2, parent2, child3, parent3};
        for (Parent parent :
                parents) {
            parent.DoSomethingOfParent();
        }

        // Without polymorphism
        parent1.DoSomethingOfParent();
        child1.DoSomethingOfParent();
        parent2.DoSomethingOfParent();
        child2.DoSomethingOfParent();
        parent3.DoSomethingOfParent();
        child3.DoSomethingOfParent();

        Student student = new UniversityStudent();
    }
}
