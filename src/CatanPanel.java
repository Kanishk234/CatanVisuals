import javax.swing.JPanel;
import java.awt.*;
import java.util.LinkedList;

public class CatanPanel extends JPanel implements Runnable{

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int FPS = 60;
    Thread gameThread;
    private LinkedList<TileImage> imgs;

    public CatanPanel() {
        //Panel Settings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.imgs = new LinkedList<>();
        setupImages();
    }

    public void setupImages() {
        // hardcode all tile imgs and num imgs and add to list
        //first row - 3
        imgs.add(new TileImage("brick", 9, 200, 100));
        imgs.add(new TileImage("ore", 5, 200 + (int)(TileImage.scale * 170), 100));
        imgs.add(new TileImage("wood", 5, 200 + (int)(2 * TileImage.scale * 170), 100));

        //second row - 4
        imgs.add(new TileImage("sheep", 3, 200 - (int)(0.5 * TileImage.scale * 170), 100 + (int)(TileImage.scale * 152)));
        imgs.add(new TileImage("wheat", 3, 200 + (int)(0.5 * TileImage.scale * 174), 100 + (int)(TileImage.scale * 152)));
        imgs.add(new TileImage("brick", 12, 200 + (int)(3 * 0.5 * TileImage.scale * 170), 100 + (int)(TileImage.scale * 152)));
        imgs.add(new TileImage("wood", 8, 200 + (int)(5 * 0.5 * TileImage.scale * 170), 100 + (int)(TileImage.scale * 152)));

        //third row - 5
        imgs.add(new TileImage("wheat", 6, 200 - (int)(2 * 0.5 * TileImage.scale * 170), 100 + (int)(2 * TileImage.scale * 152)));
        imgs.add(new TileImage("wheat", 6, 200, 100 + (int)(2 * TileImage.scale * 152)));
        imgs.add(new TileImage("wood", 2, 200 + (int)(2 * 0.5 * TileImage.scale * 170), 100 + (int)(2 * TileImage.scale * 152)));
        imgs.add(new TileImage("wood", 2, 200 + (int)(2 * TileImage.scale * 170), 100 + (int)(2 * TileImage.scale * 152)));
        imgs.add(new TileImage("wood", 2, 200 + (int)(2 * 1.5 * TileImage.scale * 170), 100 + (int)(2 * TileImage.scale * 152)));

        //fourth row - 4
        imgs.add(new TileImage("sheep", 3, 200 - (int)(0.5 * TileImage.scale * 170), 100 + (int)(3 * TileImage.scale * 152)));
        imgs.add(new TileImage("wheat", 3, 200 + (int)(0.5 * TileImage.scale * 174), 100 + (int)(3 * TileImage.scale * 152)));
        imgs.add(new TileImage("brick", 12, 200 + (int)(3 * 0.5 * TileImage.scale * 170), 100 + (int)(3 * TileImage.scale * 152)));
        imgs.add(new TileImage("wood", 8, 200 + (int)(5 * 0.5 * TileImage.scale * 170), 100 + (int)(3 * TileImage.scale * 152)));

        //fifth row - 3
        imgs.add(new TileImage("brick", 9, 200, 100 + (int)(4 * TileImage.scale * 152)));
        imgs.add(new TileImage("ore", 5, 200 + (int)(TileImage.scale * 170), 100 + (int)(4 * TileImage.scale * 152)));
        imgs.add(new TileImage("wood", 5, 200 + (int)(2 * TileImage.scale * 170), 100 + (int)(4 * TileImage.scale * 152)));
    }

    public void launchGame() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        //Game loop redraws and updates screen 60 times per second
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (this.gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint(); // calls paintComponent
                delta--;
            }
        }
    }

    private void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //this.pm.draw(g2);
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        for (TileImage ci : imgs) {
            ci.draw(g2);
        }
    }
}
