package  ex04;


import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;






class Program {

    private static  final  int MAX_HEIGHT = 10;


    private  static void printHistogram(ex04.Pair< Integer, ex04.Pair <Integer , Character> >[] topElements) {
        System.out.println();
        for (int i = 0; i < MAX_HEIGHT; i++) {
            System.out.print("     ");
            for (int j = 0; j < topElements.length; j++) {
                if (topElements[j].getSecond().getFirst() >= (10 - i)) {
                    if (topElements[j].getSecond().getFirst() == (10 - i))
                        System.out.print(topElements[j].getFirst());
                    else
                        System.out.print("#");
                }
                System.out.print("    ");
            }
            System.out.println();
        }
        System.out.print("     ");
        for (int j = 0; j < topElements.length; j++) {
            if (topElements[j].getSecond().getFirst() >= (0)) {
                if (topElements[j].getSecond().getFirst() == (0))
                    System.out.print(topElements[j].getFirst());
                else
                    System.out.print("#");
            }
            System.out.print("    ");
        }
        System.out.println();
        System.out.print("     ");
        for (int  i = 0; i < topElements.length; i++) {
            System.out.print(topElements[i].getSecond().getSecond());
            System.out.print("    ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("-->  ");
            int[] charsMap = new int[27];
            Arrays.fill(charsMap, 0);
            String sourceText = scanner.nextLine();

            for (int i = 0; i < sourceText.length(); i++) {
                char currChar = sourceText.charAt(i);
                if (currChar < 'A' || currChar > 'Z')
                    throw  new InputMismatchException();
                charsMap[currChar - 'A']++;
            }

            PriorityQueue<ex04.Pair<Integer, Character>> priorityQueue = new PriorityQueue<ex04.Pair<Integer, Character> >(new ex04.CountCharComparator());
            for (int i = 0; i < charsMap.length; i++) {
                if (charsMap[i] != 0) {
                    Character currChar = Character.valueOf((char)('A' + i));
                    priorityQueue.offer(new ex04.Pair(charsMap[i], currChar));
                }
            }

            Integer maxElement = priorityQueue.peek().getFirst();

            double numberUnit = (double)maxElement / MAX_HEIGHT;

            System.out.println("numberUnit == "  + numberUnit);

            ex04.Pair< Integer, ex04.Pair <Integer , Character> >[] topElements =
                    new ex04.Pair[Math.min(MAX_HEIGHT, priorityQueue.size())];

            for (int i = 0; i < topElements.length; i++) {
                ex04.Pair<Integer, Character> element = priorityQueue.poll();
                int heightElem = (int) ((double) element.getFirst() / numberUnit);
//                System.out.println(element.getSecond() + " ====> " + heightElem);
                ex04.Pair<Integer, Character> p = new ex04.Pair<>(Integer.valueOf(heightElem),element.getSecond());
                topElements[i] = new ex04.Pair<Integer,  ex04.Pair<Integer, Character>>(element.getFirst(), p);
            }
            printHistogram(topElements);


        } catch (InputMismatchException e) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }
}
//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO