
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Lottie Scragg
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        
        else if (choice.equals("add"))
        {   int id = reader.getInt("Please enter the ID for the product ");
            String name = reader.getString ("Please enter the name for the product ");
            Product product = new Product(id, name);
            stock.add(product);
            System.out.println("ID " + product.getID() +  " : " + product.getName() + " has been added");
        } 
        
        else if(choice.equals("print"))
        {
            stock.print();
        }
        
        else if(choice.equals("remove"))
        {   int id = reader.getInt("Please enter the ID for the product ");
            Product product = stock.findProduct(id);
            stock.remove(id);
            System.out.println("ID " + product.getID() +  " : " + product.getName() + " has been removed");
        }
        
        else if(choice.equals("buy"))
        {
            int id = reader.getInt("Please enter the ID for the product ");
            int amount = reader.getInt("Please enter the amount you want to buy ");
            Product product = stock.findProduct(id);
            stock.buyProduct(id, amount);
            System.out.println(amount + " of ID " + product.getID() + " : " + product.getName() + " has been bought");
        }
        
        else if(choice.equals("sell"))
        {
            int id = reader.getInt("Please enter the ID for the product ");
            int amount = reader.getInt("Please enter the amount you want to sell ");
            Product product = stock.findProduct(id);
            stock.sellProduct(id, amount);
            System.out.println(amount + " of ID " + product.getID() + " : " + product.getName() + " has been sold");
        }
        
        else if(choice.equals("search"))
        {
            String name = reader.getString("Please enter the phrase you are looking for ");
            stock.searchName(name);
        }
        
        else if (choice.equals("low stock"))
        {
            int quantity = reader.getInt("Please enter the stock level you want to check ");
            stock.lowStock(quantity);
        }
        
        else if(choice.equals("re-stock"))
        {
            int quantity = reader.getInt("Please enter the stock level to re-stock to ");
            stock.restock(quantity);
            System.out.println("Products have been re-stocked");
            stock.print();
        }
        
        else if(choice.equals("re stock"))
        {
            int quantity = reader.getInt("Please enter the stock level to re-stock to ");
            stock.restock(quantity);
            System.out.println("Products have been re-stocked");
            stock.print();
        }
        
        return false;
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Buy:        Buy an amount of a product");
        System.out.println("    Sell:       Sell an amount of a product");
        System.out.println("    Search:     Search for products by phrase");
        System.out.println("    Low Stock:  Prints all products low on stock");
        System.out.println("    Re-Stock:   Re-stocks all products low on stock");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Lottie Scragg");
        System.out.println("********************************");
    }
}