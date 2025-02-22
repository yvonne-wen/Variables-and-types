
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
    String orderID;
    Double orderTotal;

    public void takeOrder(String orderID,String items,double total) {
        this.orderID = orderID;
        this.storeMenu = items;
        this.orderTotal = total;
    }
    
    public void makePizza(String ingredients){
        this.pizzaIngredients = ingredients;
        System.out.println("make Pizza");
    }

    public void printReceipt(){
        System.out.println("the receipt");
        System.out.println("orderID:");
        System.out.println("oederTotal:");
    }
    public static void main(String[] args) throws Exception {
        SliceoHeaven pizzaStore = new SliceoHeaven();
        pizzaStore.takeOrder("123","Pizza",27.09);
        pizzaStore.makePizza("flour,cheese");
        pizzaStore.printReceipt();
    }
   
}
