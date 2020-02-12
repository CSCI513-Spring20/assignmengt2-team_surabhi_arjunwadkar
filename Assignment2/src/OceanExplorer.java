import java.awt.Point;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	boolean[][] islandMap;
	Pane root;
	final int dimensions = 10;
	final int islandCount = 10;
	final int scalingFactor = 50;
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	int x_co = 6;
	int y_co = 6;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	
@Override
public void start(Stage mapStage) throws Exception{
		oceanMap Map = new oceanMap(dimensions,, islandCount);
		islandMap = oceanMap.getMap();
		root = new AnchorPane();
		drawMap();
		ship = new ship(oceanMap);
		loadShipImage();
		scene = new Scene(root, 500, 500);
		mapStage.setTitle("Columbus Game");
		mapStage.setScene(scene);
		mapStage.show();
		startSailing();
	}

private void startSailing() {
	scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		
		public void handle(KeyEvent ke) {
            switch(ke.getCode()) {
                case RIGHT :
                    navy.goEast(Map.getLocation().x*scale,Map.getLocation().y*scale);
                    break;
                case LEFT :
                    navy.goWest(Map.getLocation().x*scale,Map.getLocation().y*scale);

                    break;
                case UP :
                    navy.goNorth(Map.getLocation().x*scale,Map.getLocation().y*scale);
                    break;
                case DOWN :
                    navy.goSouth(Map.getLocation().x*scale,Map.getLocation().y*scale);
                    break;
                default :
                    break;
            }
            ShipImageView.setX(navy.getLocation().x);
            ShipImageView.setY(navy.getLocation().y);

            Map.setLocation(navy.getLocation().x/50, navy.getLocation().y/50);
        }
    });
}

private void LoadShipImage() {
	Image shipImage = new Image("\\ship.png",50,50,true,true);
	shipImageView = new ImageView(shipImage);
	shipImageView.setX(x_co * scale);
	shipImageView.setY(y_co * scale);
	anchorPane.getChildren().add(shipImageView);
	
}

}