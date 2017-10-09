
import ch.hslu.ad.sw01.Allocation;
import ch.hslu.ad.sw01.Memory;
import ch.hslu.ad.sw01.MemoryDemo;
import ch.hslu.ad.sw01.MemorySimple;
import ch.hslu.ad.sw02.MyStack;
import ch.hslu.ad.sw02.RingBuffer;
import ch.hslu.ad.sw03.ExampleTree;
import ch.hslu.ad.sw03.ITree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reto.stadelmann
 */
public class MyMassiveMainClass {
    static Logger LOG = LogManager.getLogger(MyMassiveMainClass.class);
    
    public static void main(final String[] args){
        ITree tree = new ExampleTree();
        tree.addNode(4);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(5);
        tree.addNode(9);
        tree.addNode(11);
        tree.addNode(12);
        tree.addNode(10);
        tree.addNode(14);
        tree.addNode(13);
        
        tree.search(13);
    }
}
