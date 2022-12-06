package J3;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class RumStack {

    private Scanner scanner;

    public RumStack(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public String getNextLine() throws NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();

        return scanner.nextLine();
    }

    public char communChar(String s1, String s2) throws NoSuchElementException {
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    return s1.charAt(i);
            }
        }
        throw new NoSuchElementException();
    }

    public char communChar(ArrayList<Character> chars, String s) throws NoSuchElementException {
        for (char c : chars) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c)
                    return c;
            }
        }
        throw new NoSuchElementException();
    }

    public ArrayList<Character> communsChar(String s1, String s2) throws NoSuchElementException {
        ArrayList<Character> chars = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    if (!chars.contains(s1.charAt(i))) {
                        chars.add(s1.charAt(i));
                    }
            }
        }
        return chars;
    }

    public int priorityChar(char c) {
        if (((int) c) >= 65 && ((int) c) <= 90) {
            return ((int) c) - 38;
        } else if (((int) c) >= 97 && ((int) c) <= 122) {
            return ((int) c) - 96;
        }
        return 0;
    }

    public int sumPriorityRumStack() {
        boolean loop = true;
        int acc = 0;
        String line = "";

        while (loop) {
            try {
                line = getNextLine();
                String s1 = line.substring(0, line.length() / 2);
                String s2 = line.substring(line.length() / 2, line.length());
                acc += priorityChar(communChar(s1, s2));
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return acc;
    }

    public int sumGroupPriorityRumStack() {
        boolean loop = true;
        int acc = 0;
        String line1;
        String line2;
        String line3;

        while (loop) {
            try {
                line1 = getNextLine();
                line2 = getNextLine();
                line3 = getNextLine();
                acc += priorityChar(communChar(communsChar(line1, line2), line3));
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return acc;
    }
}
