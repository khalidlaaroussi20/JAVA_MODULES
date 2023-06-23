package  ex02;

import java.util.Scanner;
import java.util.InputMismatchException;
class Program {

    static final int INFINITE_QUERIES_STOP = 42;
    private static int getSumDigit(int number) {

        int numberDigit = 0;

        while ( number != 0) {
            numberDigit += number % 10;
            number /= 10;
        }
        return  (numberDigit);
    }

    private static  boolean isPrime(int number) {
        int sqrtNumber = (int)Math.sqrt(number);

        for (int  i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return (true);
    }
    public static void main(java.lang.String[] strings) {
        int cnt = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("-->  ");
                int number = scanner.nextInt();
                if (number == INFINITE_QUERIES_STOP)
                    break;
                int sumDigit = getSumDigit(number);
                if (isPrime(sumDigit))
                    cnt++;
            }
        } catch (InputMismatchException e) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        System.out.println("Count of coffee-request : " + cnt);
    }
}