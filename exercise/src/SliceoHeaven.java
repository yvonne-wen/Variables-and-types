

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
