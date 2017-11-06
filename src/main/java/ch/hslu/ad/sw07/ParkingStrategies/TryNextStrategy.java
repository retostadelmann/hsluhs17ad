/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw07.ParkingStrategies;

import ch.hslu.ad.sw07.Car;
import ch.hslu.ad.sw07.CarPark;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class TryNextStrategy implements ParkingStrategy {

    private static final Logger LOG = LogManager.getLogger(TryNextStrategy.class);
    private final List<CarPark> carParks;

    public TryNextStrategy(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    @Override
    public boolean park(Car car) throws Exception {

        for (CarPark carPark : carParks) {
            if(carPark.freeParkingFields() <= 0){
                continue;
            }
            
            try {
                carPark.enter(car);
            } catch (IllegalStateException e) {
                LOG.error("Error accessing the car park.");
                return false;
            }
            try {
                Thread.sleep(car.getParkingDuration());
            } catch (InterruptedException e) {
                throw new Exception(e);
            }

            carPark.leave(car);

            return true;
        }
        
        // No Parking found, return
        LOG.error("No spot found in the car parks with TryNextStrategy for car " + car);
        return false;
    }
}
