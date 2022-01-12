import java.util.ArrayList;

/**
 * Creates player.
 * Player has assigned potion turns, time, stir time, potion status 
 * and items can be added to inventory array
 *
 * @author Lottie Scragg
 * @version 12/01/2022
 */
public class Player
{
    private int potionTurns;
    private int minutes;
    private int hours;
    private int stirHours;
    private int stirMinutes;
    private int repeat;
    private int potionstatus;
    public ArrayList<Item> inventory;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        potionTurns = 20;
        potionstatus = 0;
        repeat = 0;
        minutes = 0;
        hours = 7;
        stirHours = 7;
        stirMinutes = 0;
        inventory = new ArrayList<>();
    }
    
    /**
     * If wrong move (i.e. forget to stir cauldron or add wrong item), adds half an hour to 
     * time and resets potion turns to 20
     */
    public void wrongMoveTime()
    {
        while (repeat <5)
        {
            addTime();
            repeat = repeat + 1;
        }
        resetPotionTurns();
        repeat = 0;
    }
    
    /**
     * Adds 5 minutes onto the time
     */
    public void addTime()
    {
        if (minutes == 55)
        {
            minutes = 0;
            hours = hours + 1;
        }
        else
        {
           minutes = minutes + 5; 
        }
    }
    
    /**
     * Returns hours
     */
    public int getHours()
    {
        return hours;
    }
    
    /**
     * Returns minutes
     */
    public int getMinutes()
    {
        return minutes;
    }
    
    /**
     * Returns turns
     */
    public int getPotionTurns()
    {
        return potionTurns;
    }
    
    /**
     * Turns are decreased and time is increased when addTime is called
     */
    public void decreasePotionTurns()
    {
        potionTurns = potionTurns - 1;
        addTime();
    }
    
    /**
     * Resets turns to 20
     */
    public void resetPotionTurns()
    {
        while(potionTurns < 20)
        {
            potionTurns = potionTurns + 1;
        }
        stirMinutes = getMinutes();
        stirHours = getHours();
    }
    
    /**
     * Prints out when potion was stirred
     */
    public void printStirTime()
    {
         if (stirHours == 7 && stirMinutes == 0)
         {
             System.out.println("The potion has not been stirred yet");
         }
         else
         {
            if (stirHours < 10 && stirMinutes <= 5)
            {
               System.out.println("The potion was stirred at 0" + stirHours + " : 0" + stirMinutes);
            }
            else if (stirHours < 10 && stirMinutes > 5)
            {
               System.out.println("The potion was stirred at 0" + stirHours + " : " + stirMinutes);
            }
            else if (stirHours >= 10 && stirMinutes <=5)
            {
               System.out.println("The potion was stirred at 0 " + stirHours + " : 0" + stirMinutes);
            }
            else
            {
               System.out.println("The potion was stirred at " + stirHours + " : " + stirMinutes);
            } 
         }
    }
    /**
     * Returns potion status
     */
    public int getPotionstatus()
    {
        return potionstatus;
    }
    
    /**
     * Allows the potion status to be changed
     */
    public void increasePotionstatus()
    {
        potionstatus = potionstatus + 1;
        resetPotionTurns();
    }
    
    /**
     * Adds item to inventory
     */
    public void addInventory(Item item)
    {
        inventory.add(item);
    }
    
    /**
     * Removes item from inventory
     */
    public void removeInventory(Item item)
    {
        inventory.remove(item);
    }
    
    /**
     * Prints inventory
     */
    public void printInventory()
    {
        System.out.println("The items in inventory are:");
        for (Item item : inventory)
        {
            System.out.println(item.getName());
        }
    }
}
