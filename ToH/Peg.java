import java.util.*;

/**
    
	The Peg class will keep track of the rings stacked on a peg. The peg may
	hold up to 64 rings, with each ring having its own diameter.
    
    @author Jeremy Hill
    @version 12.0.2
 */

public class Peg
{
	private int rings = 0;        //Holds the number of rings on the peg
	private int diam = 0;         //Holds the diameter of the top ring
	
	//ArrayList to holds "rings"
	private ArrayList<Integer> stack = new ArrayList<>();   
	//Create an ArrayList to copy and return the ArrayList stack
	private ArrayList<Integer> clone = new ArrayList<>();
	

	/**
     *	The constructor method fills the ArrayList with n integers. The 
     *	method also gives the variables rings and diam values. 
     *	@param n The number of "rings" to put on the peg.
	 */
	public Peg (int n)
	{	
		//Fills the ArrayList with n integers
		for (int i = 0; i < n; i++)
		{
			stack.add(i + 1);
		}
		
		//Sets the rings and diam variables depending on the size of n
		if (n != 0)
		{
			diam = stack.get(0);
			rings = n;
		}
		else
		{
			diam = 0;
			rings = n;
		}	
	}
	
	
	/**
     *	The getRings method returns the number of rings on this peg.
     *	@return The number of rings on this peg.
	 */
	public int getRings()
	{
		return rings;
	}
	
	
	/**
     * 	The getDiam method returns the diameter of the top ring or zero if 
     *	applicable.
     *	@return The diameter of the top ring.
	 */
	public int getDiam()
	{		
		return diam;
	}
	
	
	/**
     *	The addRing method adds a "ring" to the ArrayList of a given diameter
     *	at index zero. It then changes the value of the top diameter to the 
     *	newly added ring. Finally the ring counter is incremented.
     *	@param dia The diameter of the ring being added.
	 */ 
	public void addRing(int dia)
	{
		stack.add(0, dia);        //Adds ring to ArrayList
		diam = dia;               //Resets the top diameter
		rings++;		          //Adds ring to counter
	}
	
	
	/**
     *	The removeRing method removes the "ring" at index zero. Then the 
     *	diameter of the next ring now at index zero is set. Finally the ring 
     *	counter is decremented.
	 */
	public void removeRing()
	{
		stack.remove(0);          //Removes ring from ArrayList

		//Resets the top diameter
		if(stack.size() == 0)
		{
			diam = 0;
		}
		else
		{
			diam = stack.get(0);
		}
		
		rings--;                  //Removes ring from counter
	}
	
	
	/**
     *	The getArrayList method simply copies and returns the ArrayList stack.
     *	@return A copy of the ArrayList stack.
	 */
	public ArrayList getArrayList()
	{
		clone = stack;
		return clone;
	} 
}