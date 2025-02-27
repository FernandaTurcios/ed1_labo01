package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        QuickSort(array, 0, array.length - 1, "high");
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        QuickSort(array, 0, array.length - 1, "low");
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        QuickSort(array, 0, array.length - 1, "random");
    }

    private static <T extends Comparable<T>> void QuickSort(T[] array, int left, int right, String pivotType) {
        if (left < right) {
            int pivotIndex;
            if ("high".equals(pivotType)) {
                pivotIndex = highPivotPartition(array, left, right);
            } else if ("low".equals(pivotType)) {
                pivotIndex = lowPivotPartition(array, left, right);
            } else {
                pivotIndex = randomPivotPartition(array, left, right);
            }
            QuickSort(array, left, pivotIndex - 1, pivotType);
            QuickSort(array, pivotIndex + 1, right, pivotType);
        }
    }

    private static <T extends Comparable<T>> int lowPivotPartition(T[] array, int left, int right) {
        T pivot = array[left];
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[left];
        array[left] = array[i];
        array[i] = temp;

        return i;
    }

    private static <T extends Comparable<T>> int highPivotPartition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }

    private static <T extends Comparable<T>> int randomPivotPartition(T[] array, int left, int right) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(right - left + 1) + left;

        T temp = array[randomIndex];
        array[randomIndex] = array[right];
        array[right] = temp;

        return highPivotPartition(array, left, right);
    }
}
