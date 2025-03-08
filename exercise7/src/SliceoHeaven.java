import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SliceoHeaven {
    String storeName;
    String storeAddress;
    String storeEmail;
    String storePhone;
    String storeMenu;
    String pizzaIngredients;
    Double pizzaPrice;
    String sides;
    String drinks;
    private String orderID;
    private Double orderTotal;
    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final Double DEF_ORDER_TOTAL = 15.00;
    private static final long BLACKLISTED_NUMBER = 12345678901234L;

    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceoHeaven(String orderID, String pizzaIngredients, Double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        int ingChoice1, ingChoice2, ingChoice3;
        do {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.print("Enter any three choices (1, 2, 3,…) separated by spaces:");
            String[] choices = scanner.nextLine().split(" ");
            if (choices.length == 3) {
                try {
                    ingChoice1 = Integer.parseInt(choices[0]);
                    ingChoice2 = Integer.parseInt(choices[1]);
                    ingChoice3 = Integer.parseInt(choices[2]);
                    if (ingChoice1 >= 1 && ingChoice1 <= 5 && ingChoice2 >= 1 && ingChoice2 <= 5 && ingChoice3 >= 1 && ingChoice3 <= 5) {
                        break;
                    }
                } catch (NumberFormatException e) {
                   
                }
            }
            System.out.println("Invalid choice(s). Please pick only from the given list:");
        } while (true);
      
        String ing1 = "", ing2 = "", ing3 = "";
        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            case 5:
                ing1 = "Pineapple";
                break;
        }
        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            case 5:
                ing2 = "Pineapple";
                break;
        }
        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            case 5:
                ing3 = "Pineapple";
                break;
        }
        pizzaIngredients = ing1 + ", " + ing2 + ", " + ing3;

        
        int sizeChoice;
        do {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.print("Enter only one choice (1, 2, or 3):");
            try {
                sizeChoice = scanner.nextInt();
                if (sizeChoice >= 1 && sizeChoice <= 3) {
                    break;
                }
            } catch (NumberFormatException e) {
                
            }
            System.out.println("Invalid choice. Please enter a valid option.");
        } while (true);
        String pizzaSize = "";
        switch (sizeChoice) {
            case 1:
                pizzaSize = "Large";
                break;
            case 2:
                pizzaSize = "Medium";
                break;
            case 3:
                pizzaSize = "Small";
                break;
        }

       
        scanner.nextLine();
        System.out.print("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();

      
        int sideDishChoice;
        do {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.print("What would you like? Pick one (1, 2, 3,…):");
            try {
                sideDishChoice = scanner.nextInt();
                if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                    break;
                }
            } catch (NumberFormatException e) {
                
            }
            System.out.println("Invalid choice. Please enter a valid option.");
        } while (true);
        String sideDish = "";
        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish = "Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            case 5:
                sideDish = "Nothing for me";
                break;
        }
        sides = sideDish;

     
        int drinkChoice;
        do {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.print("Enter your choice:");
            try {
                drinkChoice = scanner.nextInt();
                if (drinkChoice >= 1 && drinkChoice <= 4) {
                    break;
                }
            } catch (NumberFormatException e) {
              
            }
            System.out.println("Invalid choice. Please enter a valid option.");
        } while (true);
        String drink = "";
        switch (drinkChoice) {
            case 1:
                drink = "Coca Cola";
                break;
            case 2:
                drink = "Cold coffee";
                break;
            case 3:
                drink = "Cocoa Drink";
                break;
            case 4:
                drink = "No drinks for me";
                break;
        }
        drinks = drink;

        scanner.nextLine();
        System.out.print("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();
        if ("Y".equalsIgnoreCase(wantDiscount) || "y".equalsIgnoreCase(wantDiscount)) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate;
        do {
            System.out.print("Give your birthday:(yyyy-MM-dd):");
            String birthDateStr = scanner.nextLine();
            try {
                birthDate = sdf.parse(birthDateStr);
                Date currentDate = new Date();
                long diffInMillis = currentDate.getTime() - birthDate.getTime();
                long diffInYears = diffInMillis / (24 * 60 * 60 * 1000 * 365);
                if (diffInYears < 5 || diffInYears > 120) {
                    System.out.println("Invalid date. You are either too young or too dead to order.");
                    System.out.println("Please enter a valid date:");
                } else {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Format error. Please try again.");
            }
        } while (true);

        Date currentDate = new Date();
        long diffInMillis = currentDate.getTime() - birthDate.getTime();
        long diffInYears = diffInMillis / (24 * 60 * 60 * 1000 * 365);
        if (diffInYears < 18 && sdf.format(currentDate).equals(sdf.format(birthDate))) {
            System.out.println("You can have a half-price pizza!");
        } else {
            System.out.println("You can't get a half-price pizza.");
        }
    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        long cardNumber;
        String expiryDate;
        int cvv;
        do {
            System.out.print("Enter your card Number:");
            cardNumber = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter card expiration date:");
            expiryDate = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            try {
                Date expiry = sdf.parse(expiryDate);
                Date currentDate = new Date();
                if (expiry.before(currentDate)) {
                    System.out.println("Invalid date. The expiration date must be in the future.");
                } else {
                    break;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        } while (true);
        System.out.print("Enter CVV number: ");
        cvv = scanner.nextInt();
        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        while (true) {
            if (String.valueOf(cardNumber).length() == 14 && cardNumber != BLACKLISTED_NUMBER) {
                break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Invalid card number. Please enter a 14-digit number that is not blacklisted.");
            System.out.print("Enter your card Number:");
            cardNumber = scanner.nextLong();
        }
        String cardNumberStr = String.valueOf(cardNumber);
        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));
        String cardNumberToDisplay = cardNumberStr.charAt(0) + cardNumberStr.substring(1, cardNumberStr.length() - 4).replaceAll(".", "*") + cardNumberStr.substring(cardNumberStr.length() - 4);
        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));
        System.out.println("Card number to display:" + cardNumberToDisplay);
        System.out.println("Card accepted");
    }

    public void makePizza(String ingredients) {
        this.pizzaIngredients = ingredients;
        System.out.println("make Pizza");
    }

    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("the receipt\n");
        receipt.append("orderID: ").append(getOrderID()).append("\n");
        receipt.append("orderTotal: ").append(getOrderTotal()).append("\n");
        return receipt.toString();
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        System.out.println("Pizza of the day:" + pizzaOfTheDay);
        System.out.println("Side of the day: " + sideOfTheDay);
        System.out.println("Special price: " + specialPrice);
    }

    public static void main(String[] args) throws Exception {
        SliceoHeaven pizzaStore = new SliceoHeaven();
        pizzaStore.takeOrder();
   
        System.out.println(pizzaStore);
    }
}






