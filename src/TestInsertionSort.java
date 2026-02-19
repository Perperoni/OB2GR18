import java.util.Random;

public class TestInsertionSort {

    public static void main(String[] args) {

        int n = 150000; // størrelse på tabell
        int antall = 3; // antall målinger

        Integer[][] data = new Integer[antall][n];

        Random tilfeldig = new Random();

        for (int i = 0; i < antall; i++) {

            for (int j = 0; j < n; j++) {

                data[i][j] = tilfeldig.nextInt();
            }
        }

        long startTid = System.currentTimeMillis();

        for (int i = 0; i < antall; i++) {

            insertionSortOptimal(data[i]);
        }

        long sluttTid = System.currentTimeMillis();

        long totalTid = sluttTid - startTid;

        double gjennomsnitt = (double) totalTid / antall;

        System.out.println("Antall element: " + n);
        System.out.println("Antall målinger: " + antall);
        System.out.println("Total tid (ms): " + totalTid);
        System.out.println("Gjennomsnittstid (ms): " + gjennomsnitt);
    }


    // C
    // Ved å sette inn to element om gangen reduserer vi antall sammenlikninger og flyttinger.
    // Resultata viser at optimaliseringane reduserer utføringstida,
    // Sjølv om tidskompleksiteten framleis er O(n²).
    public static void insertionSortOptimal(Integer[] a) {

        int n = a.length;

        if (n <= 1) return;

        int minIndex = 0;

        for (int i = 1; i < n; i++) {

            if (a[i].compareTo(a[minIndex]) < 0) {

                minIndex = i;
            }
        }

        Integer temp = a[0];
        a[0] = a[minIndex];
        a[minIndex] = temp;

        int i = 1;

        while (i < n - 1) {

            Integer first = a[i];
            Integer second = a[i + 1];

            Integer minste, storste;

            if (first.compareTo(second) < 0) {

                minste = first;
                storste = second;

            } else {

                minste = second;
                storste = first;
            }

            int j = i - 1;

            while (storste.compareTo(a[j]) < 0) {

                a[j + 2] = a[j];
                j--;
            }

            a[j + 2] = storste;

            while (minste.compareTo(a[j]) < 0) {

                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = minste;

            i += 2;
        }

        if (i < n) {

            Integer siste = a[i];

            int j = i - 1;

            while (siste.compareTo(a[j]) < 0) {

                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = siste;
        }
    }
}