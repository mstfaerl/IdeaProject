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
public class Threads2 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());

        thread3.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY); //genellikle file işlemlerinde minpriority

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

//Thread1
class Thread1 extends Thread {

    Thread thread1;

    Thread1() {
        thread1 = new Thread(this, "Thread1 : ");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 : " + i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//Thread2

class Thread2 extends Thread {

    Thread thread2;

    Thread2() {
        thread2 = new Thread(this, "Thread2 : ");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 : " + i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

class Thread3 extends Thread {

    Thread thread3;

    Thread3() {
        thread3 = new Thread(this, "Thread3 : ");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 3 : " + i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
