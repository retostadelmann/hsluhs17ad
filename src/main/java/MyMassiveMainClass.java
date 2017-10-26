import ch.hslu.ad.sw05.JoinAndSleep;
import ch.hslu.ad.sw05.AdditionTask;
import ch.hslu.ad.sw05.Bank;
import ch.hslu.ad.sw05.BankAccount;
import java.util.logging.Level;
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
        
        /*AdditionTask at1 = new AdditionTask(4, 93);
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
        at3.Stop();*/
        
        Thread t10 = new Thread(new Runnable() {
                        @Override
                        public void run(){
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException ex) {
                                java.util.logging.Logger.getLogger(MyMassiveMainClass.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
        Thread t20 = new Thread(new Runnable() {
                        @Override
                        public void run(){
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                java.util.logging.Logger.getLogger(MyMassiveMainClass.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
        Thread t30 = new Thread(new Runnable() {
                        @Override
                        public void run(){
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                java.util.logging.Logger.getLogger(MyMassiveMainClass.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
        
        JoinAndSleep js3 = new JoinAndSleep("Thread 3", t30);
        JoinAndSleep js2 = new JoinAndSleep("Thread 2", t20);
        JoinAndSleep js1 = new JoinAndSleep("Thread 1", t10);      
    }
}