
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
    private final String  DEF_PIZZA_INGERDIENTS = "Mozzarella Cheese";
    private final Double DEF_ORDER_TOTAL = 15.00;

    
    public SliceoHeaven(){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGERDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceoHeaven(String orderID,String pizzaIngredients,Double oederTotal){
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderID(){
        return orderID;
    }

    public Double  getOrderTotal(){
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal){
        this.orderTotal = orderTotal;
    }

    public void takeOrder(String orderID,String items,double total) {
        this.orderID = orderID;
        this.storeMenu = items;
        this.orderTotal = total;
    }
    
    public void makePizza(String ingredients){
        this.pizzaIngredients = ingredients;
        System.out.println("make Pizza");
    }

    private void printReceipt(){
        System.out.println("the receipt");
        System.out.println("orderID:" + getOrderID());
        System.out.println("oederTotal:" + getOrderTotal());
    }

    public void processCardPayment(String cardNumber, String expiryDate, int cvv){
        int cardLength = cardNumber . length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        }else{
            System.out.println("Invalid card");
            return;
        }

        int firestCardDigit = Integer.parseInt(cardNumber.substring(0,1));
        String blacklistedNumber = "12345678901234";
        if(cardNumber.equals(blacklistedNumber)){
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }
        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));

        String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1, cardNumber.length() - 4).replaceAll(".", "*") + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        System.out.println("Pizza of the day: " + pizzaOfTheDay);
        System.out.println("Side of the day: " + sideOfTheDay);
        System.out.println("Special price: " + specialPrice);
    }

    public static void main(String[] args) throws Exception {
        SliceoHeaven pizzaStore = new SliceoHeaven();
        pizzaStore.takeOrder("723","Pizza",27.09);
        pizzaStore.makePizza("flour,cheese");
        pizzaStore.printReceipt();

        pizzaStore.processCardPayment("12345678901234","12/25",123);
        pizzaStore.specialOfTheDay("Pepperoni Pizza","Fries","$10" );
    }
   
}
