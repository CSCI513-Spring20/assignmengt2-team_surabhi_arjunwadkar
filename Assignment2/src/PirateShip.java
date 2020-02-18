import java.awt.Point;
import java.util.Observable;
import java.util.Observer;


public class PirateShip implements Observer {
    Point pirateship;
    Point columbusShip;
    int i,j ;
    @Override
    public void update(Observable Obs, Object arg) {

        if(Obs instanceof Ship) {
            columbusShip = ((Ship)Obs).getShipLocation();
            move_pirate_ship();
        }
    }

    // set pirate ship location
    public void setShipLocation (int x, int y) {
        i=x/50;j=y/50;
        OceanMap.grid[i][j]= true;
        pirateship =new Point(x,y);
    }

    // move pirate ship
    public void move_pirate_ship() {
        if (i+1<10&&pirateship.x - columbusShip.x < 0) {
            pirateship.x = pirateship.x + 50;
        }
        else if (i-1>-1&&pirateship.x - columbusShip.x > 0){
            pirateship.x =pirateship.x - 50;
        }

        if (j+1<10&&pirateship.y - columbusShip.y < 0) {
            pirateship.y = pirateship.y+ 50;
        }
        else if (j-1>-1&&pirateship.y - columbusShip.y > 0){
            pirateship.y = pirateship.y-50;
        }
    }

    // get pirate ship location
    public Point getShipLocation() {

        return new Point(pirateship.x, pirateship.y);
    }
}