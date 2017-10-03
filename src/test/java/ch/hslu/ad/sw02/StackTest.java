/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import ch.hslu.ad.sw01.Memory;
import ch.hslu.ad.sw01.MemorySimple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class StackTest {
    
    @Test
    public void emptyTest(){
        MyStack ms = new MyStack(1);
        assertEquals(0, ms.count());
    }
    
    @Test
    public void notEmptyTest(){
        MyStack ms = new MyStack(1);
        ms.push("TEST");
        assertFalse(0 == ms.count());
    }
    
    @Test
    public void fullTest(){
        MyStack ms = new MyStack(1);
        ms.push("TEST");
        assertEquals(1, ms.count());
    }
    
    @Test
    public void pushPopTest(){
        MyStack<String> ms = new MyStack(4);
        String input = "TheString";
        ms.push("anotherstring");
        ms.push("anotherstring2");
        ms.push(input);
        String output = ms.pop();
        assertEquals(input, output);  
    }
    
    @Test(expected = StackOverflowError.class)
    public void overflowTest(){
        MyStack ms = new MyStack(1);
        String input = "TheString";
        ms.push(input);
        ms.push(input);
    }
   
}