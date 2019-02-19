package com.ttn.assignment;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type " +
                "and scrambled it to make a type specimen book. It has survived not only five centuries, but also" +
                " the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the" +
                " 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with" +
                " desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Scanner scanner = new Scanner(System.in);
        System.out.println("String is : " + str);
        System.out.print("Enter character to Search : ");
        String string = scanner.next();
        System.out.println("No. of Occurences : " + findOccurences(str, string.charAt(0)));
    }

    public static int findOccurences(String str, char a) {
        int count = 0;
        if (str.indexOf(a) != -1) {
            str = str.replaceFirst(a + "", "");
            count = findOccurences(str, a);
            count++;
        }
        return count;
    }
}
