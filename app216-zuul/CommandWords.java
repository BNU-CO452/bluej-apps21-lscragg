
/**
 * This contains all the possible command words
 * for the game of Zuul
 *
 * @author Derek Peacock & Nicholas Day
 * @version 25-08-2021
 */
public enum CommandWords
{
    GO   ("go","Exit location in <direction>"),
    TAKE ("take", "Take <item> from location"),
    STIR ("stir", "Stir <cauldron> or stir <item> into the cauldron"),
    LOOK ("look", "Look at recipe, location and inventory"),
    HELP ("help", "List all available commands"),
    QUIT ("quit", "End the game");
    
    public final String word;
    public final String description;
    
    CommandWords(String word, String description)
    {
        this.word = word;
        this.description = description;
    }
}
