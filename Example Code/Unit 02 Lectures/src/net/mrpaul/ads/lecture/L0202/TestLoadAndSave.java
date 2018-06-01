// Example 5.5

package net.mrpaul.ads.lecture.L0202;

import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class TestLoadAndSave{

   public static void main(String[]args){
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter a file name: ");
      String fileName = reader.nextLine();
      APImage image = new APImage(fileName);
      for (Pixel p: image){
         int red = p.getRed();
         int green = p.getGreen();
         int blue = p.getBlue();
         int average = (red + green + blue) / 3;
         p.setRed(average);
         p.setGreen(average);
         p.setBlue(average);
      }
      image.save();
      System.out.println("Image converted and saved.");
      System.exit(0);
   }
}
      