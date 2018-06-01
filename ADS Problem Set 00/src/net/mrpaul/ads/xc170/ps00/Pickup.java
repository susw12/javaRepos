/**            <-----------note the extra star
 *Bad pickup line!
 *Prints out a really terrible pickup line using the person you enter's name
 *<p>
 *Accel PS00: Print, Baby, Print!
 *Date: 2/7/2018
 *
 *@author Sujay Swain
 */
package net.mrpaul.ads.xc170.ps00;

import java.util.Scanner;


public class Pickup {
    /**
     * <p>Prints out terrible pickup line!</p>
     */
    public static void main(String[] args) {
        Scanner getName = new Scanner(System.in);
        System.out.print("What is this person's name? ");
        String name = getName.next();
        System.out.println("Hey " + name + ", if you were an SAT exam, you’d be a perfect 1600.");


    }//end main()
}//end Pickup
