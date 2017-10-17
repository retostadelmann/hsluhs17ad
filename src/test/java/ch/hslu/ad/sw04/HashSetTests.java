/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw04;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class HashSetTests {
    
    @Test(expected = IllegalAccessError.class)
    public void addDuplicateTest(){
        ExampleHashSet ehs = new ExampleHashSet(20);
        ehs.add(8);
        ehs.add(8);
    }
    
    @Test
    public void searchTest(){
        ExampleHashSet ehs = new ExampleHashSet(4);
        ehs.add(4);
        ehs.add(8);
        ehs.add(12);
        ehs.add(16);
        int val = ehs.search(16);
        Assert.assertEquals(16, val);
    }
    
    @Test(expected = IllegalAccessError.class)
    public void searchNotExistingTest(){
        ExampleHashSet ehs = new ExampleHashSet(20);
        ehs.add(9);
        ehs.add(7);
        ehs.add(8);
        ehs.add(21);
        ehs.add(22);
        int val = ehs.search(23);
    }
    
    @Test(expected = StackOverflowError.class)
    public void searchNotExistingButFullArrayTest(){
        ExampleHashSet ehs = new ExampleHashSet(5);
        ehs.add(9);
        ehs.add(7);
        ehs.add(8);
        ehs.add(21);
        ehs.add(22);
        int val = ehs.search(23);
    }
    
    @Test(expected = IllegalAccessError.class)
    public void removeEmptyTest(){
        ExampleHashSet ehs = new ExampleHashSet(20);
        ehs.add(9);
        ehs.remove(8);
    }
    
    @Test
    public void sizeTest(){
        ExampleHashSet ehs = new ExampleHashSet(20);
        ehs.add(22);
        ehs.add(23);
        ehs.add(8);
        ehs.remove(8);
        
        assertEquals(2, ehs.size());
    }
    
    @Test
    public void isFullTest(){
        ExampleHashSet ehs = new ExampleHashSet(4);
        ehs.add(22);
        ehs.add(23);
        ehs.add(8);
        ehs.add(7);
        
        assertTrue(ehs.isFull());
    }
    
     @Test
    public void isNotFullTest(){
        ExampleHashSet ehs = new ExampleHashSet(4);
        ehs.add(22);
        ehs.add(23);
        ehs.add(8);;
        
        assertFalse(ehs.isFull());
    }
    
    @Test(expected = IllegalAccessError.class)
    public void isFullButAddTest(){
        ExampleHashSet ehs = new ExampleHashSet(3);
        ehs.add(22);
        ehs.add(23);
        ehs.add(8);
        ehs.add(7);
    }
}
