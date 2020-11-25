public class MergeSort {
    // arr[0..r-1]
    public void merge(int arr[], int l, int r, int m) {

        int n1 = m - l + 1;
        int n2 = r - m;
        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArray[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            rArray[j] = arr[m + j + 1];
        }

        int i = 0, j = 0;

        int itr = l;
        while (i < n1 && j < n2) {
            if (lArray[i] <= rArray[j]) {
                arr[itr] = lArray[i];
                i++;
            } else {
                arr[itr] = rArray[j];
                j++;
            }
            itr++;
        }
        while (i < n1) {
            arr[itr] = lArray[i];
            i++;
            itr++;
        }
        while (j < n2) {
            arr[itr] = rArray[j];
            j++;
            itr++;
        }
    }

    public void msort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            msort(arr, l, m);
            msort(arr, m + 1, r);

            merge(arr, l, r, m);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        printArr(arr);

        MergeSort obj = new MergeSort();
        obj.msort(arr, 0, arr.length - 1);

        printArr(arr);
    }
}
