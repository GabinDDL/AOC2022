package J7;

public class Bash {
    private Folder racine;
    private Folder current;

    public Bash(Folder f) {
        racine = f;
        current = f;
    }

    public Folder getRacine() {
        return racine;
    }

    public void takeLine(String line) {
        String[] split = line.split(" ");
        if (split.length == 0)
            return;

        if (split[0].equals("$")) {
            if (split[1].equals("cd")) {
                cd(split[2]);
                return;
            } else {
                return;
            }
        }

        if (split[0].equals("dir")) {
            createFolder(split[1]);
        } else {
            createFile(Integer.valueOf(split[0]), split[1]);
        }
    }

    public void createFile(int taille, String nom) {
        if (!current.contain(nom)) {
            current.add(new File(nom, taille));
        }
    }

    public void createFolder(String nom) {
        if (!current.contain(nom)) {
            current.add(new Folder(nom));
        }
    }

    public void cd(String nom) {
        if (nom.equals("/")) {
            current = racine;
        } else if (nom.equals("..")) {
            current = current.parent;
        } else if (current.contain(nom)) {
            Element e = current.getElement(nom);
            if (e instanceof Folder f) {
                current = f;
            }
        }
    }
}
