/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

/**
 *
 * @author reto.stadelmann
 */
public class MyStack <T> implements ICheapStack{
    private Object[] data;
    
    public MyStack(final int size){
        if(size < 0){
            throw new IllegalArgumentException("size cannot be less than zero");
        }
        
        this.data = new Object[size];
    }
    
    @Override
    public void push(final Object value) {
        for(int i = 0; i < this.data.length; i++){
            if(this.data[i] == null){
                this.data[i] = value;
                break;
            }
            else{
                if(i == this.data.length - 1){
                    throw new MyStackException("stack is full");
                }
            }
        }
    }

    @Override
    public T pop() {
        for(int i = this.data.length - 1; i > -1; i--){
            if(this.data[i] != null){
                Object value = this.data[i];
                this.data[i] = null;
                return (T)value;
            }
        }
        
        return null;
    }

    @Override
    public int count() {
        int count = 0;
        for(int i = 0; i < this.data.length; i++){
            if(this.data[i] != null){
                count++;
            }
            else{
                break;
            }
        }
        
        return count;
    }   
}
