package class1.chaining;

import entity.Car;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by marutsingh on 5/22/16.
 */
public class MethodChaining {

    public static void methodChaining1(List<String> carNames){
        UnaryOperator<String> trimFunction = String::trim;
        UnaryOperator<String> toUpperCaseFunction = String::toUpperCase;

        carNames.stream().map(trimFunction.andThen(toUpperCaseFunction))
        .forEach(car -> System.out.println(car));
    }

    public static void methodChaining2(List<String> carNames){
        UnaryOperator<String> trimFunction = String::trim;
        UnaryOperator<String> toUpperCaseFunction = String::toUpperCase;

        carNames.stream().map(trimFunction.andThen(toUpperCaseFunction))
                .forEach(System.out::println);
    }
}
