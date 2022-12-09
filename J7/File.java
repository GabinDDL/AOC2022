package J7;

public class File extends Element {

    File(String name, int taille) {
        super(name);
        this.taille = taille;
    }

    public void print(int espace) {
        System.out.println(" ".repeat(espace) + taille + " " + name);
    }
}