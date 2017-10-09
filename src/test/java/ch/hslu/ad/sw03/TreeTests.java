/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class TreeTests {
    
    @Test
    public void SearchTest(){
        ITree<Integer> b = new ExampleTree();
        b.addNode(4);
        b.addNode(3);
        b.addNode(1);
        b.addNode(2);
        b.addNode(6);
        b.addNode(7);
        b.addNode(5);
        
        int searchVal = 5;
        ITreeNode<Integer> t = b.search(searchVal);
        assertEquals(searchVal, (int)t.getValue());
    }
    
    @Test
    public void SearchWithSingleElementTest(){
        ITree<Integer> b = new ExampleTree();
        b.addNode(4);
        
        int searchVal = 4;
        ITreeNode<Integer> t = b.search(searchVal);
        assertEquals(searchVal, (int)t.getValue());
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void SearchWithSingleElementFalseTest(){
        ITree<Integer> b = new ExampleTree();
        b.addNode(4);
        
        int searchVal = 3;
        ITreeNode<Integer> t = b.search(searchVal);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void insertAlreadyExistingNodeTest(){
        ITree<Integer> b = new ExampleTree();
        b.addNode(5);
        b.addNode(6);
        b.addNode(8);
        b.addNode(34);
        b.addNode(16);
        b.addNode(9);   
        b.addNode(5);
    }
    
    @Test
    public void insertNodeTest(){
        ITree<Integer> b = new ExampleTree();
        b.addNode(5);
        b.addNode(6);
        
    }
}
