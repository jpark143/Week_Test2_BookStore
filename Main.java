package com.company;

import java.sql.SQLException;
import java.util.List;
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
            System.out.println("Press 2: Login");
            System.out.println("Press 3: Exit");
            System.out.println("------------------------");
            Scanner mainInput = new Scanner(System.in);

            switch (mainInput.next()) {
                case "1":{ //REGISTER USER
                    System.out.println("Register");
                    System.out.println("Enter your username: ");
                    String username = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    if(udao.checkUser(username)) {
                        System.out.println("\nThis username is taken, please select another one.\n");
                    }
                    else {
                        udao.createUser(username,password);}
                    break;

                }
                case "2":{//LOGIN USER
                    System.out.println("Log in");
                    System.out.println("Enter your username: ");
                    String username = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    storeMenu(username,password);
                    break;
                }//Store Login in Menu end
                case "3":{
                    System.out.println("Exiting the Book Store");
                    System.out.println("Bye Bye!");
                    mainM = false;
                    break;
                }
                default:
                    System.out.println("Wrong Input...");
            }//While END
        }
    }

    private static void storeMenu(String username, String password) throws SQLException {
        UsersDao udao = DaoFactory.getUsersDao();
        BookDao bdao = DaoFactory.getBookDao();
        CartDao cdao = DaoFactory.getCartDao();
        //Initialize if find.
        Cart cart = new Cart();

        if(udao.login(username, password)) {
        	Users user = udao.getUser(username);
            boolean storeFlag = true;
            //If user exists login
            while(storeFlag) {
            	//Load all content from cart table
            	cart.initialize(user);
                System.out.println("Book Store Menu");
                System.out.println("Select from the option");
                System.out.println("Press 1: View All Books");
                System.out.println("Press 2: View by Category");
                System.out.println("Press 3: Search by ID");
                System.out.println("Press 4: View Cart");
                System.out.println("Press 5: Remove From Cart");
                System.out.println("Press 6: Clear Cart");
                System.out.println("Press 7: Checkout");
                System.out.println("Press 8: Log Out");
                Scanner storeInput = new Scanner(System.in);

                switch (storeInput.next()){
                    case "1":{
                        System.out.println("List Books:");
                        List<Book> books = bdao.getAllBooks();
                        for(Book book:books) {
                            book.printShort();

                        }
                        break;
                    }
                    case "2":{//Category
                        System.out.println("List of Categories:\n");
                        List<Category> categories = bdao.getAllCategory();
                        for (Category category: categories){
                            System.out.println("Category ID: " + category.getId() + " : " + category.getCategory());
                        }
                        // display Categories
                        System.out.println("\nEnter Category ID you want to see");
                        Scanner scanner = new Scanner(System.in);
                        int catId = 13;
                        do {
                        System.out.println("Requires a number between 1 and 12. Your input:");
                        catId = enterInt();
                        } while(catId > 12);
                        bdao.getByCategory(catId);

                        break;
                    }

                    case "3":{//Search by ID
                        System.out.println("\nEnter number of ID you wish to search\n");
                        int id = enterInt();
                        Book book = bdao.getById(id);
                        book.printAllData();
                        System.out.println("Would you like to buy this book?\n1. Yes\n2. No");
                        if(enterInt()==1) {
                            cart.addBook(book);
                            cdao.addBook(book, user);
                        }
                        break;
                    }                    
                    case "4":{//Check CART
                        listCart(cart);
                        break;
                        
                    }
                    case "5":{//RemoveFrom CART
                        System.out.println("\nPlease enter the id of the book you wish to remove:\n");
                        int rem = enterInt();
                        cdao.removeBook(rem, user, cart);
                        break;
                    }
                    case "6":{//Clear all CART
                    	cdao.clearBooks(user, cart);
                        break;
                    }
                    case "7":{//CHECKOUT
                        buyCart(user, cart);
                        // display books in cart

                        break;
                    }
                    case "8":{
                        System.out.println("Logging out...");
                        System.out.println("See you soon!");
                        storeFlag = false;
                        break;
                    }
                    default:
                        System.out.println("Wrong input, please select an option from the list");
                }
            }//While END

        }//IF END
    }

    private static void buyCart(Users user,Cart cart) throws SQLException {
        System.out.println("\nPrinting books in your cart\n");
        CartDao cdao = DaoFactory.getCartDao();
        List<Book> list = cart.getList();
        double total =0;
        if(list.isEmpty()) {
            System.out.println("\nCart is currently empty\n");
            return;
        }
        for(Book book:list) {
            book.printShort();
            System.out.println("Price: "+book.getPrice()+"\n");
            total +=book.getPrice();
        }
        System.out.println("\nYour total is "+total+"$\n");
        System.out.println("Options: \n1.Pay \n2. Return to Menu");
        int answer = enterInt();
        if(answer ==1) {
            System.out.println("Transaction completed");
            cdao.clearBooks(user, cart);
        }

    }

    public static void listCart(Cart cart) {

        System.out.println("\nPrinting books in your cart\n");
        List<Book> list = cart.getList();
        if(list.isEmpty()) {
            System.out.println("\nCart is currently empty\n");
            return;
        }
        for(Book book:list) {
            book.printAllData();
        }
    }
    //Make sure its an int. Wont take no for an answer
    private static int enterInt() {

        boolean flag = true;
        int id=0;
        while(flag||id<1) {
            try {
                if (id<1) {
                    id=0;
                    System.out.println("Please enter a number greater than zero: ");
                }
                Scanner input = new Scanner(System.in);
                id = Integer.parseInt(input.nextLine());
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Invalid entry, please enter a number greater than zero: ");
                flag=true;
            }
        }

        return id;
    }//Enter int end
}
