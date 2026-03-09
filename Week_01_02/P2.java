import java.util.*;

public class FlashSale {

    private HashMap<String, Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String product, int quantity) {
        stock.put(product, quantity);
        waiting.put(product, new LinkedList<>());
    }

    public synchronized void purchase(String product, int userId) {

        int available = stock.get(product);

        if (available > 0) {
            stock.put(product, available - 1);
            System.out.println("User " + userId + " purchased. Remaining: " + (available - 1));
        } else {
            waiting.get(product).add(userId);
            System.out.println("User added to waiting list: " + userId);
        }
    }

    public static void main(String[] args) {

        FlashSale sale = new FlashSale();

        sale.addProduct("IPHONE15", 2);

        sale.purchase("IPHONE15", 1);
        sale.purchase("IPHONE15", 2);
        sale.purchase("IPHONE15", 3);
    }
}