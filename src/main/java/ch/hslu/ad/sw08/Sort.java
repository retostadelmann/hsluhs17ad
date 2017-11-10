/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.ad.sw08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author reto.stadelmann
 */
public final class Sort {

    private static final Logger LOG = LogManager.getLogger(Sort.class);

    /**
     * Sortiert das int-Array aufsteigend.
     *
     * @param <T> Comparable-Type
     * @param a Data-Array
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        T temp;
        for (int i = 1; i < a.length; i++) {
            temp = a[i]; // next temp for insert
            int j = i;
            while (j > 0 && a[j - 1].compareTo(temp) > 0) {
                a[j] = a[j - 1]; // shift right
                j--; // go further left
            }
            a[j] = temp;
        }
    }

    /**
     * Sortiert das int array selektiv.
     *
     * @param <T> Comparable-Type
     * @param a Data-Array
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
        T temp;
        // end at - 1 to skip the last item, which will be the biggest anyway.
        for (int i = 0; i < a.length - 1; i++) {
            int lowestPos = 0;
            T lowestValue = null;
            for (int k = i + 1; k < a.length; k++) {
                if (lowestValue == null || a[k].compareTo(lowestValue) <= 0) {
                    lowestValue = a[k];
                    lowestPos = k;
                }
            }
            temp = a[i];
            a[i] = lowestValue;
            a[lowestPos] = temp;
        }
    }

    /**
     * Sortiert das Array Bubbly.
     *
     * @param <T> Comparable-Type
     * @param a Data-Array
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        // start at 1 to skip the last item, which will be the biggest anyway.
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sortiert das Array Bubbly.
     *
     * @param <T> Comparable-Type
     * @param a Data-Array
     */
    public static <T extends Comparable<? super T>> void bubbleSort2(T[] a) {       
        // start at 1 to skip the last item, which will be the biggest anyway.
        for (int i = 1; i < a.length; i++) {
            boolean nothingToBubble = true;
            
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    nothingToBubble = false;
                }
            }
            
            if(nothingToBubble){
                break;
            }
        }
    }
}
