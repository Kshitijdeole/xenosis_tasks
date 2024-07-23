package Part1;

public class HollowDiamondPattern {

    public static void holodimond(int n, int i) {
        for (int j = n; j > i; j--) {
            System.out.print(" ");
        }

        for (int k = 1; k <= (2 * i - 1); k++) {
            if (k == 1 || k == (2 * i - 1)) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int n = 6;

        for (int i = 1; i <= n; i++) {
            holodimond(n, i);
        }
        for (int i = n - 1; i >= 1; i--) {
            holodimond(n, i);
        }
    }

}
