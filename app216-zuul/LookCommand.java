
/**
 * Allows user to look at items, location and inventory.
 *
 * @Lottie Scragg
 * @12/01/2022
 */
public class LookCommand extends ZuulCommand
{
    String item;
    /**
     * Constructor for objects of class LookCommand
     */
    public LookCommand(Game zuul, String item)
    {
        // initialise instance variables
        super(zuul);
        this.item = item;
    }

    public void execute()
    {
        Map map = zuul.MAP;
        Player player = zuul.PLAYER;
        Location currentLocation = map.getCurrentLocation();
        
        
        
        if (item == null)
        {
            System.out.println("Look at what?");
            return;
        }
        if (item.equals("inventory"))
        {
            player.printInventory();
            player.decreasePotionTurns();
        }
        else if (item.equals("location"))
        {
            System.out.println(map.getCurrentLocation().getLongDescription());
            if(map.getCurrentLocation().getName() == ("cave"))
            {
                map.getCurrentLocation().printItems();
            }
            player.decreasePotionTurns();
        }
        else if (item.equals("cauldron"))
        {
            player.decreasePotionTurns();
            if (currentLocation.getName().equals("cave"))
            {
                map.cauldron.getDescription();
            }
            else
            {
                System.out.println("You cannot see " + item);
            }
        }
        else if (item.equals("snakeroot"))
        {
            checkInventory(map.snakeroot, "field");
        }
        else if (item.equals("mustard"))
        {
            checkInventory(map.mustard_seeds, "house");
        }
        else if(item.equals("buttercup"))
        {
            checkInventory(map.buttercup, "meadow");
        }
        else if (item.equals("holly"))
        {
            checkInventory(map.holly, "forest");
        }
        else if(item.equals("hound"))
        {
            checkInventory(map.hound_tongue, "cropland");
        }
        else if(item.equals("adder"))
        {
            checkInventory(map.adder_tongue, "heathland");
        }
        else if (item.equals("recipe"))
        {
           player.decreasePotionTurns();
           if (player.inventory.contains(map.recipe) || currentLocation.getName() == "cave")
           {
              if(player.getPotionstatus() == 0)
              {
                System.out.println("For the items you have yet to seek,");
                System.out.println("In the codebook you must peek.");
                System.out.println("To find the fenny snake that you have yet to yield,");
                System.out.println("Try looking for it in the field");
              }
              else if(player.getPotionstatus() == 1)
              {
                System.out.println("For this next item you will have to be reliant,");
                System.out.println("On your friend who is green, hideous and giant.");
                System.out.println("You let him borrow your eye of newt,");
                System.out.println("Visit him to get it back from this massive brute.");
              }
              else if(player.getPotionstatus() == 2)
              {
                System.out.println("Blue poison dart and red-eyed tree,");
                System.out.println("Are two breeds of the animal that is item number three.");
                System.out.println("The plant in question is found where it grows,");
                System.out.println("Perhaps ask the internet to see what it knows.");
              }
              else if(player.getPotionstatus() == 3)
              {
                System.out.println("You are half way there so it won't take long,");
                System.out.println("For you to find this animal part that seems bizarre and wrong.");
                System.out.println("Part of the only mammal that flies is what you need to search for,");
                System.out.println("To find where it grows to the internet you must go to explore.");
              }
              else if(player.getPotionstatus() == 4)
              {
                System.out.println("This part on a chow chow is actually blue,");
                System.out.println("That may be suprising to view.");
                System.out.println("You may have worked out what the next line is going to be,");
                System.out.println("So off you go to the internet where the habitat you will find and see.");
              }
              else 
              {
                System.out.println("For this last item you shall have little clues,");
                System.out.println("But you shall be given this one bit of news.");
                System.out.println("The items are all used by your sisters from the Scottish Play,");
                System.out.println("So they shall be the ones to help you on your way.");
              }
           }
           else
           {
               System.out.println("You cannot see " + item);
           }
        }
        else if (item.equals("codebook"))
        {
            player.decreasePotionTurns();
            if (player.inventory.contains(map.recipe) || currentLocation.getName() == "cave")
            {
                System.out.println("Adder's fork = Adder's tongue");
                System.out.println("Blind-worm's sting = Poppies");
                System.out.println("Eye of newt = Mustard seeds");
                System.out.println("Fillet of a fenny snake = Snake root");
                System.out.println("Lizard's leg = Ivy");
                System.out.println("Scale of dragon = Tarragon");
                System.out.println("Tongue of dog = Hound's tongue");
                System.out.println("Toe of frog = buttercup");
                System.out.println("Tooth of wolf = Wolf's bane");
                System.out.println("Wool of bat = Holly");
            }
            else
            {
                System.out.println("You cannot see " + item);
            }
        }
        else if(item.equals("watch"))
        {
            player.decreasePotionTurns();
            if (player.getHours() < 10 && player.getMinutes() <= 5)
            {
                System.out.println("The time is 0" + player.getHours() + " : 0" + player.getMinutes());
            }
            else if (player.getHours() < 10 && player.getMinutes() > 5)
            {
                System.out.println("The time is 0" + player.getHours() + " : " + player.getMinutes());
            }
            else if (player.getHours() >= 10 && player.getMinutes() <=5)
            {
                System.out.println("The time is " + player.getHours() + " : 0" + player.getMinutes());
            }
            else
            {
                System.out.println("The time is " + player.getHours() + " : " + player.getMinutes());
            }
            player.printStirTime();
        }
        else
        {
            System.out.println("You cannot see " + item);
            player.decreasePotionTurns();
        }
    }
    
    /**
     *  Checks if item is in inventory.
     *  If it is not, checks if it is in location
     */
    private void checkInventory(Item object, String location)
    {
        Map map = zuul.MAP;
        Player player = zuul.PLAYER;
        Location currentLocation = map.getCurrentLocation();
        
        player.decreasePotionTurns();
        if(player.inventory.contains(object))
        {
            object.getDescription();
        }
        else
        {
            if(currentLocation.getName() == location)
            {
                System.out.println("You can see " + item);
            }
            else
            {
                System.out.println("You cannot see " + item);
            }
        }
    }
}
