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
public class Mozarella extends ToppingDecorator{
    
    public Mozarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Dough");
        System.out.println("Adding Moz");
    }
    
    @Override
    public String getDescription(){
        return tempPizza.getDescription() + ", Mozarella";
    }
    
    @Override
    public double getCost(){
        return tempPizza.getCost() + .50;
    }
    
}
