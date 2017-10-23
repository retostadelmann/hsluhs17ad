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
        Bank b = new Bank(400, 200);
        b.StartTransfer();
        Thread.sleep(800);
        
        b.getSourceAccounts().forEach((ba) -> {
            LOG.info("Balance for source Account " + ba + ": " + ba.getBalance());
        });
        
        b.getDestAccounts().forEach((ba) -> {
            LOG.info("Balance for dest Account " + ba + ": " + ba.getBalance());
        });
    }
}