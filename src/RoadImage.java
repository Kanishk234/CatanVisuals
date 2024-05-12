import java.awt.*;

public class RoadImage {
    private CatanImage roadImage;
    private String playerColor;
    public static double scale = 0.5;

    public RoadImage(String playerColor, int x, int y) {
        this.roadImage = new CatanImage("/catanImages/" + playerColor + "Road.png", x, y, 4, 35);
        this.playerColor = playerColor;
    }

    public void draw(Graphics2D g2) {
        roadImage.draw(g2);
    }

}
