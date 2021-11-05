package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        BookDao bdao = DaoFactory.getBookDao();
        UsersDao udao = DaoFactory.getUsersDao();
        CartDao cdao = DaoFactory.getCartDao();
        Scanner scanner = new Scanner(System.in);

        boolean mainM = true;
        while (mainM) {
            System.out.println("*-------------*");
            System.out.println("Welcome to our Boot Store!");
            System.out.println("Select from the option");
            System.out.println("------------------------");
            System.out.println("Press 1: Register");
            System.out.println("Press 1: Login");
            System.out.println("Press 2: Exit");
            System.out.println("------------------------");
            int mainInput = scanner.nextInt();

            switch (mainInput) {
                case 1:{
                    System.out.println("Register");
                    System.out.println("Enter your username: ");
                    String username = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    break;
                }
                case 2:{
                    System.out.println("Log in");
                    System.out.println("Enter your username: ");
                    String username = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();

                    // after login
                    // while logged in
                    System.out.println("Book Store Menu");
                    System.out.println("Select from the option");
                    System.out.println("Press 1: View Book Categories");
                    System.out.println("Press 2: View your cart");
                    System.out.println("Press 3: Log Out");
                    int storeInput = scanner.nextInt();

                    switch (storeInput){
                        case 1:{
                            System.out.println("List of categories:");

                            break;
                        }
                        case 2:{
                            System.out.println("Items in your cart:");
                            // display books in cart
                            System.out.println("Press 1: Checkout");
                            System.out.println("Press 2: Remove book");
                            System.out.println("Press 3: Go back");
                            break;
                        }
                        case 3:{
                            System.out.println("Logging out...");
                            System.out.println("See you soon!");
                            // = false;

                            break;
                        }
                        default:
                            System.out.println("Wrong Input...");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Exiting the Book Store");
                    System.out.println("Bye Bye!");
                    mainM = false;
                    break;
                }
                default:
                    System.out.println("Wrong Input...");
            }
        }
    }
}
