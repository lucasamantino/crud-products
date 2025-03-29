package util;

import DAO.ProductDAO;
import entity.Product;

import java.util.Scanner;

public class ProductDetails {
    public void view () {
        Funcs funcs = new Funcs();
        funcs.clearScreen();
        Scanner scan = new Scanner(System.in);
        System.out.println("Product code: ");
        String code = scan.nextLine();

        Product product = new ProductDAO().viewProduct(code);

        if (product != null) {
            String name = funcs.setStrSize(product.getName(), 23);
            String price = funcs.setStrSize(Float.toString(product.getPrice()), 10);
            String quantity = funcs.setStrSize(Integer.toString(product.getQuantity()), 7);
            String category = funcs.setStrSize(product.getCategory(), 14);

            System.out.print("""
                                    ╔══════════════════════════════════╗
                                    ║              PRODUCT             ║
                                    ╠══════════════════════════════════╣
                    """);
            System.out.print("                ║ Name: " + name + "    ║\n");
            System.out.print("                ║ Price: " + price + "                ║\n");
            System.out.print("                ║ Quantity: " + quantity + "                ║\n");
            System.out.print("                ║ Category: " + category + "         ║\n");
            System.out.print("""
                                    ║                                  ║
                                    ╚══════════════════════════════════╝  
                    """);

            System.out.println("Product description: "+product.getDescription());
            System.out.println("ENTER to finish");
            scan.nextLine();
            funcs.clearScreen();
        }

    }
}
