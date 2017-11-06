/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw07;

import ch.hslu.ad.sw07.ParkingStrategies.ParkingStrategy;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class Car implements Callable<Boolean>{
    private static final Logger LOG = LogManager.getLogger(Car.class);
    private final ParkingStrategy parkingStrategy;
    private final long parkingDuration = (long)(1500 + Math.random());
    private int carNumber = 0;
    
    public Car(ParkingStrategy strategy, int carNumber){
        this.parkingStrategy = strategy;
        this.carNumber = carNumber;
    }
    
    public long getParkingDuration(){
        return this.parkingDuration;
    }

    @Override
    public Boolean call() throws Exception {
        return this.parkingStrategy.park(this);
    }
    
    @Override
    public String toString(){
        return "Car Number " + this.carNumber;
    }
}
