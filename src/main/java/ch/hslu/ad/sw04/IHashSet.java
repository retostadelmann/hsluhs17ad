/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw04;

/**
 *
 * @author reto.stadelmann
 */
public interface IHashSet {
    void add(int value);
    void remove(int value);
    int search(int value);
    int getKey(int value);
    boolean isFull();
    int size();
}
