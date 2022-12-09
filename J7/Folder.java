package J7;

import java.util.ArrayList;

public class Folder extends Element {
    protected ArrayList<Element> elements;
    protected Folder parent;

    public Folder(String name) {
        super(name);
        elements = new ArrayList<>();
    }

    public Folder(String name, Folder parent) {
        super(name);
        elements = new ArrayList<>();
        this.parent = parent;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public Element getElement(String nom) {
        for (Element temp : elements) {
            if (temp.name.equals(nom)) {
                return temp;
            }
        }
        return null;
    }

    public void add(Element e) {
        elements.add(e);
        if (e instanceof Folder f) {
            f.parent = this;
        } else {
            Folder eTemp = this;
            while (eTemp != null) {
                eTemp.taille += e.taille;
                eTemp = eTemp.parent;
            }
        }
    }

    public void remove(Element e) {
        elements.remove(e);
    }

    public boolean contain(String nom) {
        for (Element temp : elements) {
            if (temp.name.equals(nom)) {
                return true;
            }
        }
        return false;
    }

    public void print(int espace) {
        System.out.println(" ".repeat(espace) + name);
        for (Element e : elements) {
            e.print(espace + 1);
        }
    }

    public int getSumMin(int max) {
        int acc = 0;
        for (Element e : elements) {
            if (e instanceof Folder f) {
                acc += f.getSumMin(max);
            }
        }
        if (taille > max)
            return acc;
        return acc + taille;
    }

    public int getTailleMin(int min) {
        if (taille < min) {
            return 0;
        }

        int acc = taille;
        for (Element e : elements) {
            if (e instanceof Folder f) {
                int temp = f.getTailleMin(min);
                acc = temp != 0 ? Math.min(acc, temp) : acc;
            }
        }
        return acc;
    }
}
