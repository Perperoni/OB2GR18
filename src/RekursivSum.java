public class RekursivSum {

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    public static void main(String[] args) {
        int resultat = sum(100);
        System.out.println("S100 = " + resultat);
    }
}
