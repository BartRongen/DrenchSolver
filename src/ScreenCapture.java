import sun.rmi.runtime.Log;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Bart Rongen on 29-4-2016.
 */
public class ScreenCapture extends Thread{

    public void run(){
        Rectangle screenRect = new Rectangle(630, 309, 378, 378);
        BufferedImage capture = null;
        try {
            capture = new Robot().createScreenCapture(screenRect);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(capture, "bmp", new File("capture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public static void main(String[] args){
        new ScreenCapture().run();
    }
    */
}
