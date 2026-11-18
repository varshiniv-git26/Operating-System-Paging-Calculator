import java.util.Scanner;

public class PagingCalculator {

    static Scanner sc = new Scanner(System.in);

    static void displayHeader() {
        System.out.println("\n==============================================");
        System.out.println("          OPERATING SYSTEM PROJECT");
        System.out.println("              PAGING CALCULATOR");
        System.out.println("==============================================");
        System.out.println("       Logical Address Translation System");
        System.out.println("==============================================");
    }

    static void calculatePaging() {

        int pageSize;

        while (true) {
            System.out.print("\nEnter Page Size (in bytes): ");

            if (sc.hasNextInt()) {
                pageSize = sc.nextInt();

                if (pageSize > 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.println("Invalid input! Enter a positive number.");
        }

        System.out.print("Enter Number of Logical Addresses: ");
        int count;

        while (!sc.hasNextInt() || (count = sc.nextInt()) <= 0) {
            if (sc.hasNextInt()) {
                System.out.println("Enter a number greater than zero.");
            } else {
                System.out.println("Invalid input! Enter a valid number.");
                sc.next();
            }
            System.out.print("Enter Number of Logical Addresses: ");
        }

        int[] addresses = new int[count];

        System.out.println("\nEnter Logical Addresses:");

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Address " + (i + 1) + ": ");

                if (sc.hasNextInt()) {
                    int address = sc.nextInt();

                    if (address >= 0) {
                        addresses[i] = address;
                        break;
                    }
                } else {
                    sc.next();
                }

                System.out.println("Invalid address! Enter a non-negative integer.");
            }
        }

        System.out.println("\n");
        System.out.println("==============================================================");
        System.out.println("                  PAGING CALCULATION RESULTS");
        System.out.println("==============================================================");

        System.out.printf("%-20s %-15s %-15s%n",
                "Logical Address", "Page Number", "Offset");

        System.out.println("--------------------------------------------------------------");

        for (int address : addresses) {

            int pageNumber = address / pageSize;
            int offset = address % pageSize;

            System.out.printf("%-20d %-15d %-15d%n",
                    address, pageNumber, offset);
        }

        System.out.println("==============================================================");
        System.out.println("Total Addresses Processed: " + count);
        System.out.println("Page Size: " + pageSize + " Bytes");
        System.out.println("Calculation Status: SUCCESS");
        System.out.println("==============================================================");
    }

    public static void main(String[] args) {

        int choice=0;

        do {
            displayHeader();

            System.out.println("\n1. Calculate Paging");
            System.out.println("2. Exit");

            System.out.print("\nEnter Your Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Please enter 1 or 2.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    calculatePaging();
                    break;

                case 2:
                    System.out.println("\nThank you for using Paging Calculator!");
                    System.out.println("Program Terminated Successfully.");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 or 2.");
            }

        } while (choice != 2);

        sc.close();
    }
}