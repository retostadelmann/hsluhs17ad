import ch.hslu.ad.sw05.AdditionTask;
import ch.hslu.ad.sw05.Bank;
import ch.hslu.ad.sw05.BankAccount;
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

    public static void main(final String[] args) throws InterruptedException {
        
        AdditionTask at1 = new AdditionTask(4, 93);
        AdditionTask at2 = new AdditionTask(35, 298);
        AdditionTask at3 = new AdditionTask(23, 893);
        
        Thread t1 = new Thread(at1);
        Thread t2 = new Thread(at2);
        Thread t3 = new Thread(at3);
        
        t1.start();
        t2.start();
        t3.start();
        
        Thread.sleep(1000);
        
        at1.Stop();
        at2.Stop();
        at3.Stop();
    }
}