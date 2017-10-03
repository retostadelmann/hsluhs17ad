/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

import ch.hslu.ad.sw01.Allocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author reto.stadelmann
 */
public class AlloList implements Iterator{
    private ListElement head, current, previous;
    
    public AlloList(){
   
    }
    
    public ListElement addFirst(final Allocation alloc){       
        if(alloc == null){
            throw new IllegalArgumentException("alloc");
        }        
        
        ListElement element = new ListElement(alloc);
       
        element.setNextElement(head);
        
        this.head = element;
        
        return this.head;
    }
    
    public boolean contains(final ListElement element){
        this.current = head;   
        do{
            if( this.current.equals(element)){
                return true;
            }
            
             this.current =  this.current.getNextElement();
        }
        while(this.current != null);
        
        return false;
    }
    
    public ListElement extractFirst(){
        ListElement oldHead = this.head;
        this.head = this.head.getNextElement();
        return oldHead;
    }

    public void remove(final ListElement element){
        ListElement currentElement = head;
        ListElement previousElement = null;
        do{
            if(currentElement.equals(element)){
                if (previousElement == null) {
                    this.head = currentElement.getNextElement();
                    currentElement = this.head;
                }
                else{
                    previousElement.setNextElement(currentElement.getNextElement());
                    currentElement = previousElement;
                }
            }
              
            previousElement = currentElement;
            currentElement = currentElement.getNextElement();
        }
        while(currentElement != null);
    }
    
    public int size(){    
        if(this.head == null){
            return 0;
        }
        
        int count = 0;
        this.current = head;       
        do{     
            count++;
             this.current =  this.current.getNextElement();
        }while(this.current != null);
        
        return count;
    }

    @Override
    public boolean hasNext() {
        return this.current.hasNextElement();
    }

    @Override
    public Object next() {
        this.current = this.current.getNextElement();
        return this.current;
    }
    
    @Override
    public void remove(){
        this.remove(this.current);
    }
}
