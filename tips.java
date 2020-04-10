import java.util.Scanner;

public class tips {
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in); 

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

    double totalHours = 0;
    for (int j = 0; j < numPeople; j++) {
      totalHours += hours[j];
    }

    double totalClaimed = creditTips / totalHours;
    double totalTips = (creditTips + cashTips) / totalHours;
    String[] indClaim = new String[numPeople];
    String[] indTotal = new String[numPeople];

    for (int k = 0; k < numPeople; k++) {
      String formattedClaim = String.format("%.2f", totalClaimed * hours[k]);
      indClaim[k] = formattedClaim;
      String formattedTotal = String.format("%.2f", totalTips * hours[k]);
      indTotal[k] = formattedTotal;
    }

    System.out.println("");
    System.out.println("==============");
    System.out.println("");
    System.out.printf("Date: %s\n", date);
    System.out.println("Total tips: $" + (creditTips + cashTips));
    System.out.printf("Total hours worked: %.2f\n", totalHours);
    for (int l = 0; l < numPeople; l++) {
      System.out.printf(names[l] + ":\n" + "Claim: " + indClaim[l] + "\n" + "Total: " + indTotal[l]);
      System.out.println("");
      System.out.println("");
    }
  }
}
