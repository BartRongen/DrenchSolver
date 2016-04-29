import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Bart Rongen on 29-4-2016.
 */
public class Runner {

    public void run(){
        Printer printer = new Printer();
        Creater creater = new Creater();
        //Clicker clicker = new Clicker();
        creater.finished = false;
        Tile[][] tiles = new Tile[14][14];
        Thread t = new Thread(new ScreenCapture());
        Thread clicker;
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            BufferedImage capture = ImageIO.read(new File("capture.png"));
            //printer.print(capture);
            tiles = creater.createTileMap(capture);
            //printer.printTileMap(tiles);
            for (int i=0; i<30; i++){
                clicker = new Thread(new Clicker(creater.getMax()));
                clicker.start();
                clicker.join();
                Thread.sleep(50);
                t = new Thread(new ScreenCapture());
                t.start();
                t.join();
                capture = ImageIO.read(new File("capture.png"));
                tiles = creater.createTileMap(capture);
                //printer.printTileMap(tiles);
                if (creater.finished){
                    Thread.sleep(750);
                    break;
                }
            }
            clicker = new Thread(new Clicker(6));
            clicker.start();
            clicker.join();
            //run();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Runner().run();
    }

}
