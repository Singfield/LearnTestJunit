package junitItescia;

import junitItescia.services.Money;

public class App {
    
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        try {
            Money test =new Money(10, "NOK");
        } catch (Exception e) {
            System.out.println("nok");
        }
        
    }
    
}
