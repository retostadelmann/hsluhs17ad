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
        int j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i]; // next temp for insert
            j = i;
            while (j > 0 && a[j - 1].compareTo(temp) > 0) {
                a[j] = a[j - 1]; // shift left
                j--; // go further left
            }
            a[j] = temp;
        }
    }

    public static void insertionSortint(int[] a) {
        int temp;
        int j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i]; // next temp for insert
            j = i;
            while (j > 0 && a[j - 1] > temp) {
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

            if (nothingToBubble) {
                break;
            }
        }
    }

    /**
     * Sortiert das Array Shellig.
     *
     * @param <T> Comparable-Type
     * @param a Data-Array
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int inner, outer;
        T temp;

        int h = 1;
        while (h <= a.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < a.length; outer++) {
                temp = a[outer];
                inner = outer;

                while (inner > h - 1 && a[inner - h].compareTo(temp) >= 0) {
                    a[inner] = a[inner - h];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
