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
public class Threads {

    public static void main(String[] args) {
        new Threads1();
    }

}

class Threads1 implements Runnable {

    Thread thread;

    Threads1() {
        thread = new Thread(this, "Thread");
        System.out.println(thread.getName());
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("i : " + i);
                thread.sleep(600);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
