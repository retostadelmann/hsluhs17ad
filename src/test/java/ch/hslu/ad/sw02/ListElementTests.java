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
public class ListElementTests {
    
    @Test
    public void getCurrentAlloc(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        
        ListElement t = new ListElement(block1);
        
        assertEquals(t.getCurrentAllocation(), block1);
    }
    
    @Test
    public void getNextElement(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        
        ListElement t = new ListElement(block1);
        ListElement u = new ListElement(block1);
        
        t.setNextElement(u);
        
        assertEquals(t.getNextElement(), u);
    }
      
    
    @Test
    public void hasNextElement(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        
        ListElement t = new ListElement(block1);
        ListElement u = new ListElement(block1);
        
        t.setNextElement(u);
        
        assertTrue(t.hasNextElement());  
    }
    
    @Test
    public void hasNoNextElement(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        
        ListElement t = new ListElement(block1);        
        
        assertFalse(t.hasNextElement());
    }
    
}
