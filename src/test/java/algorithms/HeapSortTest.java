package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    void emptyArray() {
        int[] a = new int[]{};
        HeapSort.heapSort(a, null); // modify method if tracker is mandatory
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void singleElement() {
        int[] a = new int[]{5};
        HeapSort.heapSort(a, null);
        assertArrayEquals(new int[]{5}, a);
    }

    @Test
    void sortedAndReverse() {
        int[] a = new int[]{5,4,3,2,1};
        HeapSort.heapSort(a, null);
        assertArrayEquals(new int[]{1,2,3,4,5}, a);
    }

    @Test
    void duplicates() {
        int[] a = new int[]{2,3,2,3,2};
        HeapSort.heapSort(a, null);
        assertArrayEquals(new int[]{2,2,2,3,3}, a);
    }
}
