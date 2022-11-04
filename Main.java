package PRODUCT_MANAGEMENT_PROJECT;

import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagementMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductManagementMenu productManagementMenu = new ProductManagementMenu();
        productManagementMenu.handleMenu();
    }
}
