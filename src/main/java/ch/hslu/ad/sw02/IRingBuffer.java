/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

/**
 * My goddamn interface
 * @author reto.stadelmann
 */
public interface IRingBuffer {
    void enqueue(char x);
    char dequeue();
    int getCount();
    int getHead();
    int getTail();
}
