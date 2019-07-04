package telran_20190618;

import java.util.Comparator;
import java.util.Scanner;

public class StringCompareApp {
    public static void main(String[] args) {
        input();
    }

    // two strings eingeben
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Word1: ");
        String eingabe1 = scanner.nextLine();

        System.out.print("Word2: ");
        String eingabe2 = scanner.nextLine();
        System.out.println(eingabe1 + " " + eingabe2);

        Comparator comparator = (o1,o2) -> o1.toString().length()>o2.toString().length()?1:o1.toString().length()<o2.toString().length()?-1:0;

        int number = comparator.compare(eingabe1,eingabe2);
        System.out.println(number == 1 ? "Word one is larger" : number == -1 ? "Word one is smaller" : "Words are right");



        Comparator compare = (o1,o2) -> o1.equals(o2)?1:-1;
        scanner.close();




    }
}
