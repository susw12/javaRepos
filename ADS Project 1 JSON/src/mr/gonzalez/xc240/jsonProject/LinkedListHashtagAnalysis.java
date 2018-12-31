package mr.gonzalez.xc240.jsonProject;

import swain.sujay.xc240.ListType.MyArrayList;
import swain.sujay.xc240.ListType.MyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListHashtagAnalysis {
    MyLinkedList<String> ltext = new MyLinkedList<>();
    MyLinkedList<String> lid_str = new MyLinkedList<>();
    MyLinkedList<Integer> lid = new MyLinkedList<>();
    MyLinkedList<Boolean> lfavorited = new MyLinkedList<>();
    MyLinkedList<Boolean> ltruncated = new MyLinkedList<>();
    MyLinkedList<Integer> lretweet_count = new MyLinkedList<>();
    MyLinkedList<String> lsource = new MyLinkedList<>();
    MyLinkedList<String> lcreated_at = new MyLinkedList<>();
    MyLinkedList<String> lin_reply_to_screen_name = new MyLinkedList<>();
    MyLinkedList<Integer> lin_reply_to_user_id = new MyLinkedList<>();
    MyLinkedList<String> lin_reply_to_user_id_str = new MyLinkedList<>();
    MyLinkedList<String> lin_reply_to_status_id_str = new MyLinkedList<>();
    MyLinkedList<Integer> lin_reply_to_status_id = new MyLinkedList<>();
    MyLinkedList<Integer[]> lgeo = new MyLinkedList<>();
    MyLinkedList<String> lentities = new MyLinkedList<>();
    MyLinkedList<String> luser = new MyLinkedList<>();
    MyLinkedList<String> lplace = new MyLinkedList<>();
    MyArrayList<String> atext = new MyArrayList<>();
    MyArrayList<String> aid_str = new MyArrayList<>();
    MyArrayList<Integer> aid = new MyArrayList<>();
    MyArrayList<Boolean> afavorited = new MyArrayList<>();
    MyArrayList<Boolean> atruncated = new MyArrayList<>();
    MyArrayList<Integer> aretweet_count = new MyArrayList<>();
    MyArrayList<String> asource = new MyArrayList<>();
    MyArrayList<String> acreated_at = new MyArrayList<>();
    MyArrayList<String> ain_reply_to_screen_name = new MyArrayList<>();
    MyArrayList<Integer> ain_reply_to_user_id = new MyArrayList<>();
    MyArrayList<String> ain_reply_to_user_id_str = new MyArrayList<>();
    MyArrayList<String> ain_reply_to_status_id_str = new MyArrayList<>();
    MyArrayList<Integer> ain_reply_to_status_id = new MyArrayList<>();
    MyArrayList<Integer[]> ageo = new MyArrayList<>();
    MyArrayList<String> aentities = new MyArrayList<>();
    MyArrayList<String> auser = new MyArrayList<>();
    MyArrayList<String> aplace = new MyArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        for (int i = 0; i < 3; i++) {
            String fileName = i + "_scrubbed.json";
            MyArrayListParse(fileName);

        }

    }
    public static void MyArrayListParse(String fileName) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("DataSet1/" + fileName));
        int counter = 0;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String text = line.substring(line.indexOf("\"", line.indexOf("\"text\":")+7), line.indexOf("\"", line.indexOf("\"text\":\"")+8));
            //text = text.substring(1);
            System.out.println(text);
            String id_str = line.substring(line.indexOf("\"", line.indexOf("\"id_str\":")+9), line.indexOf("\"", line.indexOf("\"id_str\":\"")+10)).substring(1);
            System.out.println(id_str);
            //int id = Integer.parseInt(id_str.substring(1,id_str.length()-1));
            boolean favorited = Boolean.parseBoolean(line.substring(line.indexOf(":", line.indexOf("\"favorited\"")), line.indexOf(",", line.indexOf("\"favorited\""))));
            System.out.println(favorited);
            boolean truncated;
            int retweet_count;
            String source;
            String created_at;
            String in_reply_to_screen_name;
            int in_reply_to_user_id;
            String in_reply_to_user_id_str;
            String in_reply_to_status_id_str;
            int in_reply_to_status_id;
            int[] geo;
            String entities;
            String user;
            String place;
        }


    }
}
