/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.omg.CORBA.SystemException;

/**
 *
 * @author reto.stadelmann
 */
public class TreeTests {
    
    @Test
    public void SearchTest(){
        ITree b = new ExampleTree();
        b.addNode(4);
        b.addNode(3);
        b.addNode(1);
        b.addNode(2);
        b.addNode(6);
        b.addNode(7);
        b.addNode(5);
        
        int searchVal = 5;
        ITreeNode t = b.search(searchVal);
        assertEquals(searchVal, t.getValue());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void insertAlreadyExistingNodeTest(){
        ITree b = new ExampleTree();
        b.addNode(5);
        b.addNode(5);
    }
}
