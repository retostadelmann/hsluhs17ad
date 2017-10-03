
import ch.hslu.ad.sw01.Allocation;
import ch.hslu.ad.sw01.Memory;
import ch.hslu.ad.sw01.MemoryDemo;
import ch.hslu.ad.sw01.MemorySimple;
import ch.hslu.ad.sw02.MyStack;
import ch.hslu.ad.sw02.RingBuffer;
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
        RingBuffer rb  = new RingBuffer();
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.enqueue('r');
        rb.enqueue('r');
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
        rb.dequeue();
        LOG.info("HEAD: " + rb.getHead());
        LOG.info("Tail: " + rb.getTail());
        LOG.info("Count: " + rb.getCount());
        LOG.info("-----------------");
    }
}
