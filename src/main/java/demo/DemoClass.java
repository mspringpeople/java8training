package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

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
                .forEach(i -> System.out.print(i));



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
        premiumList.forEach((pr) -> premiumList.toString());
        premiumList.stream().forEach((pr) -> premiumList.toString());
        premiumList.stream().map((pr) -> {return premiumList.toString();});

        Consumer<InsurancePremium> premiumLambda = (InsurancePremium pr) -> System.out.print(pr.toString());
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

    static class InsurancePremium{

        String personName;
        double amount;

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "InsurancePremium{" +
                    "personName='" + personName + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }
}
