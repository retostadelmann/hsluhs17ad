/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw06;

/**
 *
 * @author reto.stadelmann Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool {

    private static final Object lock = new Object();

    public static void main(final String args[]) throws InterruptedException {
        MyTask waiter = new MyTask(lock);

        new Thread(waiter).start();
        Thread.sleep(500);
        
        synchronized (waiter) {
            waiter.notify();
        }
    }
}
