package warm.heap;

import java.util.Scanner;

/*
 * https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/?ref=rp
 * 
 * Algorithm:

Create two heaps. One max heap to maintain elements of lower half and one min heap to maintain elements of higher half at any point of time..
Take initial value of median as 0.
For every newly read element, insert it into either max heap or min heap and calculate the median based on the following conditions:
If the size of max heap is greater than size of min heap and the element is less than previous median then pop the top element from max heap and insert into min heap and insert the new element to max heap else insert the new element to min heap. Calculate the new median as average of top of elements of both max and min heap.
If the size of max heap is less than size of min heap and the element is greater than previous median then pop the top element from min heap and insert into max heap and insert the new element to min heap else insert the new element to max heap. Calculate the new median as average of top of elements of both max and min heap.
If the size of both heaps are same. If the current element is less than previous median then insert it to max heap and new median will be equal to top element of max heap. If the current element is greater than previous median then insert it to min heap and new median will be equal to top element of min heap
 */
public class MedianofStream {

    int median;
    int minHeap[];
    int maxHeap[];

    int minHeapSize;
    int maxHeapSize;
    int minHeapcapacity;
    int maxHeapCapacity;

    public MedianofStream(int minHeapCapacity, int maxHeapCapacity) {
        this.minHeapcapacity = minHeapCapacity;
        this.maxHeapCapacity = maxHeapCapacity;
        this.minHeap = new int[minHeapCapacity];
        this.maxHeap = new int[maxHeapCapacity];
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return (index * 2) + 1;
    }

    public int right(int index) {
        return (index * 2) + 2;
    }

    public int minHeapPeek() {
        return minHeap[0];
    }

    public int MaxHeapPeek() {
        return maxHeap[0];
    }

    public int pollMaxHeap() {
        int rootElement = maxHeap[0];
        maxHeap[0] = maxHeap[maxHeapSize - 1];
        maxHeapSize--;
        maxHeapify(0);
        return rootElement;
    }

    public int pollMinHeap() {
        int rootElement = minHeap[0];
        minHeap[0] = minHeap[minHeapSize - 1];
        minHeapSize--;
        minHeapify(0);
        return rootElement;
    }

    public void maxHeapify(int p) {

        if (p < 0 || maxHeapSize <= 1) {
            return;
        }

        int largest = p;
        int l = left(largest);
        int r = right(largest);

        if (l < maxHeapSize && maxHeap[largest] < maxHeap[l]) {
            largest = l;
        }
        if (r < maxHeapSize && maxHeap[largest] < maxHeap[r]) {
            largest = r;
        }

        if (largest != p) {
            int tmp = maxHeap[largest];
            maxHeap[largest] = maxHeap[p];
            maxHeap[p] = tmp;
            maxHeapify(largest);
        }
    }

    public void minHeapify(int p) {

        if (p < 0 || minHeapSize <= 1) {
            return;
        }

        int smallest = p;
        int l = left(smallest);
        int r = right(smallest);

        if (l < minHeapSize && minHeap[smallest] > minHeap[l]) {
            smallest = l;
        }

        if (r < minHeapSize && minHeap[smallest] > minHeap[r]) {
            smallest = r;
        }

        if (smallest != p) {
            int tmp = minHeap[p];
            minHeap[p] = minHeap[smallest];
            minHeap[smallest] = tmp;
            minHeapify(smallest);
        }

    }

    public void addMaxHeap(int e) {
        maxHeap[maxHeapSize] = e;
        maxHeapSize++;

        int p = parent(maxHeapSize - 1);
        int child = maxHeapSize -1;
        while (p >= 0 && maxHeap[p] < maxHeap[child]) {
            int tmp = maxHeap[p];
            maxHeap[p] = maxHeap[child];
            maxHeap[child] = tmp;
            child = p;
            p = parent(p);
        }
    }

    public void addMinHeap(int e) {
        minHeap[minHeapSize] = e;
        minHeapSize++;

        int p = parent(minHeapSize - 1);
        int child = minHeapSize -1;
        while (p >= 0 && minHeap[p] > minHeap[child]) {
            int tmp = minHeap[p];
            minHeap[p] = minHeap[child];
            minHeap[child] = tmp;
            child = p;
            p = parent(p);
        }
    }

    public void addNewElement(int e) {
        if (maxHeapSize > minHeapSize && e < median) {
            int root = pollMaxHeap();
            addMinHeap(root);
            addMaxHeap(e);
        } else if (minHeapSize > maxHeapSize && e > median) {
            int root = pollMinHeap();
            addMaxHeap(root);
            addMinHeap(e);
        } else {
            if (e > median) {
                addMinHeap(e);
            } else {
                addMaxHeap(e);
            }
        }
        median = median();

    }

    public int median() {
        if (minHeapSize > maxHeapSize) {
            return minHeapPeek();
        }
        if (minHeapSize < maxHeapSize) {
            return MaxHeapPeek();
        }

        int minHeapRoot = minHeapPeek();
        int maxHeapRoot = MaxHeapPeek();
        return (minHeapRoot + maxHeapRoot) / 2;
    }

    private void printMinHeap() {
        System.out.println(" =========== printMinHeap ========= ");
        for (int i = 0; i < this.minHeapSize; i++) {
            System.out.print(this.minHeap[i] + " ");
        }
        System.out.println();
    }

    private void printMaxHeap() {
        System.out.println(" =========== printMaxHeap ========= ");
        for (int i = 0; i < this.maxHeapSize; i++) {
            System.out.print(this.maxHeap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        MedianofStream medianofStream = new MedianofStream(capacity, capacity);
        while (true) {
            int e = sc.nextInt();
            medianofStream.addNewElement(e);
            System.out.println("Median: "+medianofStream.median());
            medianofStream.printMaxHeap();
            medianofStream.printMinHeap();
        }
    }

}
