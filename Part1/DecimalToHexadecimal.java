package Part1;

public class DecimalToHexadecimal {
    public static String decimalToHexadecimal(int N) {
        if (N == 0) {
            return "0";
        }

        String hexDigits = "0123456789ABCDEF";
        String hexNumber = "";

        while (N > 0) {
            int remainder = N % 16;
            hexNumber = hexDigits.charAt(remainder) + hexNumber;
            N = N / 16;
        }

        return hexNumber;
    }

    public static void main(String[] args) {
        int N = 13;
        System.out.println("Hexadecimal representation of " + N + " is " + decimalToHexadecimal(N));
    }
}
