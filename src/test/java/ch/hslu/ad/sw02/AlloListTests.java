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
public class AlloListTests {
    
    @Test
    public void containsTest(){
         final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        final Allocation block2 = memory.malloc(32);
        
        AlloList l = new AlloList();
        ListElement l0 = l.addFirst(block1);
        l.addFirst(block2);
        
        assertTrue(l.contains(l0));
    }
    
    @Test
    public void containsTestFalse(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        final Allocation block2 = memory.malloc(32);
        final Allocation block3 = memory.malloc(36);
        
        AlloList l = new AlloList();
        l.addFirst(block1);
        l.addFirst(block2);
        ListElement l0 = new ListElement(block3);
        
        assertFalse(l.contains(l0));
    }
    
    @Test
    public void sizeTest(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        final Allocation block2 = memory.malloc(32);
        
        AlloList l = new AlloList();
        l.addFirst(block1);
        l.addFirst(block2);
        l.addFirst(block2);


        assertEquals(3, l.size());
    }
    
    @Test
    public void sizeZeroTest(){
        AlloList l = new AlloList();
        assertEquals(0, l.size());
    }
    
    @Test
    public void removeElementTest(){
        final Memory memory = new MemorySimple(1024);
        final Allocation block1 = memory.malloc(16);
        final Allocation block2 = memory.malloc(32);
        final Allocation block3 = memory.malloc(36);
        final Allocation block4 = memory.malloc(39);
        
        AlloList l = new AlloList();
        l.addFirst(block4);
        ListElement l0 = l.addFirst(block3);
        l.addFirst(block1);
        l.addFirst(block2);
        
        assertEquals(4, l.size());
      
        l.remove(l0);
        
        assertEquals(3, l.size());
    }
}
