package ex00;


import java.util.Scanner;
import java.util.InputMismatchException;

class Program {

    public static  class  PrimeNumberInfos {
        boolean isPrime = false;
        int     numberIteration = 0;

        PrimeNumberInfos(boolean isPrime, int     numberIteration ) {
            this.isPrime = isPrime;
            this.numberIteration = numberIteration;
        }

        @Override
        public String toString() {
            return isPrime  + " " + numberIteration;
        }


    }
    private static final int PRIME_NUMBER = 0;
    private static PrimeNumberInfos isPrime(int number) {
        int sqrtNumber = (int)Math.sqrt(number);

        for (int  i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0) {
                return new PrimeNumberInfos(false, i - 1);
            }
        }
        return (new PrimeNumberInfos(true, sqrtNumber));
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Read an integer from the user
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            if (number <= 1)
                throw new InputMismatchException();

            PrimeNumberInfos primeNumberInfos = isPrime(number);
            System.out.println(primeNumberInfos);
        } catch (InputMismatchException e) {
            System.out.println("IllegalArgument");
        }
    }
}