
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Lottie Scragg.
 * @version 3.11.2021
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Scythe"));
        stock.add(new Product(102, "Thunderhead"));
        stock.add(new Product(103, "The Toll"));
        stock.add(new Product(104, "Nowhere"));
        stock.add(new Product(105, "Anywhere"));
        stock.add(new Product(106, "Somewhere"));
        stock.add(new Product(107, "The Maze Runner"));
        stock.add(new Product(108, "The Scorch Trials"));
        stock.add(new Product(109, "The Death Cure"));
        stock.add(new Product(1010, "The Kill Order"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();
    }
    
    /**
     * Buys an amount of each product
     */
    private void buyProducts()
    {
        stock.buyProduct(101, 4);
        stock.buyProduct(102, 2);
        stock.buyProduct(103, 8);
        stock.buyProduct(104, 3);
        stock.buyProduct(105);
        stock.buyProduct(106, 7);
        stock.buyProduct(107, 5);
        stock.buyProduct(108, 9);
        stock.buyProduct(109, 6);
        stock.buyProduct(1010, 10);
    }

    /**
     * Sells an amount of each product
     */
    private void sellProducts()
    {
        stock.sellProduct(101, 3);
        stock.sellProduct(102, 1);
        stock.sellProduct(103, 4);
        stock.sellProduct(104);
        stock.sellProduct(105);
        stock.sellProduct(106,9);
        stock.sellProduct(107, 2);
        stock.sellProduct(108, 6);
        stock.sellProduct(109, 4);
        stock.sellProduct(1010, 1);
    } 
}