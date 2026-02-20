import java.util.Arrays;
import java.util.Random;

public class Sorter {

    static void main() {
        Random tilfeldig = new Random();
        int x = 3;
        int n = 32000;
        int antall = 10;

        long[][] insertionSortTabel = new long[x][4];

        for (int k = 0; k < x; k++) {
            int currentN = (int) (n * Math.pow(2,k));
            Integer[][] a = new Integer[antall][currentN];
            for (int i = 0; i < antall; i++) {
                for (int j = 0; j < currentN; j++) {
                    a[i][j] = tilfeldig.nextInt();
                }
            }
            long startTid = System.currentTimeMillis();
            for (int i = 0; i < antall; i++) {
                insertionSort(a[i]);
            }
            long endTid = System.currentTimeMillis();
            long duration = endTid - startTid;
            double avarge = (double) duration / antall;

            insertionSortTabel[k][0] = currentN;
            insertionSortTabel[k][1] = antall;
            insertionSortTabel[k][2] = (long)  avarge;
            insertionSortTabel[k][3] = (long) (insertionSortTabel[0][2]/Math.pow(n,2) * Math.pow(currentN,2));

        }
        space(3);
        printTable(insertionSortTabel,"insertion sort", "n^2");
        space(3);

        long[][] selectionSortTabel = new long[x][4];

        for (int k = 0; k < x; k++) {
            int currentN = (int) (n * Math.pow(2,k));
            Integer[][] a = new Integer[antall][currentN];
            for (int i = 0; i < antall; i++) {
                for (int j = 0; j < currentN; j++) {
                    a[i][j] = tilfeldig.nextInt();
                }
            }
            long startTid = System.currentTimeMillis();
            for (int i = 0; i < antall; i++) {
                selectionSort(a[i]);
            }
            long endTid = System.currentTimeMillis();
            long duration = endTid - startTid;
            double avarge = (double) duration / antall;

            selectionSortTabel[k][0] = currentN;
            selectionSortTabel[k][1] = antall;
            selectionSortTabel[k][2] = (long)  avarge;
            selectionSortTabel[k][3] = (long) (selectionSortTabel[0][2]/Math.pow(n,2) * Math.pow(currentN,2));

        }

        space(3);
        printTable(selectionSortTabel,"selection sort", "n^2");
        space(3);

        long[][] quickSortTabel = new long[x][4];

        for (int k = 0; k < x; k++) {
            int currentN = (int) (n * Math.pow(2,k));
            Integer[][] a = new Integer[antall][currentN];
            for (int i = 0; i < antall; i++) {
                for (int j = 0; j < currentN; j++) {
                    a[i][j] = tilfeldig.nextInt();
                }
            }
            long startTid = System.currentTimeMillis();
            for (int i = 0; i < antall; i++) {
                quickSort(a[i]);
            }
            long endTid = System.currentTimeMillis();
            long duration = endTid - startTid;
            double avarge = (double) duration / antall;

            quickSortTabel[k][0] = currentN;
            quickSortTabel[k][1] = antall;
            quickSortTabel[k][2] = (long)  avarge;
            quickSortTabel[k][3] = (long) ((quickSortTabel[0][2]/ (n*Math.log(n))) * currentN*Math.log(currentN));

        }

        space(3);
        printTable(quickSortTabel,"quick sort", "n*log(n)");
        space(3);

        long[][] mergeSortTabel = new long[x][4];

        for (int k = 0; k < x; k++) {
            int currentN = (int) (n * Math.pow(2,k));
            Integer[][] a = new Integer[antall][currentN];
            for (int i = 0; i < antall; i++) {
                for (int j = 0; j < currentN; j++) {
                    a[i][j] = tilfeldig.nextInt();
                }
            }
            long startTid = System.currentTimeMillis();
            for (int i = 0; i < antall; i++) {
                mergeSort(a[i]);
            }
            long endTid = System.currentTimeMillis();
            long duration = endTid - startTid;
            double avarge = (double) duration / antall;

            mergeSortTabel[k][0] = currentN;
            mergeSortTabel[k][1] = antall;
            mergeSortTabel[k][2] = (long)  avarge;
            mergeSortTabel[k][3] = (long) ((mergeSortTabel[0][2]/(n*Math.log(n))) * currentN*Math.log(currentN));

        }

        space(3);
        printTable(mergeSortTabel,"merge sort", " n*log(n)");
        space(3);

        /*
        long[][] quickSortTabelAllSame = new long[x][4];

        for (int k = 0; k < x; k++) {
            int currentN = (int) (n * Math.pow(2,k));
            Integer[][] a = new Integer[antall][currentN];
            for (int i = 0; i < antall; i++) {
                for (int j = 0; j < currentN; j++) {
                    a[i][j] = 32;
                }
            }
            long startTid = System.currentTimeMillis();
            for (int i = 0; i < antall; i++) {
                quickSort(a[i]);
            }
            long endTid = System.currentTimeMillis();
            long duration = endTid - startTid;
            double avarge = (double) duration / antall;

            quickSortTabelAllSame[k][0] = currentN;
            quickSortTabelAllSame[k][1] = antall;
            quickSortTabelAllSame[k][2] = (long)  avarge;
            quickSortTabelAllSame[k][3] = (long) ((quickSortTabelAllSame[0][2]/(n*Math.log(n))) * currentN*Math.log(currentN));

        }

        space(3);
        printTable(quickSortTabelAllSame,"quick sort (all er like)", " n * log(n)");
        space(3);
        */

    }

