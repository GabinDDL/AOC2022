package J5;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class Cargo {

    private Scanner scanner;

    public Cargo(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public String getNextLine() throws NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();

        return scanner.nextLine();
    }

    public void changeMove(ArrayList<ArrayList<Character>> crates, String line) {
        String[] s = line.split(" ");

        for (int i = 0; i < Integer.valueOf(s[1]); i++) {

            crates.get(Integer.valueOf(s[5]) - 1).add(0, crates.get(Integer.valueOf(s[3]) - 1).get(0));
            crates.get(Integer.valueOf(s[3]) - 1).remove(0);
        }
    }

    public void changeMove9001(ArrayList<ArrayList<Character>> crates, String line) {
        String[] s = line.split(" ");

        for (int i = 0; i < Integer.valueOf(s[1]); i++) {
            crates.get(Integer.valueOf(s[5]) - 1).add(i, crates.get(Integer.valueOf(s[3]) - 1).get(0));
            crates.get(Integer.valueOf(s[3]) - 1).remove(0);
        }
    }

    public String topCrates() {
        ArrayList<String> ligneCrate = new ArrayList<>();
        String number = "";
        boolean loop = true;

        while (loop) {
            try {
                String s = getNextLine();
                if ((int) s.charAt(1) >= 47 && (int) s.charAt(1) <= 58) {
                    number = s;
                    loop = false;
                } else {
                    ligneCrate.add(s);
                }
            } catch (NoSuchElementException e) {
                return "";
            }
        }

        int len = (number.length() - 2) / 4;
        ArrayList<ArrayList<Character>> crates = new ArrayList<>();

        for (int i = 0; i < len + 1; i++) {
            crates.add(new ArrayList<>());
            for (String line : ligneCrate) {
                if (line.charAt(4 * i + 1) != ' ')
                    crates.get(i).add(line.charAt(4 * i + 1));
            }
        }

        getNextLine();

        loop = true;
        String line = "";

        while (loop) {
            try {
                line = getNextLine();
                changeMove(crates, line);
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }

        String rep = "";

        for (ArrayList<Character> a : crates) {
            rep += a.get(0);
        }
        return rep;
    }

    public String topCrates9001() {
        ArrayList<String> ligneCrate = new ArrayList<>();
        String number = "";
        boolean loop = true;

        while (loop) {
            try {
                String s = getNextLine();
                if ((int) s.charAt(1) >= 47 && (int) s.charAt(1) <= 58) {
                    number = s;
                    loop = false;
                } else {
                    ligneCrate.add(s);
                }
            } catch (NoSuchElementException e) {
                return "";
            }
        }

        int len = (number.length() - 2) / 4;
        ArrayList<ArrayList<Character>> crates = new ArrayList<>();

        for (int i = 0; i < len + 1; i++) {
            crates.add(new ArrayList<>());
            for (String line : ligneCrate) {
                if (line.charAt(4 * i + 1) != ' ')
                    crates.get(i).add(line.charAt(4 * i + 1));
            }
        }

        getNextLine();

        loop = true;
        String line = "";

        while (loop) {
            try {
                line = getNextLine();
                changeMove9001(crates, line);
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }

        String rep = "";

        for (ArrayList<Character> a : crates) {
            rep += a.get(0);
        }
        return rep;
    }
}
