package junitItescia.services;

import java.util.Arrays;

public class Money {
    private int fAmount;
    private String fCurrency;

    private static String[] possibleCurrency={"EUR","USD","CHF","GBP"};

    public Money(int fAmount, String fCurrency) throws Exception {
        boolean verify=Arrays.stream(possibleCurrency).anyMatch(x->x==fCurrency);
        System.out.println(verify);
        if ( this.fAmount <0 ) {
            throw new Exception("incorrect amount value ");
        }
        if ( !verify) {
            throw new Exception ("incorrect currency value");
        }
        
            this.fAmount = fAmount;
            this.fCurrency = fCurrency;
            System.out.println("ok obj creer");

    }

    public int getFAmount() {
        return this.fAmount;
    }

    public void setFAmount(int fAmount) {
        this.fAmount = fAmount;
    }

    public String getFCurrency() {
        return this.fCurrency;
    }

    public void setFCurrency(String fCurrency) {
        this.fCurrency = fCurrency;
    }

    @Override
    public String toString() {
        return "{" +
            " fAmount='" + getFAmount() + "'" +
            ", fCurrency='" + getFCurrency() + "'" +
            "}";
    }

    public int amount(){
        return this.fAmount;
    }

    public String currency(){
        return this.fCurrency;
    }

    public Money add(Money m) throws Exception {
       
        if (m.getFCurrency()!=this.getFCurrency()){
            throw new Exception("error please verify currency");
        } 
        if (m.getFAmount()<=0){
            throw new Exception("error in object add methode please add positive amount value");
        }
        return new Money (getFAmount()+ m.getFAmount(), getFCurrency());
    }
    public Money add(int namount, String ncurrency) throws Exception{
        if(ncurrency != this.getFCurrency()){
            throw new Exception("error please verify currency (not obj)");
        }
        return new Money (getFAmount()+ namount, currency());
    }

}