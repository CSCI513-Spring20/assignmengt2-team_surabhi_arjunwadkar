import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable{
	int scale = 50;
	int x_cor = 6;
	int y_cor= 6;
	Point currentLocation;
	
	
	public Point goEast(int x,int y) {
		if(x_cor >= 450){
            x_cor = x_cor;
            y_cor = y_cor;
        }
        else{
            x_cor = x + 50;
            y_cor = y;
        }
        return new Point (x_cor , y_cor);
		
	}
	public Point goWest(int x,int y) {
		if(x_cor <= 0){
			x_cor = x_cor;
			y_cor = y_cor;

        }
        else{
        	x_cor = x - 50;
        	y_cor = y;
        }
        return new Point(x_cor , y_cor);
		
		
	}
	public Point goNorth(int x,int y) {
		if(y_cor <= 0){
			x_cor = x_cor;
            y_cor = y_cor;
        }
        else{
        	x_cor = x;
            y_cor = y - 50;
        }
        return new Point(x_cor , y_cor);
		
	}
	public Point goSouth(int x,int y) {
		if(y_cor >= 450){
			x_cor = x_cor;
            y_cor = y_cor;

        }
        else{
        	x_cor = x;
            y_cor = y +50;
        }
        return new Point(x_cor , y_cor);
		
	}

	public Point getShipLocation() {
		
		return new Point(x_cor,y_cor);
	}
}