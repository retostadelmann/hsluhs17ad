/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw07.ParkingStrategies;

import ch.hslu.ad.sw07.Car;

/**
 *
 * @author reto.stadelmann
 */
public interface ParkingStrategy {

    /**
     * Parks the car
     * @param car
     * @return 
     */
    public boolean park(Car car) throws Exception;
    
}
