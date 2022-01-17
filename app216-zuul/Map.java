
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *
 *              [Meadow]<---->[Heathland]
 *                 |
 *            [Dark forest]
 *                 |
 *  [Pond]<---->[Field]<---->[Ogre's House]
 *    |            |
 * [Cropland]    [Cave]
 *             
 * @author Lottie Scragg
 * @version 15/12/2021
 */
public class Map
{
    public Location cave, field, pond, cropland, ogre_house, dark_forest, meadow, heathland;

    private Location currentLocation;
    
    public Item cauldron, recipe, codebook, watch, snakeroot, buttercup, holly, hound_tongue, adder_tongue, mustard_seeds;  
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createLocations();
    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the cave.
     * Creates items and adds them to location
     */
    private void createLocations()
    {
        createCave();
        createField();
        createPond();
        createCropland();
        createOgre_house();
        createDark_forest();
        createMeadow();
        createHeathland();

        currentLocation = cave;  // start game in the cave
    }
    
    /**
     * Create the cave and link it to the field
     */
    private void createCave()
    {
        cave = new Location("inside your cave ", "cave");
        
        cauldron = new Item("cauldron", "use this to make your potion");
        cave.addItem(cauldron);
        
        recipe = new Item("recipe", "look at this to know how to make your potion");
        cave.addItem(recipe);
        
        codebook = new Item("codebook", "look at this to help decipher the items");
        cave.addItem(codebook);
        
        watch = new Item("watch", "look at this to read the time");
        cave.addItem(watch);
    }
    
    /**
     * Create the field and link it to the cave
     */
    private void createField()
    {
        field = new Location("in a field", "field");
        
        snakeroot = new Item("snakeroot", "an item for your potion");
        field.addItem(snakeroot);
        
        field.setExit("south", cave);
        cave.setExit("north", field);
    }
    
    /**
     * Create the pond  and link it to the field
     */
    private void createPond()
    {
        pond = new Location("next to a pond", "pond");
        
        pond.setExit("east", field);
        field.setExit("west", pond);
    }
    
    /**
     * Create the cropland  and link it to the pond
     */
    private void createCropland()
    {
        cropland = new Location("in a cropland", "cropland");
        
        hound_tongue = new Item("hound's tongue", "an item for your potion");
        cropland.addItem(hound_tongue);
        
        cropland.setExit("north", pond);
        pond.setExit("south", cropland);
    }
    
    /**
     * Create the Ogre's house and link it to the field
     */
    private void createOgre_house()
    {
        ogre_house = new Location("in an Ogre's house", "house");
        
        mustard_seeds = new Item("mustard seeds", "an item for your potion");
        ogre_house.addItem(mustard_seeds);
        
        ogre_house.setExit("west", field);
        field.setExit("east", ogre_house);
    }
    
    /**
     * Create the dark forest and link it to the field
     */
    private void createDark_forest()
    {
        dark_forest = new Location("in a dark forest", "forest");
        
        holly = new Item("holly", "an item for your potion");
        dark_forest.addItem(holly);
        
        dark_forest.setExit("south", field);
        field.setExit("north", dark_forest);
    }
    
    /**
     * Create meadow and link it to dark forest
     */
    private void createMeadow()
    {
        meadow = new Location("in a meadow", "meadow");
        
        buttercup = new Item("buttercup", "an item for your potion");
        meadow.addItem(buttercup);
        
        meadow.setExit("south", dark_forest);
        dark_forest.setExit("north", meadow);
    }
    
    /**
     * Create heathland and link it to meadow
     */
    private void createHeathland()
    {
        heathland = new Location("in a heathland", "heathland");
        
        adder_tongue = new Item("adder's tongue", "an item for your potion");
        heathland.addItem(adder_tongue);
        
        heathland.setExit("west", meadow);
        meadow.setExit("east", heathland);
    }
    
    public Location getCurrentLocation()
    {
        return currentLocation;
    }
    
    public void enterLocation(Location nextLocation)
    {
        currentLocation = nextLocation;
    }
}
