

public class OurArea extends Area  {
  
  /*
  // The trees that are scattered around the area.
  Tree trees[];
  
  // The area tile map, with each tile represented as an integer.
  int tiles[][];
  
  // The tile values for grass (0) and stone (1) tiles.
  int grass;
  int stone;
  
  // The number of tiles on the x-axis, and y-axis.
  int numTilesX;
  int numTilesY;
  
  // The maximum position of a tree on the x-axis and y-axis.
  // Note: The minimum is simply (0, 0).
  double maxTreeX;
  double maxTreeY;
  */
 
  // The constructor for OurArea. It takes in a parameter for the
  // number of trees to place in the area.
  public OurArea(int numberOfTrees) 
  {
    super(); //Required since we extend Ara 
    
    /* Exercise #1. Setup the tree objects at random locations.*/ 
    
    //Sets the size of the tree array (sets every thing to null)
   trees = new Tree[numberOfTrees];
   
   /*actually initializes each place to hold a random value
    * Guarantees to be placed within the screen by multiplying by 
    * maximum position that it could be at 
    * remember what Math.random returns and think about how this makes 
    * it true
    * */ 
    for(int i = 0; i < trees.length; i++)
   {
     trees[i] = new Tree( (int)(Math.random() * maxTreeX), 
                         (int) (Math.random() *  maxTreeY)); 
     
   }
    
    /*Exercise #3. Initialize the tiles*/
   
   //Sets the size of the tiles array 
    tiles = new int[numTilesX][numTilesY];
    
    //actually initializes the tiles to hold a value 
    for(int i = 0; i < numTilesX; i++)
    {
      for(int j = 0; j <numTilesY; j++)
      {
        // Example: Default to grass everywhere.
        tiles[i][j] = grass; 
     
      }//end of inner for loop 
    }//end of outer for loop 
    
    
    /*Example: Draw two stones at specific locations(top left, and bottom right). */
    tiles[0][0] = stone;
    tiles[numTilesX-1][numTilesY-1] = stone; //Why do I have to subtract one to place it in the bottom right corner(think about how we index arrays)? 
        
  } //end of constructor 
  
  // This function must draw each tree to the screen.
  // Does not need tiles (try commenting out the drawGrass function and see what happens)
  protected void drawTrees() {
    //* Exercise #2. Draw the trees.
    for(int i = 0; i < trees.length; i++)
    {
      drawTree(i); 
    }
    //*/
  }
  
  
  protected void drawTiles() 
  {
    /* Exercise #4. Draw the tiles.*/
    
    /*Need a nested for loop to go through the rows 
     * and the columns
     * */ 
    for (int i = 0; i < numTilesX; i++) 
    {
      for (int j = 0; j < numTilesY; j++) 
      {
        if (tiles[i][j] == grass) 
        {
          drawGrass(i, j);
        } 
        else if(tiles[i][j] == stone) 
        {
          
          drawStone(i, j);
        }//end of else 
      }//end of inner for loop
    } //end of outer for loop 
 
  } //end of drawTiles method 
  
  
//Method that will continually run until we exit the program 
public void start() 
{
 while(true) 
 { 
  try 
  { 
   Thread.sleep(16);
   trees[0].move();
   repaint(); 
  }catch(Exception e) 
  { 
  e.printStackTrace(); 
  } 
 } 
 
}

 

}
