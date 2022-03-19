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
abstract class ToppingDecorator implements Pizza{
    
    public Pizza tempPizza;
    
    public ToppingDecorator(Pizza newPizza){
        tempPizza = newPizza;
    }
    
    @Override
    public String getDescription(){
        return tempPizza.getDescription();
    }
    
    @Override
    public double getCost(){
        return tempPizza.getCost();
    }
}
