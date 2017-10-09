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
        ITreeNode t = new ExampleTreeNode();
        t.setValue(val);
        assertEquals(val, t.getValue());
    }
    
    @Test
    public void getSetLeftNodeTest(){
        ITreeNode n = new ExampleTreeNode();
        ITreeNode t = new ExampleTreeNode();
        t.setLeftNode(n);
        assertEquals(n, t.getLeftNode());
    }
    
    @Test
    public void getSetRightNodeTest(){
        ITreeNode n = new ExampleTreeNode();
        ITreeNode t = new ExampleTreeNode();
        t.setRightNode(n);
        assertEquals(n, t.getRightNode());
    }
    
    @Test
    public void getSetLeftNodeFalseTest(){
        ITreeNode n = new ExampleTreeNode();
        ITreeNode t = new ExampleTreeNode();
        ITreeNode j = new ExampleTreeNode();
        t.setLeftNode(j);
        assertFalse(n.equals(t.getLeftNode()));
    }
    
    @Test
    public void getSetRightNodeFalseTest(){
        ITreeNode n = new ExampleTreeNode();
        ITreeNode t = new ExampleTreeNode();
        ITreeNode j = new ExampleTreeNode();
        t.setRightNode(j);
        assertFalse(n.equals(t.getRightNode()));
    }
}
