/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw08;

import static java.lang.Integer.max;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class SortTest {

    @Test
    public void insertionSortTest() {
        Integer valueMid = 100;
        Integer valueLow = 99;
        Integer valueHigh = 200;

        Integer[] data = new Integer[3];
        data[2] = valueMid;
        data[1] = valueLow;
        data[0] = valueHigh;

        Sort.insertionSort(data);
        assertEquals(data[0], valueLow);
        assertEquals(data[1], valueMid);
        assertEquals(data[2], valueHigh);
    }
    
    @Test
    public void insertionSortRandomTest(){
        Integer[] data = new Integer[36000];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        
        Sort.insertionSort(data);

        assertTrue(data[0].compareTo(data[data.length - 1]) < 0);
         
        // Can be equals cause theyre next to each other
        assertTrue(data[(data.length / 2) - 1].compareTo(data[data.length /2]) <= 0);
        assertTrue(data[3].compareTo(data[4]) <= 0);
        
        assertTrue(data[300].compareTo(data[600]) < 0);
    }
    
    @Test
    public void selectionSortTest(){
        Integer valueMid = 100;
        Integer valueLow = 99;
        Integer valueHigh = 200;

        Integer[] data = new Integer[3];
        data[2] = valueMid;
        data[1] = valueLow;
        data[0] = valueHigh;

        Sort.selectionSort(data);
        assertEquals(data[0], valueLow);
        assertEquals(data[1], valueMid);
        assertEquals(data[2], valueHigh);
    }
    
    @Test
    public void selectionSortRandomTest(){
        Integer[] data = new Integer[36000];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        
        Sort.selectionSort(data);
        
        assertTrue(data[0].compareTo(data[data.length - 1]) < 0);
         
        // Can be equals cause theyre next to each other
        assertTrue(data[(data.length / 2) - 1].compareTo(data[data.length /2]) <= 0);
        assertTrue(data[3].compareTo(data[4]) <= 0);
        
        assertTrue(data[300].compareTo(data[600]) < 0);
    }
    
    @Test
    public void bubbleSortTest(){
        Integer valueMid = 100;
        Integer valueLow = 99;
        Integer valueHigh = 200;

        Integer[] data = new Integer[3];
        data[2] = valueMid;
        data[1] = valueLow;
        data[0] = valueHigh;

        Sort.bubbleSort(data);
        assertEquals(data[0], valueLow);
        assertEquals(data[1], valueMid);
        assertEquals(data[2], valueHigh);
    }
    
    @Test
    public void bubbleSortRandomTest(){
        Integer[] data = new Integer[36000];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        
        Sort.bubbleSort(data);

        assertTrue(data[0].compareTo(data[data.length - 1]) < 0);
         
        // Can be equals cause theyre next to each other
        assertTrue(data[(data.length / 2) - 1].compareTo(data[data.length /2]) <= 0);
        assertTrue(data[3].compareTo(data[4]) <= 0);
        
        assertTrue(data[300].compareTo(data[600]) < 0);
    }
    
        private static final Logger LOG = LogManager.getLogger(SortTest.class);

    
    @Test
    public void bubbleSort2RandomTest(){
        Integer[] data = new Integer[36000];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(0, 40000);
        }
        long start = System.currentTimeMillis();
        Sort.bubbleSort2(data);

        assertTrue(data[0].compareTo(data[data.length - 1]) < 0);
         
        // Can be equals cause theyre next to each other
        assertTrue(data[(data.length / 2) - 1].compareTo(data[data.length /2]) <= 0);
        assertTrue(data[3].compareTo(data[4]) <= 0);
        
        assertTrue(data[300].compareTo(data[600]) < 0);
    }
    
    @Test
    public void shellSortRandomTest(){
        int size = 80000;
        Integer[] data = new Integer[size];
        for(int i = 0; i < data.length; i++){
            data[i] = ThreadLocalRandom.current().nextInt(0, size*2);
        }
        long start = System.currentTimeMillis();
        Sort.shellSort(data);

        for(int i = 1; i < data.length; i++){
            assertTrue(data[i - 1].compareTo(data[i]) <= 0);
        }
    }
}
