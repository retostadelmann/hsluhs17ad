/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw02;

public class RingBuffer implements IRingBuffer {

    private final int limit = 7;
    private final char[] buffer = new char[limit];
    private int head = 0, elementCount = 0, tail = 0;

    @Override
    public void enqueue(char x) {
        if(this.getCount() > 0 && this.head == this.tail){
            throw new RuntimeException("Queue is full");
        }
        this.buffer[this.head] = x;
        this.elementCount++;
        this.head = (this.tail + this.elementCount) % this.limit;
    }

    @Override
    public char dequeue() {
        if(this.getCount() == 0){
            throw new RuntimeException("No Items in the queue");
        }
        char out = this.buffer[this.tail];
        this.elementCount--;
        this.tail = (this.tail + 1) % this.limit;
        return out;
    }

    @Override
    public int getCount() {
        return this.elementCount;
    }

    @Override
    public int getHead() {
        return this.head;
    }

    @Override
    public int getTail() {
        return this.tail;
    }

}
