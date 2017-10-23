/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw05;

import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class AdditionTask implements Runnable {

        static Logger LOG = LogManager.getLogger(AdditionTask.class);

    
    private Thread runThread;
    private int rangeBegin, rangeEnd;
    private boolean isStopped = false;

    public AdditionTask(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    public void Stop() {
        this.isStopped = true;
    }

    public boolean isStopped() {
        return this.isStopped;
    }

    @Override
    public void run() {
        int n = this.rangeEnd - this.rangeBegin;

        this.runThread = Thread.currentThread();
// Initialisierungsphase
        long sum = 0;
// Arbeitsphase
        for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
            sum += i;
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(AdditionTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// Aufräumphase
        if (!isStopped()) {
            LOG.info(runThread.getName() + ": SUM" + n + " -> " + sum);
        } else {
            LOG.info(runThread.getName() + ": interrupted.");
        }
    }
}
