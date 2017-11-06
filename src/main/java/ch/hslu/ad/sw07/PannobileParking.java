/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw07;

import ch.hslu.ad.sw07.ParkingStrategies.BestSuccessStrategy;
import ch.hslu.ad.sw07.ParkingStrategies.LazyStrategy;
import ch.hslu.ad.sw07.ParkingStrategies.ParkingStrategy;
import ch.hslu.ad.sw07.ParkingStrategies.TryNextStrategy;
import ch.hslu.ad.sw07.ParkingStrategies.TryNextWithWaitStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class PannobileParking {

    private static final Logger LOG = LogManager.getLogger(PannobileParking.class);
    private static final int NumberOfCarParks = 3;
    private static final int CarParkCapacity = 100;
    private static final int CarsToPark = 1000;

    private List<CarPark> carParks = new ArrayList<>(NumberOfCarParks);
    private List<Car> cars = new ArrayList<>(CarsToPark);

    private int succeeded = 0;
    private int failed = 0;

    public static void main(String args[]) {
        new PannobileParking().start();
    }

    private void start() {
        for (int i = 0; i < this.NumberOfCarParks; i++) {
            this.carParks.add(new CarPark(this.CarParkCapacity, i + 1));
        }
        for (int i = 0; i < this.CarsToPark; i++) {
            this.cars.add(new Car(this.getParkingStrategy(i), i + 1));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(cars.size());
        CompletionService<Boolean> completionService = new ExecutorCompletionService<>(executorService);
        String simulationDetails = String.format("%d car parks, %d spots per car park, %d cars visiting", this.NumberOfCarParks,
                this.CarParkCapacity, this.CarsToPark);
        System.out.println("starting simulation with " + simulationDetails);

        for (Car car : cars) {
            completionService.submit(car);
        }
        try {
            for (int n = 0; n < this.CarsToPark; n++) {
                boolean success = completionService.take().get();
                if (success) {
                    succeeded++;
                } else {
                    failed++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int quota = (int) (((float) succeeded / this.CarsToPark) * 100);
        LOG.info(String.format("done, %d cars did park, %d cars did not park (%d%% success)", succeeded, failed, quota));
        executorService.shutdown();
    }
    
    private ParkingStrategy getParkingStrategy(int i) {
            int s = i % 4;
            switch (s) {
            case 0:
                return new LazyStrategy(carParks);
            case 1:
                return new TryNextStrategy(carParks);
            case 2:
                return new TryNextWithWaitStrategy(carParks);
            case 3:
                return new BestSuccessStrategy(carParks);
            default:
                return null;
            }
    }

}
