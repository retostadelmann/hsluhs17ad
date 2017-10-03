/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import java.util.Objects;

/**
 *
 * @author reto.stadelmann
 */
public class ListElement {
    
    private final Allocation currentAlloc;
    private ListElement nextElement = null;
    
    public ListElement(final Allocation alloc){
        this.currentAlloc = alloc;
    }
    
    public Allocation getCurrentAllocation(){
        return this.currentAlloc;
    }
    
    public ListElement getNextElement(){
        return this.nextElement;
    }
    
    public ListElement setNextElement(ListElement nextElement){
        this.nextElement = nextElement;
        return this.nextElement;
    }
    
    public boolean hasNextElement(){
        return this.getNextElement() != null;
    } 
    
    
    @Override
    public final boolean equals(Object obj){
         if (obj == this) {
            return true;
        }

        if (!(obj instanceof ListElement)) {
            return false;
        }
        
        final ListElement other = (ListElement) obj;
        return Objects.equals(this.currentAlloc, other.getCurrentAllocation()) && 
                Objects.equals(this.nextElement, other.getNextElement());
    }
    
    @Override
    public final int hashCode() {
        return 31 * Objects.hash(this.currentAlloc) + Objects.hash(this.nextElement);
    }
}
