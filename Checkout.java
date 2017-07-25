package program;

import java.util.Scanner;
import model.bo.Cart;
import model.bo.Product;

public class Checkout {

    public static void main(String[] args) {

        Cart cart = null;

        @SuppressWarnings("resource")
        Scanner ReadInt = new Scanner(System.in);
        int option;

        do {
            System.out.println("Main Menu");
            System.out.println("1 - Add a product at cart");
            System.out.println("2 - Total");
            System.out.println("3 - Exit");

            option = ReadInt.nextInt();

            switch (option) {
                case 1:
                    clearWindow();

                    if (cart == null) {
                        cart = new Cart();
                    }

                    int optionProd;
                    do {
                        System.out.println("Menu Products");
                        System.out.println("1 - Product A: $0,50");
                        System.out.println("2 - Product B: $0,30");
                        System.out.println("3 - Product C: $0,20");
                        System.out.println("4 - Product D: $0,15");
                        System.out.println("5 - Return to main Menu");
                        System.out.println("");

                        optionProd = ReadInt.nextInt();

                        if (optionProd == 1) {
                            System.out.println("Quantity of Product A:");
                            int qtd = ReadInt.nextInt();
                            cart.addProductToCart(new Product("A", 0.50f, qtd));
                            clearWindow();
                            continue;
                        } else if (optionProd == 2) {
                            System.out.println("Quantity of Product B:");
                            int qtd = ReadInt.nextInt();
                            cart.addProductToCart(new Product("B", 0.30f, qtd));
                            clearWindow();
                            continue;
                        } else if (optionProd == 3) {
                            System.out.println("Quantity of Product C:");
                            int qtd = ReadInt.nextInt();
                            cart.addProductToCart(new Product("C", 0.20f, qtd));
                            clearWindow();
                            continue;
                        } else if (optionProd == 4) {
                            System.out.println("Quantity of Product D:");
                            int qtd = ReadInt.nextInt();
                            cart.addProductToCart(new Product("D", 0.15f, qtd));
                            clearWindow();
                            continue;
                        } else if (optionProd == 5) {
                            clearWindow();
                            break;
                        } else {
                            System.out.println("Choose a product from 1 to 4 or 5 to return to the Main Menu");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            clearWindow();

                        }
                    } while (optionProd >= 1 || optionProd <= 4);

                    break;

                case 2:
                    clearWindow();
                    if (cart != null && cart.listProductToCart().size() > 0) {
                        total(cart);
                        System.out.println("Press Enter to continue");
                        ReadInt.nextLine();
                        ReadInt.nextLine();
                        clearWindow();
                        break;
                    } else {
                        System.out.println("Empty cart");
                        System.out.println("Press Enter to continue");
                        ReadInt.nextLine();
                        ReadInt.nextLine();
                        clearWindow();
                        break;
                    }

                default:
                    break;
            }

        } while (option < 3);

        clearWindow();
        System.out.println("Program will be closed");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        clearWindow();
    }

    private static void clearWindow() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    private static void total(Cart cart) {
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Total Discount: " + cart.getTotalWithDiscount());
    }
}
