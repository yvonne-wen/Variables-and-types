import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SliceoHeaven{

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
    private final String DEF_ORDER_ID = "DEF-SOH-099";
    private final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private final Double DEF_ORDER_TOTAL = 15.00;

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
    
    public void takeOrder(){
        Scanner scanner = new  Scanner(System.in);

        System.out.print("Please give the pizza ingredients:");
        pizzaIngredients = scanner.nextLine();

        System.out.print("Please give the pizza size:");
        scanner.nextLine();

        System.out.print("Add cheese(yes/no):");
        scanner.nextLine();

        System.out.print("Please give the other dishes:");
        sides = scanner.nextLine();

        System.out.print("Please give the drinks:");
        drinks = scanner.nextLine();

        System.out.print("half price(yes/no):");
        String halfPriceResponse = scanner.nextLine();
        if ("yes".equalsIgnoreCase(halfPriceResponse)) {
            isItYourBirthday();
        }else{
            makeCardPayment();
        }
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give your birthday: (yyyy-MM-dd): ");
        String birthDateStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthDate = sdf.parse(birthDateStr);
            Date currentDate = new Date();
            long diffInMillis = currentDate.getTime() - birthDate.getTime();
            long diffInYears = diffInMillis / (24 * 60 * 60 * 1000 * 365);

            if (diffInYears < 18 && sdf.format(currentDate).equals(birthDateStr)) {
                System.out.println("You can have a hale-price pizza!");
            } else {
                System.out.println("You can't get a halt-price pizza.");
            }
        } catch (ParseException e) {
            System.out.println("Format error. Please try again.");
        }
    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your card Number:");
        long cardNumber = scanner.nextLong();
        scanner.nextLine(); 

        System.out.print("Enter card expiration date:");
        String expiryDate = scanner.nextLine();

        System.out.print("Enter CVV number: ");
        int cvv = scanner.nextInt();

        processCardPayment(String.valueOf(cardNumber), expiryDate, cvv);
    }

    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        if (cardNumber.length() == 14) {
            int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
            String blacklistedNumber = "12345678901234";
            if (cardNumber.equals(blacklistedNumber)) {
                System.out.println("Card is blacklisted. Please use another card");
                return;
            }
            int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));
            String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1, cardNumber.length() - 4).replaceAll(".", "*") + cardNumber.substring(cardNumber.length() - 4);
            System.out.println("Card number to display: " + cardNumberToDisplay);
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }
    }

    public void makePizza(String ingredients) {
        this.pizzaIngredients = ingredients;
        System.out.println("make Pizza");
    }

    private void printReceipt() {
        System.out.println("the receipt");
        System.out.println("orderID: " + getOrderID());
        System.out.println("orderTotal: " + getOrderTotal());
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        System.out.println("Pizza of the day: " + pizzaOfTheDay);
        System.out.println("Side of the day: " + sideOfTheDay);
        System.out.println("Special price: " + specialPrice);
    }

    public static void main(String[] args) throws Exception {
        SliceoHeaven pizzaStore = new SliceoHeaven();
        pizzaStore.takeOrder();
    
    }
}
