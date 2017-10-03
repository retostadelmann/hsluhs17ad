/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw01;

/**
 *
 * @author reto.stadelmann
 */
public abstract class Memory {

    private int size = 0;

    public Memory(int size) {
        this.size = size;
    }
    
    public Allocation malloc(final int length){
        return new Allocation(length); 
    }
    
    public void free(final Allocation alloc){
        
        
    }

}
