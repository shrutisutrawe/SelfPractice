package SelfPractice;

import java.lang.String;

public class SearchChar {
    public int characterCountInString(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.toLowerCase().charAt(i) == Character.toLowerCase(c))
                count += 1;
        }
        System.out.println("\"" + s + "\" has " + count + " \'" + c + "\' in it.");
        return count;
    }

    public static void main(String[] args) {
        SearchChar sc = new SearchChar();
        String input = "Today is a beautiful day!";
        char ch = 'a';
        sc.characterCountInString(input, ch);


    }
}
