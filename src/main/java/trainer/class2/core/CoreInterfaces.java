package trainer.class2.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Created by marutsingh on 6/1/16.
 */
public class CoreInterfaces {


    static void display(Supplier<Integer> arg) {
        System.out.println(arg.get());
    }

    public static void main(String[] args) {
        // Pass lambdas to the display method.
        // ... These conform to the Supplier class.
        // ... Each returns an Integer.
        display(() -> 10);
        display(() -> 100);
        display(() -> (int) (Math.random() * 100));
    }

    static void predicateExample(){
        String[] animals = {"cat","dog","deer"};
        // Remove elements that start with c.
        Arrays.asList(animals).removeIf(element -> element.startsWith("c"));
    }
}
