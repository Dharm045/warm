package warm.heap;

import java.util.Scanner;

class BinaryMinHeap {

    int size;
    int capacity;
    int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        BinaryMinHeap binaryMinHeap = new BinaryMinHeap(capacity);
        for (int i = 0; i < n; i++) {
            binaryMinHeap.insert(sc.nextInt());
        }

        for (int i = 0; i < binaryMinHeap.size; i++) {
            System.out.print(binaryMinHeap.arr[i] + " ");
        }
        System.out.println();

        System.out.println("peek: " + binaryMinHeap.peek());
        for (int i = 0; i < binaryMinHeap.size; i++) {
            System.out.print(binaryMinHeap.arr[i] + " ");
        }

        System.out.println();

        binaryMinHeap.decreaseKey(3, 1);
        for (int i = 0; i < binaryMinHeap.size; i++) {
            System.out.print(binaryMinHeap.arr[i] + " ");
        }

        System.out.println();
        binaryMinHeap.deleteKey(1);
        for (int i = 0; i < binaryMinHeap.size; i++) {
            System.out.print(binaryMinHeap.arr[i] + " ");
        }

    }

    public BinaryMinHeap(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public int getLeft(int i) {
        return (2 * i) + 1;
    }

    public int getRight(int i) {
        return (2 * i) + 2;
    }

    public void insert(int e) {
        arr[size] = e;
        size++;
        int p = getParent(size - 1);
        int i = size - 1;
        while (p >= 0 && arr[p] > arr[i]) {
            System.out.println(p + " " + arr[p]);
            int tmp = arr[p];
            arr[p] = arr[i];
            arr[i] = tmp;
            i = p;
            p = getParent(p);
        }
    }

    public void minHeapify(int p) {
        if (p == -1) {
            return;
        }
        if (size == 1) {
            return;
        }
        int l = getLeft(p);
        int r = getRight(p);
        System.out.println(l + " " + r + " " + p);
        int smallest = p;
        if (l < size && arr[smallest] > arr[l]) {
            smallest = l;
        }
        if (r < size && arr[smallest] > arr[r]) {
            smallest = r;
        }
        if (smallest != p) {
            int tmp = arr[p];
            arr[p] = arr[smallest];
            arr[smallest] = tmp;
            minHeapify(smallest);
        }
    }

    public int peek() {
        if (size <= 0) {
            return -1;
        }
        // copy last to root & heapify
        int root = arr[0];
        arr[0] = arr[size - 1];
        size--;
        minHeapify(0);
        return root;
    }

    public void decreaseKey(int index, int value) {
        if (index <= size) {
            arr[index] = value;

            int p = getParent(index);
            int i = index;
            while (p >= 0 && arr[p] > arr[i]) {
                System.out.println(p + " " + arr[p]);
                int tmp = arr[p];
                arr[p] = arr[i];
                arr[i] = tmp;
                i = p;
                p = getParent(p);
            }

        }
    }

    public void deleteKey(int index) {
        if (index <= size) {
            int tmp = arr[index];
            arr[index] = arr[size - 1];
            arr[size - 1] = tmp;
            size--;
            minHeapify(index);
        }
    }

}
