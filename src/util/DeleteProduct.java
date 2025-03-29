package util;

import DAO.ProductDAO;

import java.util.Scanner;

public class DeleteProduct {
    public void delete () {
        Funcs funcs = new Funcs();
        Scanner scan = new Scanner(System.in);
        funcs.clearScreen();
        System.out.println("================DELETE-PRODUCT================");
        System.out.print("Product code: ");
        String code = scan.nextLine();
        funcs.clearScreen();
        new ProductDAO().deleteProduct(code);

    }
}