    static Integer[] insertionSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
        }
        return array;
    }

    static Integer[] selectionSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int currentvalue = array[i];
            array[i] = array[minIndex];
            array[minIndex] = currentvalue;
        }
        return array;
    }

    static Integer[] quickSort(Integer[] array) {
        if (array.length <= 1) {
            return array;
        }
        quickSortRecurrsive(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortRecurrsive(Integer[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSortRecurrsive(array, low, pi - 1);
            quickSortRecurrsive(array, pi + 1, high);
        }
    }

    private static int partition(Integer[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    static Integer[] mergeSort(Integer[] array) {
        if (array.length == 1) {
            return array;
        }else {
            mergeSortRecurrsive(array, 0, array.length - 1);
            return array;
        }
    }


    static void mergeSortRecurrsive(Integer[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortRecurrsive(array, low, mid);
            mergeSortRecurrsive(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }

    private static void merge(Integer[] a, int low, int mid, int high) {
        Integer[] temp = new Integer[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else  {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];

        }
        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            a[low + l] = temp[l];
        }
    }

    private static void printTable(long[][] tabel, String title, String eqString) {
        System.out.println(title);
        String[][] stringTab = new String[tabel.length+2][4];
        stringTab[0] = new String[]{"N", "Antall", "Målt tid", "Teoretisk tid"};
        stringTab[1] = new String[]{"", "Målinger", "(gjennomsnitt)", "c*" + eqString};
        for (int i = 0; i < tabel.length; i++) {
            for (int j = 0; j < tabel[i].length; j++) {
                stringTab[i+2][j] = String.valueOf(tabel[i][j]);
                if (j > 1)  stringTab[i+2][j] = stringTab[i+2][j] + "ms";
            }
        }
        int[] longestColumn = new int[stringTab[0].length];

        for (int i = 0; i < stringTab.length; i++) {
            for (int j = 0; j < stringTab[i].length; j++) {
                longestColumn[j] = Math.max(longestColumn[j], stringTab[i][j].length());
            }
        }
        for (int i = 0; i < stringTab.length; i++) {
            if (i != 1){
                System.out.print("+");
                for (int j = 0; j < longestColumn.length; j++) {
                    System.out.print(line(longestColumn[j]+2));
                    System.out.print("+");
                }
                System.out.println();
            }
            System.out.print("|");
            for (int j = 0; j < stringTab[i].length; j++) {
                System.out.print(adjustCell(stringTab[i][j], longestColumn[j]+1)+ " |");

            }
            System.out.println();
        }
        System.out.print("+");
        for (int j = 0; j < longestColumn.length; j++) {
            System.out.print(line(longestColumn[j]+2));
            System.out.print("+");
        }
        System.out.println();
    }

    private static String line (int len) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append("-");
        }
        return result.toString();
    }

    private static String adjustCell (String cell, int len) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len - cell.length(); i++) {
            result.append(" ");
        }
        result.append(cell);
        return result.toString();
    }

    private static void space(int len) {
        for (int i = 0; i < len; i++) {
            System.out.println();
        }
    }

}
