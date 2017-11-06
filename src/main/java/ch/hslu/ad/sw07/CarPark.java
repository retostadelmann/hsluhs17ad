/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw07;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class CarPark {

    private static final Logger LOG = LogManager.getLogger(CarPark.class);
    private final int capacity, number;
    private int occupied = 0;
   // private final BlockingQueue queue;

    public CarPark(final int capacity, final int number) {
        //this.queue = new ArrayBlockingQueue(capacity);
        this.capacity = capacity;
        this.number = number;
    }   
    
   /*public void enterQueue(final Car car) throws InterruptedException{
        this.queue.put(car);
    }
    
    public void enterQueue(final Car car, final int timeout) throws InterruptedException{
        this.queue.offer(car, timeout, TimeUnit.MILLISECONDS);
    }
    */
    public synchronized void enter(Car car) throws InterruptedException {
        if(freeParkingFields() <= 0){
            this.wait();
        }
        
        if (occupied < capacity) {
            occupied++;
            LOG.info(car + " entered " + this);
        } else {
            throw new IllegalStateException("Can't enter car park, it's full.");
        }
    }
    
    public synchronized void leave(Car car) {
        occupied--;
        this.notify();
        LOG.info(car + " left " + this);
    }

    public synchronized int freeParkingFields() {
        return capacity - occupied;
    }

    @Override
    public String toString() {
        return String.format("Car Park #%d, %d/%d occupied", number, occupied, capacity);
    }
}
