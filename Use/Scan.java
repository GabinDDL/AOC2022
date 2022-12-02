package Use;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scan {

    public static Scanner getScanner(String nom) {
        try {
            return new Scanner(new File("Use/" + nom));
        } catch (IOException e) {
            System.out.println(nom + " n'a pas pu être ouvert.");
        }
        return null;
    }
}
