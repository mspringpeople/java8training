package demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by marutsingh on 6/5/16.
 */
public class DemoClass2 {

    public static void main(String[] args){

        //First attempt
        Function<String,Integer> parseIntFunction = (String s) -> Integer.parseInt(s);

        Function<String,Integer> parseIntFunction2 = Integer::parseInt;

        String[] intStringArray = {"1","2","3","4"};

        Arrays.asList(intStringArray).stream().filter(s -> s.equals("1"));

       //Arrays.asList(intStringArray).stream().map(Integer::parseInt).forEach(System.out::println);
        InsurancePremium insurancePremium = new InsurancePremium();
        insurancePremium.setPersonName("Marut");

        Arrays.asList(intStringArray).stream().map(Integer::parseInt)
                    .map(i -> i * 2).map(i -> i * 2).forEach(System.out::println);

        List<InsurancePremium> premiumList = new ArrayList<>();
        premiumList.add(insurancePremium);

        insurancePremium = new InsurancePremium();
        insurancePremium.setPersonName("Marut");
        premiumList.add(insurancePremium);

        insurancePremium = new InsurancePremium();
        insurancePremium.setPersonName("Singh");
        premiumList.add(insurancePremium);

        Map<String, Long> counted =
                premiumList.stream().collect(Collectors.groupingBy(InsurancePremium::getPersonName,Collectors.counting()));


        insurancePremium.setPersonName("Manjush");
        insurancePremium.setAmount(200);
        InsurancePremiumCalculator insurancePremiumCalculator = new InsurancePremiumCalculator();
        Optional<InsurancePremium> insurancePremium1 =  insurancePremiumCalculator.getHighestPremium();
        if ( insurancePremium1.isPresent() ){
            InsurancePremium insurancePremium2 =  insurancePremium1.get();
        }
        double amount = insurancePremiumCalculator.getHighestPremium().get().getAmount();

        Function<Integer, Double> medicalStuffTaxCalculator = (iadfadf) -> iadfadf * 5.3;
        Function<Integer, Double> grocerryStuffTaxCalculator = (i) -> i  +  5.3;

        double newAmount = insurancePremiumCalculator.calculate(10,medicalStuffTaxCalculator);
        double newGrocerryAmount = insurancePremiumCalculator.calculate(10,grocerryStuffTaxCalculator);
        System.out.println(newAmount);
    }

    public static List<Integer> getFourTimesValues(String[] intStringArray){
        return Arrays.asList(intStringArray).stream().map(Integer::parseInt)
                .map(i -> i * 2).map(i -> i * 2).collect(Collectors.toList());
    }
}



@FunctionalInterface
interface InsurancePremiumFilter {
    boolean filter(InsurancePremium premium);
    default  void filter2(){
        System.out.print("Dummy");
    }
}

class InsurancePremiumCalculator {
    private double SERVICE_TAX = 10.0;
    private double VAT_TAX = 20.0;

    public double calculate(Integer itemCount,Function<Integer,Double> function){
        return  SERVICE_TAX + VAT_TAX + function.apply(itemCount);
    }

    public Optional<InsurancePremium> getHighestPremium(){
        //Run some logic
        InsurancePremium insurancePremium = new InsurancePremium();
        return Optional.ofNullable(insurancePremium);
    }
}
