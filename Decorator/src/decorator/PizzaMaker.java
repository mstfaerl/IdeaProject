/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author m07er
 */
public class PizzaMaker {

    public static void main(String[] args) {

        Pizza basicPizza3 = new PlainPizza();
        System.out.println("Ingredients : " + basicPizza3.getDescription());
        System.out.println("Price : " + basicPizza3.getCost());
        System.out.println("-----------------------------");
        Pizza basicPizza2 = new TomatoSauce(new PlainPizza());
        System.out.println("Ingredients : " + basicPizza2.getDescription());
        System.out.println("Price : " + basicPizza2.getCost());
         System.out.println("-----------------------------");
        Pizza basicPizza1 = new Mozarella((new PlainPizza()));
        System.out.println("Ingredients : " + basicPizza1.getDescription());
        System.out.println("Price : " + basicPizza1.getCost());
        System.out.println("-----------------------------");
        Pizza basicPizza = new TomatoSauce(new Mozarella(new PlainPizza()));
        System.out.println("Ingredients : " + basicPizza.getDescription());
        System.out.println("Price : " + basicPizza.getCost());

    }

}
