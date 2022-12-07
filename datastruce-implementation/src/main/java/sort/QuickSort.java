package sort;

import java.util.Arrays;

public class QuickSort {

    public void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public int partition(int[] array, int i, int j) {
        int x = array[i];
        while (i < j) {
            while (i < j && array[j] >= x) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (i < j && array[i] < x) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = x;
        return i;
    }

    public void quickSort(int[] array, int i, int j) {
        if (i < j) {
            int index = partition(array, i, j);
            quickSort(array, i, index - 1);
            quickSort(array, index + 1, j);
        }
    }

    public static void main(String[] args) {
        int[] array = {7,3,5,6,7,2,3,1};
        QuickSort quickSort = new QuickSort();
        quickSort.print(array);
        quickSort.quickSort(array, 0, array.length - 1);
        quickSort.print(array);
    }
}
