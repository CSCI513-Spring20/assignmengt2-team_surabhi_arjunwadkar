import java.awt.Button;
//import java.lang.*;
import java.util.Random;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class OceanExplorer extends Application{
	final int dim = 10;
    final int scl = 50;
    final int island_count = 10;
    OceanMap map = new OceanMap();
    AnchorPane root ;
    Scene scene;
    boolean[][] grid = map.getMap();
    Image ShipImage, Pirateship, MyIsland, PirateIsland;
    ImageView ShipImageView, PirateShipView, PirateShipView2, MyIslandView, PirateIslandView;
    int x = 6;
    int y = 6;
    int x_cord = 4;
    int y_cord = 4;
    Ship ship = new Ship();
    PirateShip pirateS_1 = new PirateShip(); // objects of pirateShip class
    PirateShip pirateS_2 = new PirateShip();
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage oceanStage) throws Exception {
        root = new AnchorPane();
        scene = new Scene(root,scl*dim,scl*dim);
        Button button =  new Button("Reset");
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                Rectangle rect = new Rectangle(x*scl, y*scl, scl, scl);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.PALETURQUOISE);
                root.getChildren().add(rect);
            }
        }
        loadMyShipImage();
		/*
		 * button.setLayoutX(200); // setting x coordinate of the reset button
		 * button.setLayoutY(500); // setting y coordinate of the reset button
		 * root.getChildren().add(button); // adding button to the root
		 */
        loadPirateShip(x_cord,y_cord);
        loadPirateShip2(x_cord+1,y_cord+1);
        for(int z=0; z<island_count; z++){
            int a = (int)(Math.random()*10);
            int b = (int)(Math.random()*10);
            if(a != x && b != y) {
                if(a != x_cord && b != y_cord) {
                    if (a != (x_cord + 1) && b != (y_cord + 1)) {
                        loadMyIsland(a, b);
                    }
                }
            }
         }
        for(int z=0; z<island_count; z++){
            int a = (int)(Math.random()*10);
            int b = (int)(Math.random()*10);
            if(a != x && b != y) {
                if(a != x_cord && b != y_cord) {
                    if (a != (x_cord + 1) && b != (y_cord + 1)) {
                        loadPirateIsland(a, b);
                    }
                }
            }
         }
         
        oceanStage.setScene(scene);
        oceanStage.setTitle("Christopher Columbus Game");
        ship.addObserver(pirateS_1);
        ship.addObserver(pirateS_2);
        oceanStage.show();
        startSailing();

    }
    public void loadMyShipImage() throws Exception{
        ShipImage = new Image("ship.png",50,50,true,true);
        ShipImageView = new ImageView(ShipImage);
        map.setShipLocation(x,y);
        ShipImageView.setX(x * scl);
        ShipImageView.setY(y * scl);
        root.getChildren().add(ShipImageView);

    }
    public void loadPirateShip(int a  , int b) throws Exception{
        Pirateship = new Image("pirateShip.png",50,50,true,true);
        PirateShipView = new ImageView(Pirateship);
        pirateS_1.setShipLocation(a*scl,b*scl);
        PirateShipView.setX(a* scl);
        PirateShipView.setY(b* scl);
        root.getChildren().add(PirateShipView);

    }
    public void loadPirateShip2(int a  , int b) throws Exception{
        PirateShipView2 = new ImageView(Pirateship);
        pirateS_2.setShipLocation(a*scl,b*scl);
        PirateShipView2.setX(a* scl);
        PirateShipView2.setY(b* scl);
        root.getChildren().add(PirateShipView2);

    }
    public void loadMyIsland(int a, int b) throws Exception{
        MyIsland = new Image("island.jpg",50,50,true,true);
        MyIslandView = new ImageView(MyIsland);
        map.setShipLocation(a,b);
        MyIslandView.setX(a* scl);
        MyIslandView.setY(b* scl);
        root.getChildren().add(MyIslandView);

    }
	private void loadPirateIsland(int a, int b) throws Exception { 
		PirateIsland = new Image("PirateIsland.PNG", 50, 50, true, true);
		PirateIslandView = new ImageView(PirateIsland);
		map.setShipLocation(a, b);
		PirateIslandView.setX(a* scl); 
		PirateIslandView.setY(b* scl);
		root.getChildren().add(PirateIslandView);
	 }
    private void startSailing() {	//Method to  start Sailing
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){


            public void handle(KeyEvent key) {
                switch(key.getCode()) {
                    case RIGHT :
                        ship.goEast(map.getShipLocation().x*scl,map.getShipLocation().y*scl);
                        break;
                    case LEFT :
                        ship.goWest(map.getShipLocation().x*scl,map.getShipLocation().y*scl);
                        break;
                    case UP :
                        ship.goNorth(map.getShipLocation().x*scl,map.getShipLocation().y*scl);
                        break;
                    case DOWN :
                        ship.goSouth(map.getShipLocation().x*scl,map.getShipLocation().y*scl);
                        break;
                    default :
                        break;
                }
                ShipImageView.setX(ship.getShipLocation().x);
                ShipImageView.setY(ship.getShipLocation().y);
                PirateShipView.setX(pirateS_1.getShipLocation().x);
                PirateShipView.setY(pirateS_1.getShipLocation().y);
                PirateShipView2.setX(pirateS_2.getShipLocation().x);
                PirateShipView2.setY(pirateS_2.getShipLocation().y);
                map.setShipLocation(ship.getShipLocation().x/scl,ship.getShipLocation().y/scl);
                map.setShipLocation(pirateS_1.getShipLocation().x/scl, pirateS_1.getShipLocation().y/scl);
                map.setShipLocation(pirateS_2.getShipLocation().x/scl, pirateS_2.getShipLocation().y/scl);



            }
        });
    }

}