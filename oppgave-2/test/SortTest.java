import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    Integer[] array;

    @BeforeEach
    void setUp() {
        Random rand = new Random();
        int antall = 10;

        array = new Integer[antall];
        for (int i = 0; i < antall; i++) {
            array[i] = rand.nextInt(100);
        }
    }
    @Test
    void InsertionSortTest() {
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println("Unsorted: "+ Arrays.toString(array));
        Integer[] sortedArray = Sorter.insertionSort(array);
        System.out.println("Sorted: "+ Arrays.toString(sortedArray));
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void SelectionSortTest() {
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println("Unsorted: "+ Arrays.toString(array));
        Integer[] sortedArray = Sorter.selectionSort(array);
        System.out.println("Sorted: "+ Arrays.toString(sortedArray));
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void QuickSortTest() {
        System.out.println();
        System.out.println("Quick Sort");
        System.out.println("Unsorted: "+ Arrays.toString(array));
        Integer[] sortedArray = Sorter.quickSort(array);
        System.out.println("Sorted: "+ Arrays.toString(sortedArray));
        Assertions.assertTrue(isSorted(sortedArray));
    }

    @Test
    void MergeSortTest() {
        System.out.println();
        System.out.println("Merge Sort");
        System.out.println("Unsorted: "+ Arrays.toString(array));
        Integer[] sortedArray = Sorter.mergeSort(array);
        System.out.println("Sorted: "+ Arrays.toString(sortedArray));
        Assertions.assertTrue(isSorted(sortedArray));
    }

    static boolean isSorted(Integer[] sortedArray) {
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

