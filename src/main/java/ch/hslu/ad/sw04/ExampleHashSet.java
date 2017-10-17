/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw04;

import java.util.Iterator;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public class ExampleHashSet implements IHashSet, Iterable<Integer> {
    static Logger LOG = LogManager.getLogger(ExampleHashSet.class);

    final int arraySize;
    int hashOffset = 3, elementCount;
    Object[] hashSetArray;
    
    public ExampleHashSet(final int arraySize){
        this.arraySize = arraySize;
        this.hashSetArray = new Object[this.arraySize];
    }

    @Override
    public void add(final int value) {
        if(this.isFull()){
            throw new IllegalAccessError("Array is full");
        }
        
        int key = this.getKey(value);       
        if(this.hashSetArray[this.getKey(value)] != null){  
            if(this.hashSetArray[this.getKey(value)].equals(value)){
                throw new IllegalAccessError("Value already exists");
            }
            
            key = this.findNextEmptyKey(key);
        }
             
        this.hashSetArray[key] = value;
        this.elementCount++;
        LOG.info("Added value " + value + " at position " + key );
    }

    @Override
    public void remove(final int key) {
        if(this.hashSetArray[key] == null){
            throw new IllegalAccessError("Array does not contain value");
        }
        
        this.hashSetArray[key] = null;
        this.elementCount--;
    }

    @Override
    public int search(final int value) {
        Integer searchValue = null;
        
        try{
            int startKey = this.getKey(value);
            return this.search(value, startKey);
        }
        catch(NullPointerException ex){
            throw new IllegalAccessError("Value does not exist.");
        }        
    }
    
    private int search(final int value, final int key){
        if(this.hashSetArray[key] == null){
            throw new NullPointerException();
        }
        
        if(((Integer)this.hashSetArray[key]).equals(value)){
            return (int)this.hashSetArray[key];
        }
        
        return this.search(value, this.getNextKey(key));
    }

    @Override
    public int getKey(final int value){
        return this.getHash(Math.abs(value)) % this.hashSetArray.length;
    }
    
    @Override
    public boolean isFull() {
        return this.elementCount >= this.hashSetArray.length;
    }

    @Override
    public int size() {
        return this.elementCount;
    }
    
    private int getHash(final int value) {
        return Objects.hash(value) - 31;
    }
    
    private int findNextEmptyKey(final int position){
        int key = this.getNextKey(position);
        
        if(this.hashSetArray[key] == null){
            return key;
        }
        else{
            return this.findNextEmptyKey(key);
        }
    }

    private int getNextKey(final int position){
        return (position + 1) % this.hashSetArray.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < arraySize && hashSetArray[currentIndex] != null;
            }

            @Override
            public Integer next() {
                return (int)hashSetArray[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
