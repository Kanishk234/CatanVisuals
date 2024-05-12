import javax.swing.JFrame;

public class Visual {
    public static void main(String[] args) {
        JFrame window = new JFrame("Catan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        //Add CatanPanel to the window
        CatanPanel cp = new CatanPanel();
        window.add(cp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        cp.launchGame();
    }
}