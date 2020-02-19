package TwentyFourty8;

import java.net.URL;

/**
 * COP3330C.01
 *
 * @author Emma
 */
public class Tile {

    private int value;
    private URL image;

    public Tile() {
        value = 0;
    }

    //changes the value of a merged tile
    public void merge(Tile tile) {
        this.setValue(value + tile.getValue());
    }

    //based on value, sets the image of the tile
    public URL getImage() {
        switch (value) {
            case 0:
                image = this.getClass().getClassLoader().getResource("");
                break;
            case 2:
                image = this.getClass().getClassLoader().getResource("liteblueheart.jpg");
                break;
            case 4:
                image = this.getClass().getClassLoader().getResource("mintheart.jpg");
                break;
            case 8:
                image = this.getClass().getClassLoader().getResource("orangeheart.jpg");
                break;
            case 16:
                image = this.getClass().getClassLoader().getResource("tealheart.jpg");
                break;
            case 32:
                image = this.getClass().getClassLoader().getResource("pinkheart.jpg");
                break;
            case 64:
                image = this.getClass().getClassLoader().getResource("coralheart.jpg");
                break;
            case 128:
                image = this.getClass().getClassLoader().getResource("lavender heart.jpg");
                break;
            case 256:
                image = this.getClass().getClassLoader().getResource("purpleheart.jpg");
                break;
            case 512:
                image = this.getClass().getClassLoader().getResource("blueheart.jpg");
                break;
            case 1024:
                image = this.getClass().getClassLoader().getResource("greenheart.jpg");
                break;
            case 2048:
                image = this.getClass().getClassLoader().getResource("redheart.jpg");
                break;
        }
        return image;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
