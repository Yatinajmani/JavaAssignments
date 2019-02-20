package com.ttn.assignment;

public class Exercise4 {
    public static void main(String[] args) {
        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type " +
                "and scrambled it to make a type specimen book. It has survived not only five centuries, but also" +
                " the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the" +
                " 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with" +
                " desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        calculateCharacters(str);
    }

    private static void calculateCharacters(String str) {
        float lowercaseCharacters = 0;
        float uppercaseCharacters = 0;
        float digits = 0;
        float otherCharacters = 0;
        for (char ch : str.toCharArray()) {
            if (ch >= 65 && ch <= 90)
                uppercaseCharacters++;
            else if (ch >= 97 && ch <= 122)
                lowercaseCharacters++;
            else if (ch >= 48 && ch <= 57)
                digits++;
            else
                otherCharacters++;
        }
        System.out.println("No. of lowercase characters : " + lowercaseCharacters + " And % is " +lowercaseCharacters*100/str.length());
        System.out.println("No. of uppercase characters : " + uppercaseCharacters + " And % is " +uppercaseCharacters*100/str.length());
        System.out.println("No. of digits : " + digits + " And % is " + digits*100/str.length());
        System.out.println("No. of otherCharacters : " + otherCharacters + " And % is " +otherCharacters*100/str.length());
    }
}
