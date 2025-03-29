package menu;
import util.*;

import java.util.Scanner;

public class Menu {

    public void start () {
        Scanner scan = new Scanner(System.in);
        CreateProduct createProduct = new CreateProduct();
        UpdateProduct updateProduct = new UpdateProduct();
        ProductDetails productDetails = new ProductDetails();
        DeleteProduct deleteProduct = new DeleteProduct();
        ListProducts listProducts = new ListProducts();
        Funcs funcs = new Funcs();

        int res;
        do {
            System.out.print("""
                    ╔══════════════════════════════════╗
                    ║      PRODUCT MANAGEMENT SYSTEM   ║
                    ╠══════════════════════════════════╣
                    ║                                  ║
                    ║  1. Create a new product         ║
                    ║  2. Update a product             ║
                    ║  3. View product details         ║
                    ║  4. Delete a product             ║
                    ║  5. List all products            ║
                    ║                                  ║
                    ║  0. Exit                         ║
                    ║                                  ║
                    ╚══════════════════════════════════╝
                    
                    Enter your choice [0-5]:""");
            res = scan.nextInt();
            scan.nextLine();

            if (validadeRes(res)) {
                switch (res) {
                    case 1:
                        createProduct.create();
                        break;
                    case 2:
                        updateProduct.update();
                        break;
                    case 3:
                        productDetails.view();
                        break;
                    case 4:
                        deleteProduct.delete();
                        break;
                    case 5:
                        listProducts.list();
                        break;
                }
            } else {
                funcs.clearScreen();
                System.out.println("⚠\uFE0F Invalid option");
            }

        } while (res != 0);
    }

    private boolean validadeRes (int res) {
        return res >= 0 && res <= 5;
    }

}
