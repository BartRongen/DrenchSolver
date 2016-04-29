import javax.swing.*;
import java.awt.*;

/**
 * Created by Bart Rongen on 29-4-2016.
 */
public class Printer {

    public void print(Image image){
        System.out.println(image);
        ImageIcon icon=new ImageIcon(image);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(400,430);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void printTileMap(Tile[][] tiles){
        for(int j=0; j<tiles.length; j++){
            System.out.print("|");
            for (int i=0; i<tiles[j].length; i++){
                System.out.print(tiles[j][i].color + "|");
            }
            System.out.print("\n");
        }
        for(int j=0; j<tiles.length; j++){
            System.out.print("|");
            for (int i=0; i<tiles[j].length; i++){
                System.out.print(tiles[j][i].active + "|");
            }
            System.out.print("\n");
        }
    }
}
