import java.io.*;
/**
 * tips.java
 *
 * This program is for automatically calculating tips for those who
 *  worked for a specific day.
 *
 * @author Brett Meyer
 */

import java.util.Scanner;

public class tips {
  public static void main(String [] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("~~TippyBoy 3000 Booting Up~~\n");

    System.out.print("Enter the date: ");
    String date = scanner.nextLine();

    System.out.print("How many people worked " + date + "?: ");
    int numPeople = scanner.nextInt();

    String[] names = new String[numPeople];
    double[] hours = new double[numPeople];

    System.out.print("Cash Tips: ");
    double cashTips = scanner.nextDouble();

    System.out.print("Credit Card Tips: ");
    double creditTips = scanner.nextDouble();

    System.out.println("");
    System.out.println("Worker info: ");

    boolean done = true;
    for (int i = 0; i < numPeople; i++) {

      scanner.nextLine();
      System.out.print("Name " + (i+1) +": ");
      names[i] = scanner.nextLine();

      System.out.print("Hours: ");
      hours[i] = scanner.nextDouble();
    }

    //Count number of total hours
    double totalHours = 0;
    for (int i = 0; i < numPeople; i++) {

      totalHours += hours[i];

    }

    double totalClaimed = creditTips / totalHours;
    double totalTips = (creditTips + cashTips) / totalHours;

    System.out.println("");
    System.out.println("==============");
    System.out.println("");

    System.out.printf("Date: %s\n", date);
    System.out.println("Total tips: $" + (creditTips + cashTips));
    System.out.printf("Total hours worked: %.2f\n\n", totalHours);

    for (int i = 0; i < numPeople; i++) {

      double claim = totalClaimed * hours[i];
      double total = totalTips * hours[i];

      System.out.printf("%s:\nClaim: %.2f\nTotal: %.2f\n\n", names[i], claim, total);
    }

    System.out.println("All done :) DO NOT PRESS ANYTHING UNLESS YOU WANT TO DO THIS OVER\n");
  }
}
