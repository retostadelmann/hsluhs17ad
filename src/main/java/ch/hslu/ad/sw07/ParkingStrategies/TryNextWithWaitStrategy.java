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
public class TryNextWithWaitStrategy implements ParkingStrategy {

    private static final Logger LOG = LogManager.getLogger(TryNextWithWaitStrategy.class);
    private final List<CarPark> carParks;
    private boolean hasWaited = false;

    private final int WaitTime = 1500;

    public TryNextWithWaitStrategy(List<CarPark> carParks) {
        this.carParks = carParks;
    }

    @Override
    public boolean park(Car car) throws Exception {
        for (CarPark carPark : carParks) {
            if (carPark.freeParkingFields() <= 0 && !hasWaited) {
                Thread.sleep(WaitTime);
                if (carPark.freeParkingFields() <= 0) {
                    continue;
                }
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
        LOG.error("No spot found in the car parks with TryNextWithWaitStrategy for car " + car);
        return false;
    }
}
