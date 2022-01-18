
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
    String item2;
    /**
     * Take an item from player's inventory and 
     * add it to the potion
     */
    public StirCommand(Game zuul, String item, String item2)
    {
        super(zuul);
        this.item = item;
        this.item2 = item2;
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
                Location returnLocation = map.field; 
                checkStatus(checkStatus, stirItem, returnLocation);
            }
            else if (item.equals("mustard") && item2.equals("seeds"))
            {
                int checkStatus = 1;
                Item stirItem = map.mustard_seeds;
                Location returnLocation = map.ogre_house;
                checkStatus(checkStatus, stirItem, returnLocation);
            }
            else if (item.equals("buttercup"))
            {
                int checkStatus = 2;
                Item stirItem = map.buttercup;
                Location returnLocation = map.meadow;
                checkStatus(checkStatus, stirItem, returnLocation);
            }
            else if (item.equals("holly"))
            {
                int checkStatus = 3;
                Item stirItem = map.holly;
                Location returnLocation = map.dark_forest;
                checkStatus(checkStatus, stirItem, returnLocation);
            }
            else if (item.equals("hound's") && item2.equals("tongue"))
            {
                int checkStatus = 4;
                Item stirItem = map.hound_tongue;
                Location returnLocation = map.cropland;
                checkStatus(checkStatus, stirItem, returnLocation);
            }
            else if (item.equals("adder's") && item2.equals("tongue"))
            {
                int checkStatus = 5;
                Item stirItem = map.adder_tongue;
                Location returnLocation = map.heathland;
                checkStatus(checkStatus, stirItem, returnLocation);
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
                if (item2 == null)
                {
                    System.out.println(item + " is not in your inventory");
                }
                else
                {
                    System.out.println(item + " " + item2 + " is not in your inventory");
                }
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
           if (item2 == null)
           {
               System.out.println(item + " has been added to the cauldron");
           }
           else
           {
               System.out.println(item + " " + item2 + " has been added to the cauldron");
           }
           System.out.println();
           player.removeInventory(checkitem);
           player.increasePotionstatus();
           player.addTime();
        }
        else
        {
            if (item2 == null)
            {
                System.out.println(item + " is not in your inventory");
            }
            else
            {
                System.out.println(item + " " + item2 + " is not in your inventory");
            }
            System.out.println();
        }
    }
    
    /**
     * Checks if item is in inventory.
     * If it is, it prints out wrong item message and time penalty is added
     */
    private void wrongItem(Item checkitem, Location returnLocation)
    {
        Player player = zuul.PLAYER;
        if(player.inventory.contains(checkitem))            
        {
            System.out.println("You added the wrong item to your potion and it exploded.");
            System.out.println("You cast a spell to save your potion but it takes half an hour.");
            System.out.println("The item you stirred was removed from your inventory and added back to its location");
            player.removeInventory(checkitem);
            returnLocation.addItem(checkitem);
            
            System.out.println();
            player.wrongMoveTime();
        }
            
        else
        {
            if (item2 == null)
            {
                System.out.println(item + " is not in your inventory");
            }
            else
            {
                System.out.println(item + " " + item2 + " is not in your inventory");
            }
            System.out.println();
        } 
    }
    
    /**
     * Checks whether the item is correct or incorrect
     */
    private void checkStatus(int status, Item statusItem, Location returnLocation)
    {   
        Player player = zuul.PLAYER;
        if (player.getPotionstatus() == status)
           {
               rightItem(statusItem);
           }
        else
           {
               wrongItem(statusItem, returnLocation);
           }
    }
}
