/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw08;

/**
 *
 * @author reto.stadelmann
 */
public final class Sort {

    /* public static <T extends Comparable<T>> T insertSort(T[] obj) {

    }*/
    
    /**
     * Sortiert das int-Array aufsteigend, erst ab Index a[1].
     *
     * @param a Zu sortierendes Array.
     */
    public static void insertionSort(Integer[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            temp = a[i]; // next temp for insert
            int j = i; 
            while (j > 0 &&a[j - 1].compareTo(temp) > 0) {
                a[j] = a[j - 1]; // shift right
                j--; // go further left
            }
            a[j] = temp; 
        } 
    }
}
