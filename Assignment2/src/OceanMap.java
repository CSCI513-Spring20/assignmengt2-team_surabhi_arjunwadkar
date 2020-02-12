import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.awt.Point;

public class OceanMap {
	int x_coord =6;
	int y_coord =6;
	private int  dimensions=10;
	final int scale = 50;
	


	
	public void getMap(Pane root){
		for(int x = 0; x < dimensions; x++){
			 for(int y = 0; y < dimensions; y++){
				 Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.blue);
			root.getChildren().add(rect);
			}
			}
		 }
	public Point getShipLocation() {

		return new Point(x_coord,y_coord);
	}
	
	public void setFinal(int a, int b) {
		x_coord =a;
		y_coord =b;
	}
}