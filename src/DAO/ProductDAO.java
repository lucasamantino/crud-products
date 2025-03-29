package DAO;

import connection.Conn;
import entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void createProduct (Product product) {
        String sql = "INSERT INTO tb_products (NAME, QUANTITY, PRICE, CATEGORY, DESCRIPTION, CODE) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = Conn.getConn().prepareStatement(sql);
            ps.setString(1,product.getName());
            ps.setString(2,Integer.toString(product.getQuantity()));
            ps.setString(3,Float.toString(product.getPrice()));
            ps.setString(4,product.getCategory());
            ps.setString(5,product.getDescription());
            ps.setString(6,product.getCode());
            ps.execute();
            ps.close();
            System.out.println("⚠\uFE0F Product created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product viewProduct (String code) {
        String sql = "SELECT * FROM tb_products WHERE code = "+code+";";

        try (PreparedStatement ps = Conn.getConn().prepareStatement(sql);
             ResultSet res = ps.executeQuery()) {

            if (res.next()) {
                Product prod = new Product();
                prod.setCode(res.getString("CODE"));
                prod.setCategory(res.getString("CATEGORY"));
                prod.setDescription(res.getString("DESCRIPTION"));
                prod.setPrice(res.getFloat("PRICE"));
                prod.setName(res.getString("NAME"));
                prod.setQuantity(res.getInt("QUANTITY"));
                res.close();
                ps.close();
                return prod;
            } else {
                System.out.println("No product found with code: " + code);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving product with code: " + code, e);
        }
    }

    public void deleteProduct (String code) {
        String sql = "DELETE FROM tb_products WHERE CODE = ?;";

        try (PreparedStatement ps = Conn.getConn().prepareStatement(sql)) {
            ps.setString(1,code);
            ps.execute();
            System.out.println("⚠\uFE0F Product deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Product> ListProducts () {
        String sql = "SELECT * FROM tb_products;";

        try (PreparedStatement ps = Conn.getConn().prepareStatement(sql);
             ResultSet res = ps.executeQuery()) {

            List<Product> products = new ArrayList<>();

            while (res.next()) {
                Product prod = new Product();
                prod.setCode(res.getString("CODE"));
                prod.setCategory(res.getString("CATEGORY"));
                prod.setDescription(res.getString("DESCRIPTION"));
                prod.setPrice(res.getFloat("PRICE"));
                prod.setName(res.getString("NAME"));
                prod.setQuantity(res.getInt("QUANTITY"));
                products.add(prod);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateProduct (String code, int collumn, String value) {
        String colm = "";
        switch (collumn) {
            case 1:
                colm = "NAME";
                break;
            case 2:
                colm = "QUANTITY";
                break;
            case 3:
                colm = "PRICE";
                break;
            case 4:
                colm = "CATEGORY";
                break;
            case 5:
                colm = "DESCRIPTION";
                break;
            case 6:
                colm = "CODE";
                break;
        }

        String sql = "UPDATE tb_products SET ? = ? WHERE code = ?;";

        PreparedStatement ps;
        try {
            ps = Conn.getConn().prepareStatement(sql);
            ps.setString(1, colm);
            ps.setString(2,value);
            ps.setString(3,code);
            ps.execute();
            ps.close();
            System.out.println("⚠\uFE0F The product has been updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
