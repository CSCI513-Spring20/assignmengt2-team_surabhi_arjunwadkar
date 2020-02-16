import java.awt.Point;
import java.util.Observer;
import java.util.Observable;

public class PirateShip {
	public Point p_position = new Point();
	public Point shipPosition = new Point();
	public int[][] oceanGrid;
	public enum OceanItems
	{
		OCEAN(0),
		ISLAND(1),
		SHIP(2),
		PIRATE(3);
		
		public final int intValue;
		OceanItems(int intValue)
		{
			this.intValue = intValue;
		}
		
		public int getIntValue() { return intValue; }
	}
	
	public PirateShip(int x, int y, int[][] oceanGrid) {
		p_position.x = x;
		p_position.y = y;
		this.oceanGrid = oceanGrid;
	}
	
	public Point getShipLocation()
	{
		System.out.println("px: " + p_position.x + " | py: " + p_position.y);
		return p_position;
	}


	public void update(Observable o, Object arg1) 
	{
		if (o instanceof Ship)
		{
			shipPosition = ((Ship)o).getShipLocation();
			move();
		}
		
	}
	
	public void move()
	{
		System.out.println("MOVING");
		System.out.println("shipx: " + shipPosition.getLocation().x + " | shipy: " + shipPosition.getLocation().y);
		System.out.println("pShipx: " + p_position.getLocation().x + " | pShipy: " + p_position.getLocation().y);
		
		if (Math.abs(shipPosition.getLocation().x - p_position.getLocation().x) >= Math.abs(shipPosition.getLocation().y - p_position.getLocation().y))
		{
			if (shipPosition.getLocation().x > p_position.getLocation().x) 
			{
					if ((oceanGrid[p_position.x+1][p_position.y] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x+1][p_position.y] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().x < oceanGrid.length-1) 
					{
						p_position.x = p_position.x + 1;
					}					
					else
					{
						if (shipPosition.getLocation().y > p_position.getLocation().y && (oceanGrid[p_position.x][p_position.y+1] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x][p_position.y+1] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().y < oceanGrid.length-1)
						{
							p_position.y = p_position.y + 1;
						}
						else if (shipPosition.getLocation().y < p_position.getLocation().y && (oceanGrid[p_position.x][p_position.y-1] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x][p_position.y-1] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().y > 0)
						{
							p_position.y = p_position.y - 1;
						}
					}
					
			}
			else 
			{
				if ((oceanGrid[p_position.x-1][p_position.y] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x-1][p_position.y] == OceanItems.SHIP.getIntValue())) 
				{
					p_position.x = p_position.x - 1;
				}
				else
				{
					if (shipPosition.getLocation().y > p_position.getLocation().y && (oceanGrid[p_position.x][p_position.y+1] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x][p_position.y+1] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().y < oceanGrid.length-1)
					{
						p_position.y = p_position.y + 1;
					}
					else if (shipPosition.getLocation().y < p_position.getLocation().y && (oceanGrid[p_position.x][p_position.y-1] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x][p_position.y-1] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().y > 0)
					{
						p_position.y = p_position.y - 1;
					}
				}
				
			}
		}
		else
		{
			if (shipPosition.getLocation().y > p_position.getLocation().y && p_position.getLocation().y < oceanGrid.length-1) 
			{
				if (oceanGrid[p_position.x][p_position.y+1] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x][p_position.y+1] == OceanItems.SHIP.getIntValue()) 
				{
					p_position.y = p_position.y + 1;
				}
				else
				{
					if (shipPosition.getLocation().x > p_position.getLocation().x && (oceanGrid[p_position.x+1][p_position.y] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x+1][p_position.y] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().x < oceanGrid.length-1)
					{
						p_position.x = p_position.x + 1;
					}
					else if (shipPosition.getLocation().x < p_position.getLocation().x && (oceanGrid[p_position.x-1][p_position.y] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x-1][p_position.y] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().x > 0)
					{
						p_position.x = p_position.x - 1;
					}
				}
			}
			else 
			{
				if ((oceanGrid[p_position.x][p_position.y-1] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x][p_position.y-1] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().y > 0) 
				{
					p_position.y = p_position.y - 1;
				}
				else
				{
					if (shipPosition.getLocation().x > p_position.getLocation().x && (oceanGrid[p_position.x+1][p_position.y] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x+1][p_position.y] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().x < oceanGrid.length-1)
					{
						p_position.x = p_position.x + 1;
					}
					else if (shipPosition.getLocation().x < p_position.getLocation().x && (oceanGrid[p_position.x-1][p_position.y] == OceanItems.OCEAN.getIntValue() || oceanGrid[p_position.x-1][p_position.y] == OceanItems.SHIP.getIntValue()) && p_position.getLocation().x > 0)
					{
						p_position.x = p_position.x - 1;
					}
				}
			}
		}
	}
}