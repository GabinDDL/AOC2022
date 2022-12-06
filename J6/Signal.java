package J6;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class Signal {
    private Scanner scanner;

    public Signal(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public String getNextLine() throws NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();

        return scanner.nextLine();
    }

    public int compare(int n, String s) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public int getFirstMark(int n) {
        int index = 0;
        String ligne = getNextLine();

        while (index < ligne.length() - n + 1) {
            int i = compare(n, ligne.substring(index, index + n));
            if (i == -1) {
                return index + n;
            }
            index += i + 1;
        }
        return ligne.length();
    }
}
