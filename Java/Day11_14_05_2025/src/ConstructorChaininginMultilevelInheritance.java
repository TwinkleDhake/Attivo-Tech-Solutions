/* Q7.⁠ ⁠Constructor Chaining in Multilevel Inheritance
Write a program with three classes:
GrandParent with a constructor printing "Grandparent Constructor."
Parent that extends GrandParent with a constructor printing "Parent Constructor."
Child that extends Parent with a constructor printing "Child Constructor."
Task: Create an object of Child and observe the order of constructor calls. */
class GrandParent {
    GrandParent() {
        System.out.println("Grandparent Constructor.");
    }
}
class Parent extends GrandParent {
    Parent() {
        System.out.println("Parent Constructor.");
    }
}
class Child extends Parent {
    Child() {
        System.out.println("Child Constructor.");
    }
}
public class ConstructorChaininginMultilevelInheritance {
    public static void main(String[] args) {
        Child c = new Child();
    }
}