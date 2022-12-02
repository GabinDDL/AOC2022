package J1;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class Calories {

    private Scanner scanner;

    public Calories(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public int getNextCalorie() throws EndOfElve, NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();
        String s = scanner.nextLine();
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            throw new EndOfElve();
        }
    }

    public int getMaxCalorie() {
        boolean loop = true;
        int max = 0;
        int acc = 0;

        while (loop) {
            try {
                acc += getNextCalorie();
            } catch (EndOfElve e) {
                max = acc > max ? acc : max;
                acc = 0;
            } catch (NoSuchElementException e) {
                if (acc > 0) {
                    max = acc > max ? acc : max;
                }
                loop = false;
            }
        }
        scanner.close();
        return max;
    }

    public int indexMinOfTab(int[] t) {
        int accIndex = 0;

        for (int i = 1; i < t.length; i++) {
            if (t[i] < t[accIndex]) {
                accIndex = i;
            }
        }
        return accIndex;
    }

    public void addMaxTab(int[] t, int add) {
        int index = indexMinOfTab(t);
        if (t[index] < add)
            t[index] = add;
    }

    public int getThreeMaxCalorie() {
        boolean loop = true;
        int[] max = new int[3];
        int acc = 0;

        while (loop) {
            try {
                acc += getNextCalorie();
            } catch (EndOfElve e) {
                addMaxTab(max, acc);
                acc = 0;
            } catch (NoSuchElementException e) {
                if (acc > 0) {
                    addMaxTab(max, acc);
                }
                loop = false;
            }
        }
        scanner.close();
        return max[0] + max[1] + max[2];
    }

}