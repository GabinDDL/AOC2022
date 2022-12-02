package J2;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Use.Scan;

public class RockPaperScisor {

    private Scanner scanner;

    public RockPaperScisor(String nom) {
        scanner = Scan.getScanner(nom);
    }

    public String getNextTurn() throws NoSuchElementException {
        if (scanner == null || !scanner.hasNextLine())
            throw new NoSuchElementException();

        return scanner.nextLine();
    }

    /**
     * @param p1 Command of p1
     * @param p2 Command of p2
     * @return 0 for equal, 1 for p1, 2 for p2
     */
    public int getPointWin(char p1, char p2) {
        switch (p1) {
            case ('A'):
                if (p2 == 'X')
                    return 3;
                if (p2 == 'Y')
                    return 6;
                else
                    return 0;
            case ('B'):
                if (p2 == 'X')
                    return 0;
                if (p2 == 'Y')
                    return 3;
                else
                    return 6;
            case ('C'):
                if (p2 == 'X')
                    return 6;
                if (p2 == 'Y')
                    return 0;
                else
                    return 3;
            default:
                return 0;
        }
    }

    public int getPoint(char command) {
        switch (command) {
            case ('X'):
                return 1;
            case ('Y'):
                return 2;
            case ('Z'):
                return 3;
            default:
                return 0;
        }
    }

    public char getCommandPlayer(char p1, char s2) {
        switch (s2) {
            case ('X'):
                if (p1 == 'A')
                    return 'Z';
                if (p1 == 'B')
                    return 'X';
                if (p1 == 'C')
                    return 'Y';
                break;
            case ('Y'):
                if (p1 == 'A')
                    return 'X';
                if (p1 == 'B')
                    return 'Y';
                if (p1 == 'C')
                    return 'Z';
                break;
            case ('Z'):
                if (p1 == 'A')
                    return 'Y';
                if (p1 == 'B')
                    return 'Z';
                if (p1 == 'C')
                    return 'X';
                break;
            default:
                return ' ';
        }
        return ' ';
    }

    public int getPointRound() {
        boolean loop = true;
        int acc = 0;
        String turn = "";

        while (loop) {
            try {
                turn = getNextTurn();
                acc += getPoint(turn.charAt(2)) + getPointWin(turn.charAt(0), turn.charAt(2));
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return acc;
    }

    public int getPointRoundWS() {
        boolean loop = true;
        int acc = 0;
        String turn = "";

        while (loop) {
            try {
                turn = getNextTurn();
                char c2 = getCommandPlayer(turn.charAt(0), turn.charAt(2));
                acc += getPoint(c2) + getPointWin(turn.charAt(0), c2);
            } catch (NoSuchElementException e) {
                loop = false;
            }
        }
        return acc;
    }
}
