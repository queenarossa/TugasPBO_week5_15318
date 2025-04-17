package week5;

import java.util.ArrayList;

class TextGame {
    protected ArrayList<Character> characters = new ArrayList<>();

    public void inputText(String text) {
        characters.clear();
        for (char c : text.toCharArray()) {
            characters.add(Character.toUpperCase(c));
        }
    }

    public boolean isPalindrome() {
        return isPalindrome(this.characters);
    }

    public boolean isPalindrome(ArrayList<Character> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String text) {
        inputText(text);
        return isPalindrome();
    }
}

public class FancyTextGame extends TextGame {

    @Override
    public boolean isPalindrome() {
        System.out.print("Memeriksa kata: ");
        for (Character c : characters) {
            System.out.print(c + " ");
            try {
                Thread.sleep(200); // animasi sederhana
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
        boolean result = super.isPalindrome();
        System.out.println(result ? "-> Ini adalah palindrome!" : "-> Ini bukan palindrome.");
        return result;
    }
}
