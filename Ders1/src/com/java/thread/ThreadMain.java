/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.thread;

/**
 *
 * @author m07er
 */
public class ThreadMain {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        thread.setName("Ana Thread");
        System.out.println(thread.getName());
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                thread.sleep(1000);
            }
        } catch (InterruptedException ıe) {
            System.out.println(ıe);
        }

    }

}
