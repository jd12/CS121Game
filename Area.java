import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;


public class Area extends JPanel {

  // The trees that are scattered around the area.
  protected Tree trees[];
  
  // The area tile map.
  protected int tiles[][];
  
  // The grass and stone images used as the floor texture.
  private BufferedImage grassImage;
  private BufferedImage stoneImage;
  
  // To hide this parameter from being passed around.
  private Graphics2D g2;
  
  // Define some constants.
  protected static final int grass = 0;
  protected static final int stone = 1;
  protected static final int numTilesX = Window.WIDTH / 64;
  protected static final int numTilesY = Window.HEIGHT / 64;
  protected static final double maxTreeX = Window.WIDTH - Tree.WIDTH;
  protected static final double maxTreeY = Window.HEIGHT - Tree.HEIGHT;
  
  
  // The constructor for the Area class.
  public Area() {
    // Load the grass image from the file.
    try {
      grassImage = ImageIO.read(new URL("file:grass.png"));
    } catch (IOException e) {
      System.out.println("Failed to load 'grass.png' image.");
    }
    
    // Load the stone image from the file.
    try {
      stoneImage = ImageIO.read(new URL("file:stone.png"));
    } catch (IOException e) {
      System.out.println("Failed to load 'stone.png' image.");
    }
    
    g2 = null;
    
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
    setDoubleBuffered(true);
  }
  
  protected void drawGrass(int i, int j) {
    g2.drawImage(grassImage, null, i * 64, j * 64);
  }
  
  protected void drawStone(int i, int j) {
    g2.drawImage(stoneImage, null, i * 64, j * 64);
  }
  
  protected void drawTree(int i) {
    if (trees != null) {
      trees[i].draw(g2);
    }
  }
  
  // Overridden function from JPanel, which allows us to
  // write our own paint method which draws our area.
  @Override
  public void paint(Graphics g) {
    // This calls JPanel's paintComponent method to handle
    // the lower-level details of drawing in a window.
    super.paint(g);
    
    g2 = (Graphics2D)g;
    
    drawTiles();
    drawTrees();
    
    // Sync for cross-platform smooth rendering.
    Toolkit.getDefaultToolkit().sync();
  }
  
  protected void drawTiles() {
    // TODO: Implement in a child class.
  }
  
  protected void drawTrees() {
    // TODO: Implement in a child class.
  }
  
}