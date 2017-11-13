/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw08;

import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class SortDemo {
        private static final Logger LOG = LogManager.getLogger(SortDemo.class);

    public static void main(final String args[]) {
        long start;
        Integer[] data;
        int size = 40000;
        
        LOG.info("Starting sorting with " + size + " elements");
        LOG.info("------------------------------------------");
        // Insertion
        // Random
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        start = System.currentTimeMillis();
        Sort.insertionSort(data);
        logTime("Random insertion sort", start);
        
        // int random
        // Random
        int[] data2 = new int[size];
        for(int i = 0; i < data2.length; i++){
            data2[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        start = System.currentTimeMillis();
        Sort.insertionSortint(data2);
        logTime("Random insertion sort on int", start);
        
        // sorted
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        
        start = System.currentTimeMillis();
        Sort.insertionSort(data);
        logTime("Sorted insertion sort", start);
 
        // reverse
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = data.length -1 - i;
        }
        
        start = System.currentTimeMillis();
        Sort.insertionSort(data);
        logTime("Reverse insertion sort", start);
        
        // Selection
        // Random
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        start = System.currentTimeMillis();
        Sort.selectionSort(data);
        logTime("Random selection sort", start);
        
        // sorted
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        
        start = System.currentTimeMillis();
        Sort.selectionSort(data);
        logTime("Sorted selection sort", start);
 
        // reverse
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = data.length -1 - i;
        }
        
        start = System.currentTimeMillis();
        Sort.selectionSort(data);
        logTime("Reverse selection sort", start);
        
        // Bubble
        // Random
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort(data);
        logTime("Random bubble sort", start);
        
        // sorted
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort(data);
        logTime("Sorted bubble sort", start);
 
        // reverse
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = data.length -1 - i;
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort(data);
        logTime("Reverse bubble sort", start);
        
        // Bubble with Early Exit
        // Random
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort2(data);
        logTime("Random bubble Early Exit sort", start);
        
        // sorted
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort2(data);
        logTime("Sorted bubble Early Exit sort", start);
 
        // reverse
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = data.length -1 - i;
        }
        
        start = System.currentTimeMillis();
        Sort.bubbleSort2(data);
        logTime("Reverse bubble Early Exit sort", start);
        
        // Shell
        // Random
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        start = System.currentTimeMillis();
        Sort.shellSort(data);
        logTime("Random shell sort", start);
        
        // sorted
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = i;
        }
        
        start = System.currentTimeMillis();
        Sort.shellSort(data);
        logTime("Sorted shell sort", start);
 
        // reverse
        data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = data.length -1 - i;
        }
        
        start = System.currentTimeMillis();
        Sort.shellSort(data);
        logTime("Reverse shell sort", start);
    }
    
    public static void logTime(String name, long start){
        LOG.info(name + " took " + (System.currentTimeMillis() - start) + "ms to perform." );
    }
            
}
