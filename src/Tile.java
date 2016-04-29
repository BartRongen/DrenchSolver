import java.awt.*;

/**
 * Created by Bart Rongen on 29-4-2016.
 */
public class Tile {

    public int color;
    public boolean active;
    public String colorname;
    public int colorid;
    public boolean visited;

    public Tile(int color, boolean active){
        this.color = color;
        this.active = active;
        this.visited = false;
        switch (color) {
            case -10040320:
                colorname = "green ";
                colorid = 0;
                break;
            case -24577:
                colorname = " rose ";
                colorid = 1;
                break;
            case -9158924:
                colorname = " blue ";
                colorid = 2;
                break;
            case -3342388:
                colorname = "white ";
                colorid = 3;
                break;
            case -65536:
                colorname = " red  ";
                colorid = 4;
                break;
            case -13312:
                colorname = "orange";
                colorid = 5;
                break;
            case -13254903:
                colorname = "success";
                break;
            case -308191:
                colorname = "failure";
                break;
        }
    }
}
