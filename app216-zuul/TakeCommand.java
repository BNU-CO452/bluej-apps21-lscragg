
/**
 * This command allows the player to
 * take or pickup an item from a room
 * and carry it around to use somewhere
 * else
 *
 * @author Derek Peacock & Nicholas Day
 * @version 2021-08-23
 */
public class TakeCommand extends ZuulCommand
{
    String item;
    /**
     * Take an item from a location and add it
     * to the player's inventory.
     */
    public TakeCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;
    }    

    public void execute()
    {
        if(item == null) 
        {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }
        Map map = zuul.MAP;
        Player player = zuul.PLAYER;
        
        Location currentLocation = map.getCurrentLocation();
      
        
        if(item.equals("cauldron"))
        {
            if(currentLocation.getName().equals("cave"))            
            {
                System.out.println("Cauldron cannot be picked up");
            }
            
            else
            {
                System.out.println(item + " does not exist either in this location or anywhere");
            }
        }  
        
        else if(item.equals("recipe"))
        {
            String checkLocation = "cave";
            Item chkitem = map.recipe;
            checkItem(chkitem, checkLocation);
        }
        else if(item.equals("codebook"))
        {
            String checkLocation = "cave";
            Item chkitem = map.codebook;
            checkItem(chkitem, checkLocation);
        }
        else if (item.equals("watch"))
        {
            String checkLocation = "cave";
            Item chkitem = map.watch;
            checkItem(chkitem, checkLocation);
        }
        else if(item.equals("snakeroot"))
        {
            String checkLocation = "field";
            Item chkitem = map.snakeroot;
            checkItem(chkitem, checkLocation);
        } 
        
        else if(item.equals("buttercup"))
        {
            String checkLocation = "meadow";
            Item chkitem = map.buttercup;
            checkItem(chkitem, checkLocation);
        } 
        
        else if(item.equals("holly"))
        {
            String checkLocation = "forest";
            Item chkitem = map.holly;
            checkItem(chkitem, checkLocation);
        } 
        
        else if(item.equals("hound"))
        {
            String checkLocation = "cropland";
            Item chkitem = map.hound_tongue;
            checkItem(chkitem, checkLocation);
        } 
        
        else if(item.equals("adder"))
        {
            String checkLocation = "heathland";
            Item chkitem = map.adder_tongue;
            checkItem(chkitem, checkLocation);
        } 
        
        else if(item.equals("mustard"))
        {
            String checkLocation = "house";
            Item chkitem = map.mustard_seeds;
            checkItem(chkitem, checkLocation);
        } 
        
        else
        {
            System.out.println(item + " does not exist either in this location or anywhere");
        }
    }
    
    /**
     * Checks if item is already in inventory
     */
    public void checkItem(Item checkItem, String chklocation)
    {
        Map map = zuul.MAP;
        Player player = zuul.PLAYER;
        Location currentLocation = map.getCurrentLocation();
        
         if(currentLocation.getName().equals(chklocation))
            {
                if (player.inventory.contains(checkItem))
                {
                  System.out.println(item + " is already in your inventory. Type look inventory to check");  
                }
                else
                {
                  currentLocation.removeItem(checkItem);
                  player.addInventory(checkItem);
                  System.out.println(item + " has been added to inventory");
                  player.decreasePotionTurns();  
                }
            }
         else
            {
                System.out.println(item + " does not exist either in this location or anywhere");
            }
        
    }
}

