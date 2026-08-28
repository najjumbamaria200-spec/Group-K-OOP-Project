public class GlowSalon {

    // Method 1: Calculate the discounted subtotal
    public static double calculateSubtotal(int index, double price, int quantity) {

        double subtotal = price * quantity;

        // Haircut - 5% discount when buying 3 or more
        if (index == 0 && quantity >= 3) {
            subtotal = subtotal * 0.95;
        }

        // Manicure - UGX 3,000 discount when buying 2 or more
        if (index == 2 && quantity >= 2) {
            subtotal = subtotal - 3000;
        }

        // Braiding - 10% discount when buying 2 or more
        if (index == 3 && quantity >= 2) {
            subtotal = subtotal * 0.90;
        }

        return subtotal;
    }

    // method 2: Get the discount Message
    public static String getDiscountMessage(int index, int quantity) {

        if (index == 0 && quantity >= 3) {
            return "5% discount applied";
        }

        if (index == 2 && quantity >= 2) {
            return "UGX 3,000 discount applied";
        }

        if (index == 3 && quantity >= 2) {
            return "10% discount applied";
        }

        return "no discount";
    }

    // Method 3: Print the receipt
    public static void printReceipt(String[] items, double[] prices, int[] quantities) {

        double grandTotal = 0;

        System.out.println("===== GLOW SALON =====");
        System.out.println();
        System.out.println("PRICE LIST");

        // Display price list using a loop
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%-12s UGX %.2f%n", items[i], prices[i]);
        }

        System.out.println();
        System.out.println("===== RECEIPT =====");

        // Calculate and display each item
        for (int i = 0; i < items.length; i++) {

            double subtotal = calculateSubtotal(
                    i,
                    prices[i],
                    quantities[i]);

            grandTotal = grandTotal + subtotal;

            String discountMessage = getDiscountMessage(i, quantities[i]);

            System.out.printf(
                    "%-12s x%d = UGX %.2f (%s)%n",
                    items[i],
                    quantities[i],
                    subtotal,
                    discountMessage);
        }
        System.out.println("----------------------------");
        System.out.printf("TOTAL = UGX %.2f%n", grandTotal);
    }

    // Main method
    public static void main(String[] args) {

        String[] items = {
                "Haircut",
                "Shave",
                "Manicure",
                "Braiding"
        };

        double[] prices = {
                8000,
                5000,
                15000,
                30000
        };

        int[] quantities = {
                2,
                2,
                1,
                2
        };

        printReceipt(items, prices, quantities);
    }
}