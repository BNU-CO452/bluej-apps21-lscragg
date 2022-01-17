
/**
 * This command allows the player to stir the cauldron and 
 * stir items into the cauldron
 *
 * @author Lottie Scragg
 * @version 15/12/2021
 */
public class StirCommand extends ZuulCommand
{
    String item;
    /**
     * Take an item from player's inventory and 
     * add it to the potion
     */
    public StirCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;
    }    

    public void execute()
    {
        if(item == null) 
        {
            // if there is no second word, we don't know what to stir...
            System.out.println("Stir what?");
            System.out.println();
            return;
        }
        Map map = zuul.MAP;
        Player player = zuul.PLAYER;
        
        Location currentLocation = map.getCurrentLocation();
        
        if(currentLocation.getName().equals("cave")) 
        {
            if (item.equals("cauldron"))
            {
                System.out.println("Cauldron has been stirred");
                System.out.println();
                player.resetPotionTurns();
                player.addTime();
            }
            else if (item.equals("snakeroot"))
            {
                int checkStatus = 0;
                Item stirItem = map.snakeroot;
                checkStatus(checkStatus, stirItem);
            }
            else if (item.equals("mustard"))
            {
                int checkStatus = 1;
                Item stirItem = map.mustard_seeds;
                checkStatus(checkStatus, stirItem);
            }
            else if (item.equals("buttercup"))
            {
                int checkStatus = 2;
                Item stirItem = map.buttercup;
                checkStatus(checkStatus, stirItem);
            }
            else if (item.equals("holly"))
            {
                int checkStatus = 3;
                Item stirItem = map.holly;
                checkStatus(checkStatus, stirItem);
            }
            else if (item.equals("hound"))
            {
                int checkStatus = 4;
                Item stirItem = map.hound_tongue;
                checkStatus(checkStatus, stirItem);
            }
            else if (item.equals("adder"))
            {
                int checkStatus = 5;
                Item stirItem = map.adder_tongue;
                checkStatus(checkStatus, stirItem);
            }
            else if (item.equals("recipe"))
            {
                if (player.inventory.contains(map.recipe))
                {
                    System.out.println("You cannot stir " + item);
                    System.out.println();
                }
                else
                {
                    System.out.println(item + " is not in your inventory");
                    System.out.println();
                }
            }
            else if (item.equals("codebook"))
            {
                if (player.inventory.contains(map.codebook))
                {
                    System.out.println("You cannot stir " + item);
                    System.out.println();
                }
                else
                {
                    System.out.println(item + " is not in your inventory");
                    System.out.println();
                }
            }
            else if (item.equals("watch"))
            {
                if (player.inventory.contains(map.watch))
                {
                    System.out.println("You cannot stir " + item);
                    System.out.println();
                }
                else
                {
                    System.out.println(item + " is not in your inventory");
                    System.out.println();
                }
            }
            else
            {
                System.out.println(item + " is not in your inventory");
                System.out.println();
            }
        } 
        else
        {
            System.out.println("You can only stir when you are in the cave");
            System.out.println();
        }
    }
    
    /**
     * Checks if item is in inventory.
     * If it is, removes item from inventory as item has been stirred at correct point
     */
    private void rightItem(Item checkitem)
    {
        Player player = zuul.PLAYER;
        if (player.inventory.contains(checkitem))
        {
           System.out.println(item + " has been added to the cauldron");
           System.out.println();
           player.removeInventory(checkitem);
           player.increasePotionstatus();
        }
        else
        {
            System.out.println(item + " is not in your inventory");
            System.out.println();
        }
    }
    
    /**
     * Checks if item is in inventory.
     * If it is, it prints out wrong item message and time penalty is added
     */
    private void wrongItem(Item checkitem)
    {
        Player player = zuul.PLAYER;
        if(player.inventory.contains(checkitem))            
        {
            System.out.println("You added the wrong item to your potion and it exploded.");
            System.out.println("You cast a spell to save your potion but it takes half an hour.");
            System.out.println();
            player.wrongMoveTime();
        }
            
        else
        {
            System.out.println(item + " is not in your inventory");
            System.out.println();
        } 
    }
    
    /**
     * Checks whether the item is correct or incorrect
     */
    private void checkStatus(int status, Item statusItem)
    {   
        Player player = zuul.PLAYER;
        if (player.getPotionstatus() == status)
           {
               rightItem(statusItem);
           }
        else
           {
               wrongItem(statusItem);
           }
    }
}
