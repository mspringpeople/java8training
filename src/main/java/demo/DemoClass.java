package demo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by marutsingh on 6/4/16.
 */
public class DemoClass {

    public static void main(String[] args){

        List<InsurancePremium> premiumList = new ArrayList<>();
        InsurancePremium insurancePremium = new InsurancePremium();
        insurancePremium.setPersonName("Manjush");
        insurancePremium.setAmount(200);

        premiumList.add(insurancePremium);
        premiumList.get(0);

        premiumList.size();
        premiumList.stream().count();


        List<Integer> integerList = new ArrayList<>();
        for (int i = 0 ; i < 10; i++){
            integerList.add(2);
        }

        printDistinct(integerList);

        List<Integer> doubleList = new ArrayList<>();
        for (Integer integer : integerList){
           if (integer.intValue() % 2 == 0){
               System.out.println(integer);
           }
        }

        integerList.stream()
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(i));

        integerList.stream()
                .map(i -> i*2).map(i -> i*4)
                .forEach(i -> System.out.println(i));

        integerList.stream().sorted((i1,i2) -> i1 * i2);

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");

        stringList.stream().map(String::toUpperCase).forEach(System.out::println);


        //First version
        for (InsurancePremium premium : premiumList){
            System.out.println(premium.toString());
        }

        //Second version
        premiumList.forEach(new InsurancePremiumConsumer());

        //Third Version
        premiumList.forEach(new Consumer<InsurancePremium>() {
            @Override
            public void accept(InsurancePremium insurancePremium) {
                System.out.println(insurancePremium.toString());
            }
        });

        //Fourth Version
        premiumList.forEach((pr) -> pr.printPersonAmount((x,y) -> System.out.println(String.format("%s_%s",x,y)) ));


        Consumer<InsurancePremium> premiumLambda = (InsurancePremium pr) -> System.out.print(pr.toString());
    }

    void useMethodReference(List<InsurancePremium> premiumList){
       //Static method reference
        premiumList.forEach(InsurancePremium::print);
        premiumList.stream().map(InsurancePremium::getAmount).forEach(System.out::println);
        String[] data = {"a","b"};
    }

    static void printDistinct(List<Integer> inputList){
        inputList.stream().distinct().forEach(i -> System.out.println(i));
    }

    static void printPremium(Consumer<InsurancePremium> premiumLambda,InsurancePremium pr){
        premiumLambda.accept(pr);
    }

    static class InsurancePremiumConsumer implements Consumer<InsurancePremium> {
        @Override
        public void accept(InsurancePremium insurancePremium) {
            System.out.println(insurancePremium.toString());
        }
    }

    static class PremiumCalculator<T> {
        public void calculate(List<InsurancePremium> premiumList, T strategy){
            for (InsurancePremium insurancePremium : premiumList){
                //Go to database
                //Get some properties
                //Calculate premium using passed strategy
            }
        }
    }
}

class PremiumList {
    List<InsurancePremium> premiums = new ArrayList<>();

    public List<InsurancePremium> getPremiums() {
        return premiums;
    }

    public void setPremiums(List<InsurancePremium> premiums) {
        this.premiums = premiums;
    }
}

