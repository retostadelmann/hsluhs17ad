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
public interface ICheapStack<T> {
    /**
     * Ads a new object to the stack.
     */
    void push(final T object);
    
    /**
     * Returns the last element of the stack.
     * @return Returns the last element in the stack.
     */
    T pop();
    
    /**
     * Returns the Elements in the stack.
     * @return The count of elements.
     */
    int count();
}
