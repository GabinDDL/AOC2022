package J7;

public class Element {
    protected String name;
    protected int taille = 0;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTaille() {
        return taille;
    }

    public void print(int espace) {
        System.out.println(" ".repeat(espace) + name);
    }
}
