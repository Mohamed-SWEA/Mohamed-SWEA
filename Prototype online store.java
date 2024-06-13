import java.util.concurrent.TimeUnit;
import java.util.Scanner;

class login {
    String name;
    int num;
    String email;
    String password;
    String re_password;
}

class discount_clothes {
    String sex[] = new String[] {"male", "male", "female", "male", "female", "male", "male", "female", "male", "male", "male", "female"};
    String name[] = new String [] {"pants", "shirt", "Baloot", "shoes", "shose", "T-shirt", "watch", "watch", "watch", "pants", "T-shirt", "hoodi"};
    String quality[] = new String [] {"hige", "hige", "very hige", "excellent", "hige", "very hige", "hige", "hige", "hige", "very hige", "excellent", "hige"};
    double price[] = new double [] {5.99, 3.99, 9.45, 7.89, 8.60, 6.99, 3.50, 4.99, 5.20, 8.25, 3.55, 4.0};
    String mark[] = new String [] {"PRADA", "GUCCI", "Queen", "Nike", "Adidas", "LACOSTE", "Rolex", "Rado", "Luxury", "Boss", "Mask", "Dior"};
    String color[] = new String [] {"blue", "white", "black", "black", "white", "white", "black", "gold", "silver", "black", "gray", "beige"};
    String discount[] = new String [] {"30%", "45%", "20%", "50%", "60%", "55%", "72%", "40%", "35%", "80%", "65%", "48%"};
}

public class Main {
    static String time = "";
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\t\tSign Up Page\n");
        login loginData = new login();

        System.out.println("Enter your name: ");
        loginData.name = in.nextLine();

        System.out.println("\nEnter your phone number: ");
        loginData.num = in.nextInt();

        checkPassword();
        loading();
        System.out.print("\nSign up successfully!");
        TimeUnit.SECONDS.sleep(2);
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print("Welcome to our app Mr." + loginData.name + "!\n\n");
        TimeUnit.SECONDS.sleep(3);

        int o = 0;
        do {
            System.out.println("choose\n1-Al-emtaiz application\n2-Applying for scholarship\n3-Offer discounts to students\n4- Exit");
            int ch = in.nextInt();
            switch (ch) {
                case 3:
                    System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                    String country = getCountry();
                    System.out.println("\nCountry: " + country);

                    String location = getLocation();
                    System.out.println("Your location has been selected");

                    System.out.println("Enter your size:\nPants:  ");
                    int pantsSize = in.nextInt();
                    System.out.println("Shirt & T-shirt\n choose one ( M , L , XL , XXL , XXXL )");
                    String shirtSize = in.next();
                    System.out.println("Shoes:  ");
                    int shoesSize = in.nextInt();
                    System.out.print("Baloot:\n(length):   ");
                    int lengthBaloot = in.nextInt();
                    System.out.print("(width):   ");
                    int widthBaloot = in.nextInt();

                    System.out.println("\nOffers for this week:");
                    System.out.println();

                    double totalCost = 0.0;
                    discount_clothes dis = new discount_clothes();
                    for (int i = 0; i < 12; i++) {
                        System.out.println("Sex: " + dis.sex[i]);
                        System.out.println("Name: " + dis.name[i]);
                        System.out.println("Color: " + dis.color[i]);
                        System.out.println("Quantity: " + dis.quality[i]);
                        System.out.println("Mark: " + dis.mark[i]);
                        System.out.println("Discount: " + dis.discount[i]);
                        System.out.println("Price: " + dis.price[i] + "$");
                        System.out.println("------------------------------------");

                        totalCost += askUser(dis.price[i], dis);
                    }

                    System.out.println("Total cost of items in your cart: $" + totalCost);

                    System.out.println("Enter buy to send your order \\ cancel");

                    String buy = "";
                    while (!buy.equals("buy") && !buy.equals("cancel")) {
                        buy = in.next();
                        if (!buy.equals("buy") && !buy.equals("cancel"))
                            System.out.println("Invalid input, please enter buy or cancel");
                    }

                    if (buy.equals("buy")) {
                        loading();
                        System.out.println(time);
                    } else if (buy.equals("cancel")) {
                        System.out.println("Order canceled...");
                    }
            }
        } while (o == 0);
    }

    static double askUser(double price, discount_clothes dis) {
        char choice;

        do {
            System.out.println("Do you want to add this offer to your cart? (Y/N)");
            choice = in.next().charAt(0);
            choice = Character.toUpperCase(choice);
        } while (choice != 'Y' && choice != 'N');

        if (choice == 'Y') {
            System.out.println("Offer added to cart successfully.");
            return price;
        } else {
            System.out.println("Offer not added to cart.");
            return 0.0;
        }
    }

    static void checkPassword() throws InterruptedException {
        login loginData = new login();
        System.out.println("\nCreate password: ");
        loginData.password = in.next();
        System.out.println("\nRe-Password: ");
        loginData.re_password = in.next();

        while (!loginData.password.equals(loginData.re_password)) {
            System.out.println("Wrong password, try again.");
            System.out.println("\nRe-Password: ");
            loginData.re_password = in.next();
        }
    }

    static void printOffer(discount_clothes offer) {
        System.out.println("Sex: " + offer.sex);
        System.out.println("Name: " + offer.name);
        System.out.println("Color: " + offer.color);
        System.out.println("Quantity: " + offer.quality);
        System.out.println("Mark: " + offer.mark);
        System.out.println("Discount: " + offer.discount);
        System.out.println("Price: " + offer.price);
        System.out.println("------------------------------------");
    }

    static String getLocation() {
        System.out.println("Locate?");
        System.out.println("Skip");
        System.out.println("Enter locate/skip");
        return in.next();
    }

    static String getCountry() {
        do {
            System.out.println("choose Your Country: \n1- Saudi Arabia\n2- Egypt\n3- Jordan\n4- Yemen");
            int choose = in.nextInt();

            switch (choose) {
                case 1:
                    time = "Total time for your offer (1-2)hours to receive it";
                    return "Saudi Arabia";
                case 2:
                    time = "Total time for your offer (3-6)hours to receive it";
                    return "Egypt";
                case 3:
                    time = "Total time for your offer (2-5)hours to receive it";
                    return "Jordan";
                case 4:
                    time = "Total time for your offer (0.5-1)month to receive it";
                    return "Yemen";
                default:
                    System.out.println("Just (1-4) ");
            }
        } while (true);
    }

    public static void loading() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0; i <= 3; i++) {
            Thread.sleep(280);
            System.out.print(".");
        }

        Thread.sleep(130);
        System.out.print("\b\b\b   \b\b\b");

        for (int i = 0; i < 4; i++) {
            Thread.sleep(280);
            System.out.print(".");
        }

        Thread.sleep(130);
        System.out.print("\b\b\b   \b\b\b");

        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print("                ");
    }
}