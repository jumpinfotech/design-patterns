This project is located:-
https://github.com/jumpinfotech/design-patterns


### ChatGPT

In Java, the following design patterns are widely used, arranged in no particular order:

* Singleton
* Factory Method
* Observer
* Decorator
* Strategy
* Command
* Facade
* Composite
* Iterator
* Model-View-Controller (MVC)

In this repository the following patterns are showcased:
* Command
* Decorator
* Singleton
* Strategy
* Template



### Template Method

Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. 

Allowing subclasses to redefine certain steps of an algorithm without changing the algorithm's structure.

Encapsulates common behavior + allows customization of the individual objects.

The Template Method should be used when you want to allow subclasses to alter parts of an algorithm, but keep the algorithm's structure intact.

##### Key parts from example

Algorithm is in the abstract parent class:-

    public abstract class PizzaMaker {

    public void makePizza() {
        addToppings();
        bakePizza();
        if (customerWantsPackedPizza()) {
            packPizza();
        }
    }

    abstract void addToppings();

    void bakePizza() {
        System.out.println("Baking pizza at 400 F for 12 minutes.");
    }

    void packPizza() {
        System.out.println("Packing pizza in pizza delivery box.");
    }

    boolean customerWantsPackedPizza() {
        return true;
    }

Don't pack the pizza:-

    public class InHouseAssortedPizzaMaker extends PizzaMaker {

    @Override
    public void addToppings() {
    System.out.println("Adding cheddar cheese and  bechamel sauce along with ingredients to crust.");
    }

    @Override
    public boolean customerWantsPackedPizza() {
        return false;
    }

Pizza is packed by default:-
    
    public class VegPizzaMaker extends PizzaMaker {

    @Override
    public void addToppings() {
        System.out.println("Adding mozzerella cheese and tomato sauce along with ingredients to crust.");
    }



Running code:-

    PizzaMaker vegPizzaMaker = new VegPizzaMaker();
    vegPizzaMaker.makePizza();
    PizzaMaker inHouseAssortedPizzaMaker = new InHouseAssortedPizzaMaker();
    inHouseAssortedPizzaMaker.makePizza();


### Strategy pattern

An object can change its behavior at runtime.

Defines a family of algorithms, encapsulating each one and makes them interchangeable.

Decouples the choice of an algorithm from the object that uses it.

Instead of hard-coding the behavior of an object, you can select from any interchangeable algorithms at runtime.

Allows you to write clean, reusable code and make it easy to add new algorithms or modify existing ones.
