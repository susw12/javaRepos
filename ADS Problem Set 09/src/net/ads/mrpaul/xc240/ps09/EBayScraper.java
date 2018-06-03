package net.ads.mrpaul.xc240.ps09;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Summarizes ebay pages
 * Reads a text files with urls
 * Then access the appropriate Ebay page
 * Then scrapes the proper information
 * ADS PS09: Greedy redux + eBay
 * 6/2/2018
 *
 * @author Sujay Swain
 */
public class EBayScraper {
    /**
     * Prints out the Ebay information
     *
     * <p>Takes in the Ebay page information and prints the information for each one.</p>
     *
     * @param args
     * @throws IOException If ebay_urls.txt does not exist, it returns an error
     */
    public static void main(String[] args) throws IOException {
        File file = new File("ebay_urls.txt");
        Scanner fileReader = new Scanner(file);
        String line;
        String info;
        int itemNum = 0;
        while (fileReader.hasNext()) {
            line = fileReader.next();
            info = createInfoLine(itemNum, new URL(line));
            System.out.println(info);
            itemNum++;
        }
        fileReader.close();

    }

    /**
     * Creates eBay page info
     *
     * <p>Get the item number and Ebay page url</p>
     * <p>Then creates a formatted output of the information</p>
     *
     * @param itemNum number of item
     * @param url url of the eBay item
     * @return formatted info
     * @throws IOException Returns error is the url does not exist
     */
    public static String createInfoLine(int itemNum, URL url) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(url.openStream()));

        String itemName = "", highestBid = "", price = "", info = "", line;
        int start;
        int end;
        while ((line = b.readLine()) != null) {
            if (line.contains("<span id=\"vi-lkhdr-itmTitl\" class=\"u-dspn\">")) {
                start = line.indexOf("<span id=\"vi-lkhdr-itmTitl\" class=\"u-dspn\">");
                end = line.indexOf("</span>");
                itemName = line.substring(start + 43, end);
            }
            if (line.contains("itemprop=\"price\"")) {
                start = line.indexOf(">");
                end = line.indexOf("</span>");
                if (line.contains("prcIsum_bidPrice")) highestBid = line.substring(start + 1, end);
                else price = line.substring(start + 1, end);
            }



        }

        info += itemNum + ", ";
        info += itemName + ", ";
        if (! highestBid.equals("")) info += highestBid + ", ";
        if (! price.equals("")) info += price;
        b.close();
        return info;

    }
}