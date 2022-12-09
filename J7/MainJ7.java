package J7;

public class MainJ7 {

    public static void main(String[] args) {
        TakeScan tk = new TakeScan("J71.txt");
        Bash b = tk.getBash();
        System.out.println(b.getRacine().getSumMin(100000));
        System.out.println(b.getRacine().getTailleMin(30000000 - (70000000 - b.getRacine().getTaille())));
    }
}
