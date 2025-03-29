package util;

import DAO.ProductDAO;
import entity.Product;

import java.util.Scanner;

public class CreateProduct {
    public void create () {
        Scanner scan = new Scanner(System.in);
        Product product = new Product();
        Funcs funcs = new Funcs();
        funcs.clearScreen();

        System.out.println("├── \uD83D\uDCC2 Product");
        System.out.print("│    ├── \uD83D\uDCC4 Name:");
        product.setName(scan.nextLine());
        System.out.print("│    ├── \uD83D\uDCC4 Quantity in stock:");
        product.setQuantity(scan.nextInt());
        scan.nextLine();
        System.out.print("│    ├── \uD83D\uDCC4 Price:");
        product.setPrice(scan.nextFloat());
        scan.nextLine();
        System.out.print("│    ├── \uD83D\uDCC4 Category:");
        product.setCategory(scan.nextLine());
        System.out.print("│    ├── \uD83D\uDCC4 Description:");
        product.setDescription(scan.nextLine());
        System.out.print("│    ├── \uD83D\uDCC4 Code:");
        product.setCode(scan.nextLine());
        funcs.clearScreen();

        String name = funcs.setStrSize(product.getName(),23);
        String price = funcs.setStrSize(Float.toString(product.getPrice()),10);
        String quantity = funcs.setStrSize(Integer.toString(product.getQuantity()),7);
        String category = funcs.setStrSize(product.getCategory(),14);

        System.out.print("""
                                ╔══════════════════════════════════╗
                                ║           NEW PRODUCT            ║
                                ╠══════════════════════════════════╣
                """);
        System.out.print("                ║ Name: "+name+"    ║\n");
        System.out.print("                ║ Price: "+price+"                ║\n");
        System.out.print("                ║ Quantity: "+quantity+"                ║\n");
        System.out.print("                ║ Category: "+category+"         ║\n");
        System.out.print("""
                        ╠══════════════════════════════════╣
                        ║ [S]ave  [C]ancel                 ║
                        ╚══════════════════════════════════╝  
        """);
        String opt = scan.nextLine();
        if (opt.equals("s") || opt.equals("S")) {
            funcs.clearScreen();
            new ProductDAO().createProduct(product);
        } else {
            funcs.clearScreen();
            System.out.println("⚠\uFE0F Canceled");
        }
    }

}
