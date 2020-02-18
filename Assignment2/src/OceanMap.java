import java.awt.Point;

public class OceanMap {
	int x_cord;
	int y_cord;
	static boolean[][] grid = new boolean[10][10];

    public void setShipLocation(int i , int j){
        x_cord = i;
        y_cord = j;
    }

    public boolean[][] getMap() {
        return grid;
    }
    public Point getShipLocation(){
        return new Point(x_cord,y_cord);

    }

}