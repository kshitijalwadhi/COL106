public class QuickSort {

    public int partition(int arr[], int l, int r) {
        int pivot = arr[r];
        int i = l;
        int j = r;
        while (true) {
            while (arr[j] > pivot)
                j--;
            while (arr[i] < pivot)
                i++;
            if (i < j) {
                int c = arr[j];
                arr[j] = arr[i];
                arr[i] = c;
            } else
                return j;
        }
    }

    public void qsort(int arr[], int l, int r) {
        if (l < r) {
            int part = partition(arr, l, r);
            qsort(arr, l, part);
            qsort(arr, part + 1, r);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 17, 12, 6, 19, 23, 8, 5, 10 };
        printArr(arr);

        QuickSort obj = new QuickSort();
        obj.qsort(arr, 0, arr.length - 1);

        printArr(arr);
    }

}
