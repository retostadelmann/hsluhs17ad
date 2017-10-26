package ch.hslu.ad.sw05;

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
public class JoinAndSleep{
    
        static Logger LOG = LogManager.getLogger(JoinAndSleep.class);


    public JoinAndSleep(String name, Thread next) throws InterruptedException {
        next.join();
        LOG.info(name + " terminated");
    }
}
