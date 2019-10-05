import java.util.ArrayList;
import java.util.List;


/*The following examples how to use the Builder Pattern to create a Pizza
The below example only uses 3 parameters in constrcutor but lets imagine a situation wherein the constructor has more than 5 parameters.
In such a case object creation becomes unmanageable.For Example: For a 6 parameter constructor in which the user may not want to pass all the params
during Object creation, the usual way would be to create all possible combinations of constructors to create that object which is insane and involves writing
lot of code.
Builder Pattern solves this problem and to briefly explain what it does:
Builder pattern is used to create instance of very complex object having telescoping constructor in easiest way.

The object creation becomes readable through builder pattern and client need not pass all the values needed for object creation in constructor.

To understand the Builder pattern Pros and cons in more detail, please refer the below well written medium article on the same:
https://medium.com/@ajinkyabadve/builder-design-patterns-in-java-1ffb12648850
 */
public class PizzaBuilder {
    private String crust;
    private String size;
    private List<String> toppings;

    //The All argument Constructor is made private and the params are exposed through the inner static Builder class
    private PizzaBuilder(String crust, String size, List<String> toppings) {
        this.crust = crust;
        this.size = size;
        this.toppings = toppings;
    }

    public static class Pizza {
        //Can add default values to parameters if needed to initialize with default values
        private String crust = "Thin Crust";
        private String size = "Small";
        private List<String> toppings = new ArrayList<>();

        Pizza() {
        }

        //Notice how the setter returns the current instance of the object instead of void, inorder to allow method chaining
        Pizza crust(String crust) {
            this.crust = crust;
            return this;
        }

        public Pizza size(String crust) {
            this.crust = crust;
            return this;
        }

        Pizza toppings(String crust) {
            this.toppings.add(crust);
            return this;
        }

        PizzaBuilder buildPizza() {
            return new PizzaBuilder(crust, size, toppings);
        }
    }

    @Override
    public String toString() {
        return "Your Pizza is ready with crust: " + this.crust + " size: " + this.size + " and toppings " + String.join(" , ", this.toppings);
    }
}
