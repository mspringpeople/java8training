package demo;

import java.util.function.BiConsumer;

/**
 * Created by marutsingh on 6/5/16.
 */
class InsurancePremium{

    String personName;
    double amount;

    public void printPersonAmount(BiConsumer<String,Double> printFormat){
        printFormat.accept(this.personName,this.amount);
    }

    public static void print(InsurancePremium premium){
        System.out.println(premium);
    }

    public int compareToIgnoreCase(String str) {
        return 1;
    }

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

