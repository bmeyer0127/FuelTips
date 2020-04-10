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

  public static void main(String [] args) throws IOException {
    File tipHistory = new File("C:\\Users\\Colleen\\Desktop\\TipHistory.txt");

    FileOutputStream fos = new FileOutputStream(tipHistory, true);
    PrintWriter pw = new PrintWriter(fos);
    pw.println("============================");

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

    System.out.println();
    System.out.println("Worker info: ");

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

    System.out.println();
    System.out.println("==============");
    System.out.println();

    System.out.printf("Date: %s\n", date);
    pw.printf("Date: %s\n",date);

    System.out.println("Total tips: $" + (creditTips + cashTips));
    pw.printf("Total tips: $%.2f\n", creditTips + cashTips);

    System.out.printf("Total hours worked: %.2f\n\n", totalHours);
    pw.printf("Total hours worked: %.2f\n\n", totalHours);

    for (int i = 0; i < numPeople; i++) {

      double claim = totalClaimed * hours[i];
      double total = totalTips * hours[i];

      System.out.printf("%s:\nClaim: %.2f\nTotal: %.2f\n\n", names[i], claim, total);
      pw.println(names[i]);
      pw.printf("Claim: %.2f", claim);
      pw.println();
      pw.printf("Total: %.2f", total);
      pw.println();
      pw.println();
      //pw.printf("%s:\nClaim: %.2f\nTotal: %.2f\n\n", names[i], claim, total);

    }

    pw.close();
    System.out.println("All done :) DO NOT PRESS ANYTHING UNLESS YOU WANT TO DO THIS OVER\n");
  }
}
