/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author m07er
 */
public class QueueMain {
    
    public static void main(String[] args) {
        
        Queue<String> que = new LinkedList();
        
        que.add("AddMustafa");
        que.add("AddErol");
        que.offer("OfferMustafa");
        que.offer("OfferErol");
        
        System.out.println(que);
        
        que.element();    
        System.out.println("Element : " + que);
        
        que.peek();
        System.out.println("Peek : " + que);
        
        que.remove();
        System.out.println("Remove : " + que);
        
        que.poll();
        System.out.println("Pool : " + que);
        
    }
}
