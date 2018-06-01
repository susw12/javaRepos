/*
 * Example 5.1

You can reset maximum heap size when running the program if you run out of memory
for large images, as follows:

java -Xmx<new size>m <program file name>

where <new size> is an integer.  Example:

java -Xmx128m TestDraw

allows up to 128 megabytes of heap space.
*/
package net.mrpaul.ads.lecture.L0201;

import images.APImage;

public class TestDraw{

   public static void main(String[]args){
      APImage image = new APImage("winbaby.png");
      image.draw();
   }  
}
      