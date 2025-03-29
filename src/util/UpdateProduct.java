package util;

import DAO.ProductDAO;

import java.util.Scanner;

public class UpdateProduct {
    public void update () {
        Scanner scan = new Scanner(System.in);
        Funcs funcs = new Funcs();
        funcs.clearScreen();

        int opt;
        String code;
        String val;

        do {
            System.out.print("""
                    ╔══════════════════════════════════╗
                    ║          UPDATE PRODUCT          ║
                    ╠══════════════════════════════════╣
                    ║                                  ║
                    ║  1. Update product name          ║
                    ║  2. Update product quantity      ║
                    ║  3. Update product price         ║
                    ║  4. Update stock category        ║
                    ║  5. Update product description   ║
                    ║  6. Update product code          ║
                    ║                                  ║
                    ╚══════════════════════════════════╝
                        Enter your choice [1-5]:""");
            opt = scan.nextInt();
            scan.nextLine();
            if (opt <1 || opt > 6) {
                funcs.clearScreen();
                System.out.println("⚠\uFE0F Non-existent option!");
            }
        }while (opt <1 || opt > 6);

        System.out.print("New value: ");
        val = scan.nextLine();
        System.out.print("Product code: ");
        code = scan.nextLine();

        new ProductDAO().updateProduct(code,opt,val);
        funcs.clearScreen();
    }

}
