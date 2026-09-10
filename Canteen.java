import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] prices = {80.00, 120.00, 100.00, 70.00, 90.00};

        int totalQty = 0;
        double totalBefore = 0, totalDiscount = 0, totalFinal = 0;

        System.out.println("=====  MENU  =====");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d. %-10s - $%.2f%n", i + 1, names[i], prices[i]);
        }

        String again = "Y";
        while (again.equalsIgnoreCase("Y")) {
            System.out.print("\nEnter item number: ");
            int item = scanner.nextInt();
            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();

            if (item >= 1 && item <= names.length && qty >= 1 && qty <= 10) {
                System.out.print("Are you a student? (Y/N): ");
                boolean student = scanner.next().equalsIgnoreCase("Y");

                double subtotal = prices[item - 1] * qty;
                double rate = 0;
                if (student && subtotal >= 500) rate = 0.15;
                else if (student) rate = 0.10;
                else if (subtotal >= 500) rate = 0.05;

                double discount = subtotal * rate;
                double total = subtotal - discount;

                System.out.printf("%nSubtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", total);

                totalQty += qty;
                totalBefore += subtotal;
                totalDiscount += discount;
                totalFinal += total;
            } else {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = scanner.next();
        }

        System.out.println("\n=====  ORDER SUMMARY  =====");
        System.out.println("Total items: " + totalQty);
        System.out.printf("Total before discount: $%.2f%n", totalBefore);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", totalFinal);
        System.out.println("Thank you for ordering!");
    }
}