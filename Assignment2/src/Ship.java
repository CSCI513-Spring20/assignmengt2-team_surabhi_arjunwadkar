import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Ship extends Observable{
	int scale = 50;
	
	OceanMap oceanmap = new OceanMap();
    int x_cord = oceanmap.getShipLocation().x;
    int y_cord = oceanmap.getShipLocation().y;
    
    //method when right arrow is pressed
	public Point goEast(int x,int y) {
		if(x_cord != 450){
			x_cord = x + 50;
            y_cord = y;
        }
        else{
        	x_cord = x_cord;
            y_cord = y_cord;  
        }
		setChanged();
        notifyObservers();
        return new Point (x_cord , y_cord);
	}
	
	//method when left arrow is pressed
	public Point goWest(int x,int y) {
		if(x_cord != 0){
			x_cord = x - 50;
        	y_cord = y;
			x_cord = x_cord;
			y_cord = y_cord;
        }
        else{
			x_cord = x_cord;
			y_cord = y_cord;
        }
		setChanged();
        notifyObservers();
        return new Point(x_cord , y_cord);	
	}
	
	//method when top arrow is pressed
	public Point goNorth(int x,int y) {
		if(y_cord != 0){
			x_cord = x;
            y_cord = y - 50;
        }
        else{
        	x_cord = x_cord;
			y_cord = y_cord;
        }
		setChanged();
        notifyObservers();
        return new Point(x_cord , y_cord);	
	}
	
	//method when down arrow is pressed
	public Point goSouth(int x,int y) {
		if(y_cord != 450){
			x_cord = x;
            y_cord = y +50;
        }
        else{
        	x_cord = x_cord;
            y_cord = y_cord;
        }
        return new Point(x_cord , y_cord);	
	}

	// get ship location
	public Point getShipLocation() {
		
		return new Point(x_cord,y_cord);
	}
}