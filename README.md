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

The Template Method should be used when you want to allow subclasses to alter parts of an algorithm, but keep the
algorithm's structure intact.

##### Key parts from example

Running code:-

    PizzaMaker vegPizzaMaker = new VegPizzaMaker();
    vegPizzaMaker.makePizza();
    PizzaMaker inHouseAssortedPizzaMaker = new InHouseAssortedPizzaMaker();
    inHouseAssortedPizzaMaker.makePizza();

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


### Factory Method Design Pattern

Hard coding class names results in increasing complex code management as you add classes.
“Program to an interface, not an implementation“ - leads to polymorphism.
Object creation is centralized in the ConcreteCreator, any changes to a Product or any ConcreteProduct doesn't affect
the Client.

No concrete Pizza objects are created in the code. Adding / removing Pizza implementation classes? The client / test
code doesn't need updating.

Java APIs + frameworks extensively use the factory method pattern.
The factory method pattern helps encapsulate object creation code from client code, decoupling your client code from the
concrete classes you need to instantiate. Using this pattern you will have a centralized location for object creation
code - easier to debug + troubleshoot.

##### Key parts from example

    @Test
    public void testMakePizzas(){
        BasePizzaFactory pizzaFactory = new PizzaFactory();
        Pizza cheesePizza = pizzaFactory.createPizza("cheese"); ...
    }

    public abstract class BasePizzaFactory {
        public abstract Pizza createPizza(String type);
    }

    public class PizzaFactory extends BasePizzaFactory{
        @Override
        public Pizza createPizza(String type){
            Pizza pizza;
            switch (type.toLowerCase())
            {
                case "cheese":
                pizza = new CheesePizza();
                break; .....
                default: throw new IllegalArgumentException("No such pizza.");
            }
            pizza.addIngredients();
            pizza.bakePizza();
            return pizza;
    }


    public abstract class Pizza {
        public abstract void addIngredients();
    
        public void bakePizza() { 
            System.out.println("Pizza baked at 400 for 20 mins."); 
        }
    }

    public class CheesePizza extends Pizza {
    
        @Override
        public void addIngredients() {
            System.out.println("Preparing ingredients for cheese pizza.");
        }
    }

### Strategy pattern

An object can change its behavior at runtime.

Defines a family of algorithms, encapsulating each one and makes them interchangeable.

Decouples the choice of an algorithm from the object that uses it.

Instead of hard-coding the behavior of an object, you can select from any interchangeable algorithms at runtime.

Allows you to write clean, reusable code and make it easy to add new algorithms or modify existing ones.
