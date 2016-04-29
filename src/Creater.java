import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Bart Rongen on 29-4-2016.
 */
public class Creater {

    private Tile[][] tiles;
    private int[] counter;
    public boolean finished;
    public boolean success;

    public Tile[][] createTileMap(BufferedImage image){
        int dx = image.getWidth()/14;
        int dy = image.getHeight()/14;

        tiles = new Tile[14][14];
        counter = new int[6];
        for (int i=0; i<counter.length; i++){
            counter[i] = 0;
        }

        for (int j=0; j<14; j++){
            for (int i=0; i<14; i++){
                BufferedImage subimage = image.getSubimage(i*dx, j*dy, dx, dy);
                boolean active = false;
                int color = subimage.getRGB((int) subimage.getWidth()/2, (int) subimage.getHeight()/2);
                tiles[j][i] = new Tile(color, active);
            }
        }
        tiles[0][0].active = true;
        tiles[0][0].visited = true;
        checkActive(0,0,tiles[0][0].color);

        if (tiles[1][1].colorname == "success"){
            finished = true;
            success = true;
            System.out.println("finished");
        } else if (tiles[1][1].colorname == "failure"){
            finished = true;
            success = false;
        }

        return tiles;
    }

    private void checkActive(int x, int y, int color){
        try {
            if (tiles[y - 1][x].color == color && !tiles[y - 1][x].visited) {
                tiles[y - 1][x].active = true;
                tiles[y - 1][x].visited = true;
                checkActive(x, y - 1, color);
            } else if (tiles[y - 1][x].color != color && !tiles[y - 1][x].visited){
                counter[tiles[y - 1][x].colorid]++;
                tiles[y - 1][x].visited = true;
                checkMatchingForCounting(x, y - 1, tiles[y - 1][x].color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            if (tiles[y][x - 1].color == color && !tiles[y][x - 1].visited) {
                tiles[y][x - 1].active = true;
                tiles[y][x - 1].visited = true;
                checkActive(x - 1, y, color);
            } else if (tiles[y][x - 1].color != color && !tiles[y][x - 1].visited){
                counter[tiles[y][x - 1].colorid]++;
                tiles[y][x - 1].visited = true;
                checkMatchingForCounting(x - 1, y, tiles[y][x - 1].color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            if (tiles[y + 1][x].color == color && !tiles[y + 1][x].visited) {
                tiles[y + 1][x].active = true;
                tiles[y + 1][x].visited = true;
                checkActive(x, y + 1, color);
            } else if (tiles[y + 1][x].color != color && !tiles[y + 1][x].visited){
                counter[tiles[y + 1][x].colorid]++;
                tiles[y + 1][x].visited = true;
                checkMatchingForCounting(x, y + 1, tiles[y + 1][x].color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            if (tiles[y][x + 1].color == color && !tiles[y][x + 1].visited) {
                tiles[y][x + 1].active = true;
                tiles[y][x + 1].visited = true;
                checkActive(x + 1, y, color);
            } else if (tiles[y][x + 1].color != color && !tiles[y][x + 1].visited){
                counter[tiles[y][x + 1].colorid]++;
                tiles[y][x + 1].visited = true;
                checkMatchingForCounting(x + 1, y, tiles[y][x + 1].color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
    }

    private void checkMatchingForCounting(int x, int y, int color){

        try{
            if (tiles[y - 1][x].color == color && !tiles[y - 1][x].visited) {
                counter[tiles[y - 1][x].colorid]++;
                tiles[y - 1][x].visited = true;
                checkMatchingForCounting(x, y - 1, color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            if (tiles[y][x - 1].color == color && !tiles[y][x - 1].visited) {
                counter[tiles[y][x - 1].colorid]++;
                tiles[y][x - 1].visited = true;
                checkMatchingForCounting(x - 1, y, color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            if (tiles[y + 1][x].color == color && !tiles[y + 1][x].visited) {
                counter[tiles[y + 1][x].colorid]++;
                tiles[y + 1][x].visited = true;
                checkMatchingForCounting(x, y + 1, color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            if (tiles[y][x + 1].color == color && !tiles[y][x + 1].visited) {
                counter[tiles[y][x + 1].colorid]++;
                tiles[y][x + 1].visited = true;
                checkMatchingForCounting(x + 1, y, color);
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public int getMax(){
        int max = 0;
        int index = 0;
        for (int i=0; i<counter.length; i++) {
            if (counter[i] > max) {
                max = counter[i];
                index = i;
            }
        }
        return index;
    }
}
