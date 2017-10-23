/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw05;

/**
 *
 * @author reto.stadelmann
 */
public class AccountTask implements Runnable {
    private BankAccount source;
    private BankAccount dest;
    private int amount;
    
    public AccountTask(final BankAccount source, final BankAccount dest, final int amount){
        this.source = source;
        this.dest = dest;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        this.source.transfer(this.dest, this.amount);
    }
    
}
