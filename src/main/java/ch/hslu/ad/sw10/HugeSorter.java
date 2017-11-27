/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw10;

import ch.hslu.ad.n41.array.sort.SortTask;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class HugeSorter {
     private static final Logger LOG = LogManager.getLogger(HugeSorter.class);

    
     public static void main(final String[] args) {
        long start;
        int[] data;
        int size = 20000;
        
        LOG.info("Starting sorting with " + size + " elements");
        LOG.info("------------------------------------------");
        // Insertion
        // Random
        data = new int[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        SortTask st = new SortTask(data);
        start = System.currentTimeMillis();
        
        logTime("Sort Task Time ", start);
     }
     
      public static void logTime(String name, long start){
        LOG.info(name + " took " + (System.currentTimeMillis() - start) + "ms to perform." );
    }
}
