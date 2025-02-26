
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
    public static void main(String[] args) throws Exception {
        SliceoHeaven pizzaStore = new SliceoHeaven();
        pizzaStore.takeOrder("123","Pizza",27.09);
        pizzaStore.makePizza("flour,cheese");
        pizzaStore.printReceipt();
    }
   
}
