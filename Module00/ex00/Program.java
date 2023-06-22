package ex00;


class Program {
    public static void main(java.lang.String[] strings) {
        int number = 123456;
        int numberDigit = 0;

        while ( number != 0) {
            numberDigit += number % 10;
            number /= 10;
        }
        System.out.println(numberDigit);
    }
}