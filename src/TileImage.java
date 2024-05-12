import java.awt.*;

public class TileImage {
    private CatanImage resourceImage;
    private CatanImage numberToken;
    public static double scale = 0.5;


    public TileImage(String resource, int token, int x, int y) {
        resourceImage = new CatanImage("/catanImages/" + resource + ".png", x, y, (int)(175 * scale), (int)(201*scale));
        // using x and y of image, develop some math thing for x and y of number token
        numberToken = new CatanImage("/catanImages/" + token + ".png", x+ (int)(63 * scale), y+ (int)(76*scale), (int)(49 * scale), (int)(49 * scale));
    }

    public void draw(Graphics2D g2) {
        resourceImage.draw(g2);
        numberToken.draw(g2);
    }
}
