package fr.test.numbers;

public class NumberWorker {
    public boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalArgumentException("the number should be greather or equal 2");
        }
        boolean isPrime = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0){
                isPrime = false;
                break;
            }
        }
        return (isPrime);
    }

    public int digitsSum(int number) {
        int sumDigits = 0;
        while (number != 0) {
            sumDigits += number % 10;
            number /= 10;
        }
        return (sumDigits);
    }
}
