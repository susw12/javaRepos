// Example 5.2
package net.mrpaul.ads.lecture.L0201;

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestBlank{

   public static void main(String[]args){
      Scanner reader = new Scanner(System.in);
      APImage image = new APImage(150, 150);
      image.draw();
      int y = image.getHeight() / 2;
      
      /*this goes through the row halfway down the image and 
      replaces each Pixel with a new Red one*/
      for (int x = 0; x <= image.getWidth(); x++)
         image.setPixel(x, y, new Pixel(255, 0, 0));
      
      /*
       * Alternatively, you could modify the RGB values of any
       * Pixel INSTEAD of making a brand new one, as we did above.
       * Example: 
       * for(int x = 0; x <= image.getWidth(); x++){
       * 	Pixel p = image.getPixel(x, y);
       * 	p.setRed(255);
       * }
       */
      
      System.out.print("Press return to continue:");
      reader.nextLine();
      image.draw();
   } 
}
      