/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  locations, creates the CommandReader and starts the game.  
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Student Name
 */

public class Game 
{
    public final Map MAP;
    private CommandReader reader;
    private boolean gameOver;
    public Player PLAYER;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        MAP = new Map();
        reader = new CommandReader(this);
        PLAYER = new Player();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        gameOver = false;
        
        // Enter the main command loop.  Here we repeatedly 
        // read commands and execute them until the game is over.
                
        while (! gameOver && PLAYER.getPotionstatus() <6 && PLAYER.getHours() < 16) 
        {
            if (PLAYER.getPotionstatus() == 1)
            {
                System.out.println("You have currently added " + PLAYER.getPotionstatus() + " item to your potion");
            }
            else
            {
                System.out.println("You have currently added " + PLAYER.getPotionstatus() + " items to your potion");
            }
            if (PLAYER.getPotionTurns() == 0)
            {
                System.out.println("You forgot to stir your cauldron and your cave caught fire.");
                System.out.println("You cast a spell that saves your cave and its content but it takes half an hour.");
                PLAYER.wrongMoveTime();
                if (PLAYER.getPotionstatus() == 1)
                {
                  System.out.println("You have currently added " + PLAYER.getPotionstatus() + " item to your potion");
                }
                else
                {
                  System.out.println("You have currently added " + PLAYER.getPotionstatus() + " items to your potion");
                }
            }
            gameOver = reader.getCommand();
        }
        
        if (PLAYER.getPotionstatus() == 6)
        {
            System.out.println("You have finished your potion");
            if (PLAYER.getHours() < 10 && PLAYER.getMinutes() <= 5)
            {
                System.out.println("You finished your potion at 0" + PLAYER.getHours() + " : 0" + PLAYER.getMinutes());
            }
            else if (PLAYER.getHours() < 10 && PLAYER.getMinutes() > 5)
            {
                System.out.println("You finished your potion at 0" + PLAYER.getHours() + " : " + PLAYER.getMinutes());
            }
            else if (PLAYER.getHours() >= 10 && PLAYER.getMinutes() <=5)
            {
                System.out.println("You finished your potion at " + PLAYER.getHours() + " : 0" + PLAYER.getMinutes());
            }
            else
            {
                System.out.println("You finished your potion at " + PLAYER.getHours() + " : " + PLAYER.getMinutes());
            }
        }
        else
        {
            System.out.println("You were unable to complete the potion in time");
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println(" Welcome to Hecate's Potion!");
        System.out.println(" You have to complete your potion. Looking at the recipe is a good way to start.");
        System.out.println(" Type 'help' if you need help.");
        System.out.println();
        
        System.out.println(" Your command words are:");
        System.out.println();
        
        for(CommandWords command : CommandWords.values())
        {
            System.out.println(" " + command.word + 
                               "\t  : " + command.description);                        
        }   
        System.out.println();
        System.out.println(" e.g. go west, read recipe ");
        System.out.println();
        
        System.out.println(MAP.getCurrentLocation().getLongDescription());
        MAP.getCurrentLocation().printItems();
    }
}
