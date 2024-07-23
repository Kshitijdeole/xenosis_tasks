package Part1;

public class NumberIncreasingReversePyramid {
    public static void main(String[] args) {
        int rows = 6;
        printPattern(rows);
    }

    public static void printPattern(int n) {
        if (n == 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        printPattern(n - 1);
    }
}
