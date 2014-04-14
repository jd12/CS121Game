import java.util.Random;

public class Discussion03 {
  
  // The main driver method.
  public static void main(String args[]) {
    
    // 1. What an array is.
    // 2. How to use a 1-d array.
    //    - Create it. Show off null error.
    //    - Set with iteration through it with for loop.
    //        - Function vs attribute for length() with array and string.
    //    - Get values with foreach loop.
    // 3. Create a 2-d array, using the for loop ideas from above.
    //   - Note the null errors here, if you just create the "rows".
    //   - Access the row length and column length.
    //   - 
    
    // Algorithm that says you are more likely to be next to another tree
    // Nested for each loop. Pick N random spots.
    // Then, find the spot that is the closest to an already existing tree
    
    OurArea area = new OurArea(1);
    // Use our area, and show the window.
    Window window = new Window("Discussion 03");
    window.requestFocus();
    window.add(area);
    window.pack();
    window.setVisible(true);
    area.start(); 
  }
  
}
