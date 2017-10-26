/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw06;

import jdk.nashorn.internal.objects.NativeArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public final class Turf {

    private static final Logger LOG = LogManager.getLogger(Turf.class);

    public static void main(final String[] args) throws InterruptedException  {
        Synch starterBox = new Latch();
        Thread[] raceHorses = new Thread[6];
        
        for (int i = 1; i < 6; i++) {
            raceHorses[i] = new Thread(new RaceHorse(starterBox), "Horse " + i);
            raceHorses[i].start();
        }
        LOG.info("Start...");
        starterBox.release();
        
        for (int i = 1; i < 6; i++) {
            
            raceHorses[i].interrupt();
        }
        
    }
}
