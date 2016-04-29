import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Bart Rongen on 29-4-2016.
 */
public class Clicker extends Thread{

    private int color;

    public Clicker(int color){
        this.color = color;
    }

    public void run() {
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        switch (color) {
            case 0:
                bot.mouseMove(1090, 410);
                break;
            case 1:
                bot.mouseMove(1150, 410);
                break;
            case 2:
                bot.mouseMove(1210, 410);
                break;
            case 3:
                bot.mouseMove(1090, 480);
                break;
            case 4:
                bot.mouseMove(1150, 480);
                break;
            case 5:
                bot.mouseMove(1210, 480);
                break;
            case 6:
                bot.mouseMove(800, 480);
        }
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
