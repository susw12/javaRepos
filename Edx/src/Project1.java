import java.util.Scanner;

public class Project1 {
    public static void main(String [] args){
        greeting();
        difference();
    }

    public static void greeting() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.println("What is your name?");
        String name = input.nextLine();
        System.out.println("Nice to meet you " + name + ", where will you be travelling?");
        String location = input.nextLine();
        System.out.println("Great! " + location + " sounds like a great trip");
        System.out.println("*************");
    }

    public static void difference() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many days are you going to travelling?");
        int days = input.nextInt();

    }
}
