import javax.swing.JFrame;
import java.util.Scanner;

public class Visual {
    public static void main(String[] args) {
        JFrame window = new JFrame("Catan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        Scanner sc = new Scanner(System.in);

        //Add CatanPanel to the window
        CatanPanel cp = new CatanPanel();
        window.add(cp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        cp.launchGame();
//        System.out.println("Coordinates: ");
//        String input = sc.nextLine();
//        if (input.equals("1 1")) {
//            cp.addRoad(new RoadImage("blue", 199, 235));
//        }

        // call updateRobber on cp to change its x and y

    }
}