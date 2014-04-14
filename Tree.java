import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.*;
import java.net.URL;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;


public class Tree {
  
  // The x-y location of the tree in pixels.
  // For our purposes, the region is 640 by 480.
  protected int x;
  protected int y;
  
  //Variables to control how fast the tree moves when a key is pressed 
  private int speedX = 0; 
  private int speedY = 0; 
  
  // The size of the tree. For our purposes, this is
  // known to be the size of the tree image.
  public static final int WIDTH = 128;
  public static final int HEIGHT = 128;
  
  // The image of the tree.
  private Image treeImage;
  
  // The constructor for the Tree class. This allows
  // the user to specify the location of a tree.
  public Tree(int x, int y) {
    try {
      treeImage = ImageIO.read(new URL("file:evil_tree.png"));
      //Initial image file is too large for the screen 
      //We can scale it in java using the getScaledInstance method (similar to String's toLowerCase() method) 
      treeImage = treeImage.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
    } catch (IOException e) {
      System.out.println("Failed to load 'evil_tree.png' image.");
    }
    
    set_location(x, y);
  }
  
  // Set the location of the tree.
  public void set_location(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  //Method that will change the position of the tree. 
  public void move() 
  { 
   this.x=this.x+speedX; 
   this.y=this.y+speedY; 
  } 
  
  
  // Get the x-axis location of the tree.
  public int get_x() {
    return this.x;
  }
  
  // Get the y-axis location of the tree.
  public int get_y() {
    return this.y;
  }
  
  // Draw the tree at its location in the window.
  public void draw(Graphics2D g2) {
    g2.drawImage(treeImage, x, y, null);
  }

public void setSpeedY(int i) {
 speedY = i;
}

public void setSpeedX(int i) {
 speedX = i;
}
  
}