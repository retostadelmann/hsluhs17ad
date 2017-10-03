/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw01;

import ch.hslu.ad.sw02.ListElement;
import java.util.Objects;

/**
 *
 * @author reto.stadelmann
 */
public class Allocation {
    private int length = 0;
    
    public Allocation(final int length){
        this.length = length;
    }
    
    public int getLength(){
        return this.length;
    }
    
    @Override
    public final boolean equals(Object obj){
         if (obj == this) {
            return true;
        }

        if (!(obj instanceof Allocation)) {
            return false;
        }
        
        final Allocation other = (Allocation) obj;
        return Objects.equals(this.length, other.getLength());
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.length);
    }
}
