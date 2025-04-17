package week5;

import java.util.ArrayList;
import java.util.Scanner;

// Kelas dasar
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

// Kelas turunan
class FancyTextGame extends TextGame {
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

// Kelas Main (program utama)
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata: ");
        String input = scanner.nextLine();

        FancyTextGame game = new FancyTextGame();
        boolean isPalindrome = game.isPalindrome(input);

        System.out.println("Hasil: " + (isPalindrome ? "Palindrome" : "Bukan Palindrome"));

        scanner.close();
    }
}
