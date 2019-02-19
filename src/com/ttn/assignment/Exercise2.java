package com.ttn.assignment;

public class Exercise2 {
    public static void main(String[] args) {
        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type " +
                "and scrambled it to make a type specimen book. It has survived not only five centuries, but also" +
                " the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the" +
                " 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with" +
                " desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        findOccurences(str);
    }

    public static void findOccurences(String str) {
        for (String str1 : str.split(" ")) {
            int count = 0;
            for (String str2 : str.split(" ")) {
                if (str1.equals(str2))
                    count++;
            }
            str = str.replace(str1, "");
            if (count > 0)
                System.out.println("String : \"" + str1 + "\" has " + count + " Occurences");
        }
    }
}
