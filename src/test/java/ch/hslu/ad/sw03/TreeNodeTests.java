/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author reto.stadelmann
 */
public class TreeNodeTests {
    @Test
    public void getSetValueTest(){
        int val = 5;
        ITreeNode t = new ExampleTreeNode(val);
        t.setValue(val);
        assertEquals(val, t.getValue());
    }
    
    @Test
    public void getSetLeftNodeTest(){
        ITreeNode n = new ExampleTreeNode(1);
        ITreeNode t = new ExampleTreeNode(2);
        t.addNode(n);
        assertEquals(n, t.getLeftNode());
    }
    
    @Test
    public void getSetRightNodeTest(){
        ITreeNode n = new ExampleTreeNode(2);
        ITreeNode t = new ExampleTreeNode(1);
        t.addNode(n);
        assertEquals(n, t.getRightNode());
    }
    
    @Test
    public void getSetLeftNodeFalseTest(){
        ITreeNode n = new ExampleTreeNode(1);
        ITreeNode t = new ExampleTreeNode(3);
        ITreeNode j = new ExampleTreeNode(2);
        t.addNode(j);
        assertFalse(n.equals(t.getLeftNode()));
    }
    
    @Test
    public void getSetRightNodeFalseTest(){
        ITreeNode n = new ExampleTreeNode(1);
        ITreeNode t = new ExampleTreeNode(3);
        ITreeNode j = new ExampleTreeNode(2);
        t.addNode(j);
        assertFalse(n.equals(t.getRightNode()));
    }
}
