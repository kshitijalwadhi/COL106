public class Heap {
    private int[] arr;
    private int size;
    private int maxSize;

    public Heap(int maxSz) {
        maxSize = maxSz;
        arr = new int[maxSz];
        size = 0;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private boolean isLeaf(int i) {
        if (i >= size / 2 && i <= size)
            return true;
        return false;
    }

    private void swap(int n1, int n2) {
        int temp;
        temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    private void heapify(int i) {
        if (!isLeaf(i)) {
            if (arr[i] > arr[leftChild(i)] || arr[i] > arr[rightChild(i)]) {
                if (arr[leftChild(i)] < arr[leftChild(i)]) {
                    swap(leftChild(i), i);
                    heapify(leftChild(i));
                } else {
                    swap(rightChild(i), i);
                    heapify(rightChild(i));
                }
            }
        }
    }

    public void insert(int elem) {
        if (size >= maxSize) {
            return;
        }
        size++;
        arr[size] = elem;
        int cur = size;

        while (arr[cur] < arr[parent(cur)]) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    public int minimum() {
        return arr[1];
    }

    public int deleteMin() {
        int item = minimum();
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return item;
    }

    public void buildHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    public void heapsort() {
        for (int i = size; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[1];
            arr[1] = temp;
            size--;
            heapify(1);
        }
    }

    public void printArr() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Heap temp = new Heap(10);

        temp.insert(5);
        temp.insert(3);
        temp.insert(10);
        temp.insert(84);
        temp.insert(19);
        temp.insert(17);
        temp.insert(2);
        // System.out.println(temp.minimum());
        temp.deleteMin();
        // System.out.println(temp.minimum());
        temp.printArr();
        temp.heapsort();
        temp.printArr();
    }
}