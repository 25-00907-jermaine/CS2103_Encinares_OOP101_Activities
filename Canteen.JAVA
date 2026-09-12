import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

   
        double price1 = 50.00;
        double price2 = 30.00;
        double price3 = 80.00;
        double price4 = 40.00;
        double price5 = 60.00;
     
        int totalQuantity = 0;
        double totalAmount = 0.00;

        
        String student = "N";         
        String orderAgain = "Y";

     
        
        System.out.println("=================================");
        System.out.println("       CANTEEN MENU");
        System.out.println("=================================");
        System.out.println("1. Burger     - $50.00");
        System.out.println("2. Fries      - $30.00");
        System.out.println("3. Pizza      - $80.00");
        System.out.println("4. Hotdog     - $40.00");
        System.out.println("5. Sandwich   - $60.00");
        System.out.println("=================================");

        
        while (orderAgain.equalsIgnoreCase("Y")) {

            System.out.print("\nEnter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            student = scanner.next();

            
            if (itemNumber < 1 || itemNumber > 5 ||
                quantity < 1 || quantity > 10) {

                System.out.println("Invalid order.");
                System.out.println("Item number must be 1-5 and quantity must be 1-10.");
                System.out.println("Please try another order.");

                 
                continue;
            }

            
            double price = 0.00;

            if (itemNumber == 1) {
                price = price1;
            } 
            else if (itemNumber == 2) {
                price = price2;
            } 
            else if (itemNumber == 3) {
                price = price3;
            } 
            else if (itemNumber == 4) {
                price = price4;
            } 
            else if (itemNumber == 5) {
                price = price5;
            }

            
            double orderAmount = price * quantity;

            
            totalQuantity += quantity;
            totalAmount += orderAmount;

            System.out.printf("Order amount: $%.2f%n", orderAmount);

            
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next();
        }

       
        double discountRate = 0.00;

        if (student.equalsIgnoreCase("Y") && totalAmount >= 500) {
            
            discountRate = 0.15;
        }
        else if (student.equalsIgnoreCase("Y")) {
          
            discountRate = 0.10;
        }
        else if (totalAmount >= 500) {
            
            discountRate = 0.05;
        }
        else {
            
            discountRate = 0.00;
        }

        
        double totalDeduction = totalAmount * discountRate;
        double finalAmount = totalAmount - totalDeduction;

        
        System.out.println("\n=================================");
        System.out.println("          FINAL RECEIPT");
        System.out.println("=================================");

        System.out.println("Total quantity of items purchased: "
                + totalQuantity);

        System.out.printf("Total amount before deductions: $%.2f%n",
                totalAmount);

        System.out.printf("Total deduction: $%.2f%n",
                totalDeduction);

        System.out.printf("Final amount to pay: $%.2f%n",
                finalAmount);

        System.out.println("=================================");

        scanner.close();
    }
}
