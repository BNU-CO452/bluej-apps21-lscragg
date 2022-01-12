
/**
 * Items that are found in each location.
 *
 * @Lottie Scragg
 * @12/01/2022
 */
public class Item
{
    private String name;
    private String description;
    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Returns name
     */
    public String getName()
    {
        return name;
    }
    
}
