package J4;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class Pair {
    private Scanner scanner;

    public Pair(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public String getNextLine() throws NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();

        return scanner.nextLine();
    }

    public void replacePairs(int[] pairs, String line) {
        if (pairs.length != 4)
            return;
        String[] e = line.split(",");
        if (e.length != 2)
            return;
        String[] e1 = e[0].split("-");
        String[] e2 = e[1].split("-");
        pairs[0] = Integer.valueOf(e1[0]);
        pairs[1] = Integer.valueOf(e1[1]);
        pairs[2] = Integer.valueOf(e2[0]);
        pairs[3] = Integer.valueOf(e2[1]);
    }

    public boolean oneContainPair(int[] pair) {
        return pair[0] <= pair[2] && pair[1] >= pair[3] || pair[0] >= pair[2] && pair[1] <= pair[3];
    }

    public boolean isOverlap(int[] pair) {
        return pair[0] >= pair[2] && pair[0] <= pair[3] || pair[1] >= pair[2] && pair[1] <= pair[3]
                || pair[2] >= pair[0] && pair[2] <= pair[1] || pair[3] >= pair[0] && pair[3] <= pair[1];
    }

    public int containPair() {
        boolean loop = true;
        int acc = 0;
        String line = "";
        int[] pairs = new int[4];

        while (loop) {
            try {
                line = getNextLine();
                replacePairs(pairs, line);
                acc += oneContainPair(pairs) ? 1 : 0;
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return acc;
    }

    public int overlapPair() {
        boolean loop = true;
        int acc = 0;
        String line = "";
        int[] pairs = new int[4];

        while (loop) {
            try {
                line = getNextLine();
                replacePairs(pairs, line);
                acc += isOverlap(pairs) ? 1 : 0;
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return acc;

    }
}
