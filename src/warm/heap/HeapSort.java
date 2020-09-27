package warm.heap;

import java.util.Scanner;

/**
 * 1. build max heap 2. repeatedly swap root with last node, reduce size by 1,
 * heapify
 */

public class HeapSort {

    int size;
    int capacity;
    int arr[];

    public HeapSort(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int left(int p) {
        return 2 * p + 1;
    }

    public int right(int p) {
        return 2 * p + 2;
    }

    public void maxHeapify(int p) {
        if (p < 0) {
            return;
        }

        if (size == 1) {
            return;
        }
        int largest = p;
        int l = left(p);
        int r = right(p);
        if (l < size && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < size && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != p) {
            int tmp = arr[largest];
            arr[largest] = arr[p];
            arr[p] = tmp;
        }
    }

    public void buildMaxHeap() {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void doSort() {
        buildMaxHeap();
        int sortedIndex = size - 1;
        while (sortedIndex >= 0) {
            int tmp = arr[0];
            arr[0] = arr[sortedIndex];
            arr[sortedIndex] = tmp;
            size--;
            buildMaxHeap();
            sortedIndex--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        HeapSort heapSort = new HeapSort(capacity);
        while (heapSort.size < n) {
            heapSort.arr[heapSort.size++] = sc.nextInt();
        }
        heapSort.print();
        heapSort.doSort();
        heapSort.print();
    }

    private void print() {
        for (int i = 0; i < this.capacity; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}
