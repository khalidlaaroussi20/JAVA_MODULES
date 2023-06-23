package  ex03;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

class Program {

    static final String INFINITE_QUERIES_STOP = "42";
    static final int NUMBER_PROGRESS_STUDENT_IN_WEEK = 5;

    public static void main(java.lang.String[] strings) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> progressStudentsCharts = new ArrayList<>();
        try {
            int i = 1;

            while (true) {
                System.out.print("-->  ");
                String week = scanner.nextLine();
                if (week.equals(INFINITE_QUERIES_STOP))
                    break;
                else if (!week.equals("Week " + i))
                    throw new InputMismatchException();
                System.out.print("-->  ");
                int minProgress = 999999999;
                for (int j = 0; j < NUMBER_PROGRESS_STUDENT_IN_WEEK; j++) {
                    int progress = scanner.nextInt();
                    if (progress < 1 || progress > 9)
                        throw new InputMismatchException();
                    minProgress = Math.min(minProgress, progress);
                }
                scanner.nextLine();
                progressStudentsCharts.add(minProgress);
                i++;
            }
        } catch (InputMismatchException e) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        for (int i = 0; i < progressStudentsCharts.size(); i++)  {
            System.out.print("    Week ");
            System.out.print(i);
            System.out.print(" ");
            for (int  j = 0; j < progressStudentsCharts.get(i); j++)
                System.out.print("=");
            System.out.println(">");
        }
    }
}