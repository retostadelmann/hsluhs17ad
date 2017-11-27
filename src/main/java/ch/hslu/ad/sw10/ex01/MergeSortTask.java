package ch.hslu.ad.sw10.ex01;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class MergeSortTask extends RecursiveAction {

    private final int array[];
    private final int min;
    private final int length;
    private final int threshold;

    public MergeSortTask(int array[], int threshold) {
        this.array = array;
        this.min = 0;
        this.length = array.length;
        this.threshold = threshold;
    }

    private MergeSortTask(int array[], int min, int length, int threshold) {
        this.array = array;
        this.min = min;
        this.length = length;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (this.length - this.min + 1 <= this.threshold) {
            PartialInsertionSort.sortPartially(this.array, this.min, this.length);
        } else {
            int mid = this.min + (this.length - this.min) / 2;
            invokeAll(new MergeSortTask(this.array, this.min, mid, this.threshold), new MergeSortTask(this.array, mid, this.length, this.threshold));
            this.merge(this.min, mid, this.length);
        }
    }

    private void merge(int min, int mid, int max) {
        int buf[] = Arrays.copyOfRange(this.array, min, mid);
        int readBuf = 0;
        int readArray = mid;
        int write = min;
        while (readBuf < buf.length) {
            if (readArray == max || buf[readBuf] < this.array[readArray]) {
                this.array[write++] = buf[readBuf++];
            } else {
                this.array[write++] = this.array[readArray++];
            }
        }
    }

}
