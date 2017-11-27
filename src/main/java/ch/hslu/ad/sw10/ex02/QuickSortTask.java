package ch.hslu.ad.sw10.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class QuickSortTask extends RecursiveAction {

    private final int[] items;
    private final int left;
    private final int right;
    private final int threshold;

    public QuickSortTask(int items[], int threshold) {
        this.items = items;
        this.left = 0;
        this.right = items.length - 1;
        this.threshold = threshold;
    }

    private QuickSortTask(int items[], int left, int right, int threshold) {
        this.items = items;
        this.left = left;
        this.right = right;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        int prevItem = this.left;
        int nextItem = this.right - 1;
        int t = this.items[this.right];
        do {
            while (this.items[prevItem] < t) {
                prevItem++;
            }
            while (this.items[nextItem] >= t && nextItem > prevItem) {
                nextItem--;
            }
            if (prevItem < nextItem) {
                swap(this.items, prevItem, nextItem);
            }
        } while (prevItem < nextItem);
        swap(this.items, prevItem, this.right);
        List<QuickSortTask> tasks = new ArrayList<>();
        if (this.left < prevItem - 1) {
            int size = (prevItem - 1) - this.left + 1;
            if (size < this.threshold) {
                Arrays.sort(this.items, this.left, prevItem);
            } else {
                tasks.add(new QuickSortTask(this.items, this.left, prevItem - 1, threshold));
            }
        }
        if (this.right > prevItem + 1) {
            int size = this.right - (prevItem + 1) + 1;
            if (size < this.threshold) {
                Arrays.sort(this.items, prevItem + 1, this.right + 1);
            } else {
                tasks.add(new QuickSortTask(this.items, prevItem + 1, this.right, this.threshold));
            }
        }
        if (!tasks.isEmpty()) {
            invokeAll(tasks);
        }
    }
    
    /**
     * Helper Method to Swap items
     * @param items the array
     * @param a index 1
     * @param b index 2
     */
    private void swap(int[] items, int a, int b) {
        int temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }

}
