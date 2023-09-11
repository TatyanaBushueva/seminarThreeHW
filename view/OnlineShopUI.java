package seminarThreeHW.view;

import java.util.List;
import java.util.Scanner;

import seminarThreeHW.exceptions.ProductDatabaseException;
import seminarThreeHW.exceptions.ShopManagerException;
import seminarThreeHW.onlineShop.Product;
import seminarThreeHW.onlineShop.ShopManager;

public class OnlineShopUI {
    private final Scanner scanner = new Scanner(System.in);
    private final ShopManager shopManager;

    public OnlineShopUI(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    public void run() {
        System.out.println("Welcome to online shop!");
        availableCommand();
        while (true) {
            System.out.print("enter command: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> listProduct();
                case "2" -> buyProduct();
                case "0" -> {
                    return;
                }
                default -> availableCommand();
            }
        }
    }

    private void buyProduct() {
        int productId = getInt("product ID");
        int quantity = getInt("quantity");
        try {
            double sum = shopManager.purchaseProduct(productId, quantity);
            System.out.println("Purchase amount: $" + sum);
        } catch (ProductDatabaseException | ShopManagerException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getInt(String name) {
        System.out.print("Enter " + name + ": ");
        String input = scanner.nextLine();
        while (!input.matches("[\\d]{1,9}")) {
            System.out.print(name + " must be numeric and positive, enter " + name + ": ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    private void availableCommand() {
        System.out.println("""
                1 - get list available products
                2 - choosing a product to buy
                0 - exit""");
    }

    private void listProduct() {
        List<Product> products = shopManager.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println("ID: " + (i + 1) + ",  " + products.get(i));
        }
    }
}