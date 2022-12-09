package J7;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class TakeScan {
    private Scanner scanner;

    public TakeScan(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public String getNextLine() throws NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();

        return scanner.nextLine();
    }

    public Bash getBash() {
        boolean loop = true;
        Bash b = new Bash(new Folder((getNextLine().split(" "))[2]));

        while (loop) {
            try {
                String s = getNextLine();
                b.takeLine(s);

            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return b;
    }
}
