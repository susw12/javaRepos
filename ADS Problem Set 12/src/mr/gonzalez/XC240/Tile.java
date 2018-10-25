package mr.gonzalez.XC240;
/**
 *Defines a tile
 *
 *<p> Sets up a tile, which is basically a number.
 *
 *<p> ADSb PS12: 2048
 *
 *@author Sujay Swain
 */
public class Tile {
	//instance variables
	private int value;

	/**
	 * Tile default constructor
	 * <p> Default value is 0
	 * @author Wensen Liu
	 */
	Tile(){value = 0;}

	/**
	 * Tile constructor
	 * <p> Value is the given integer
	 * @author Wensen Liu
	 * @param num an integer value for the tile
	 */
	Tile(int num){
		if(num < 0) {value = 0;}
		else {value = num;}
	}

	/**
	 * Checks is the tile is empty
	 * <p> Defined as when the tiles value is 0
	 * @author Wensen Liu
	 * @return a boolean showing emptiness
	 */
	public boolean isEmpty(){
		if(value == 0) {return true;}
		else {return false;}
	}
	/**
	 * Gets the value of the tile
	 * @author Wensen Liu
	 * @return an integer that is the tile's value
	 */
	public int getValue(){return value;}

	/**
	 * Sets the value of the tile
	 * @author Wensen Liu
	 * @param val the value that the tile is to be set to
	 */
	public void setValue(int val){value = val;}

	/**
	 * Converts the tile to a string
	 * <p> Defined as the value of the tile
	 * @author Wensen Liu
	 * @return A string representation of the tile
	 */
	public String toString(){
		if(value == 0) {return "_";}
		else {return "" + value;}
	}

	/**
	 * Clones the tile
	 * <p> Creates a new tile that has the exact same value as the given tile
	 * @author Wensen Liu
	 * @return A tile that has the same value as the original tile
	 */
	public Tile clone(){
		Tile cloned = new Tile(value);
		return cloned;
	}
}
