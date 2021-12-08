
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *
 *              [Hill]<---->[Heathland]
 *                 |
 *            [Dark forest]
 *                 |
 *  [Pond]<---->[Field]<---->[Ogre's House]
 *    |            |
 * [Cropland]    [Cave]
 *             
 * @author Derek Peacock and Nicholas Day
 * @version 2021-08-22
 */
public class Map
{
    private Location cave, field, pond, cropland, ogre_house, dark_forest, hill, heathland;

    private Location currentLocation;
    
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
     * Both locations need to have been created before
     * their exits are linked.
     */
    private void createLocations()
    {
        createCave();
        createField();
        createPond();
        createCropland();
        createOgre_house();
        createDark_forest();
        createHill();
        createHeathland();

        currentLocation = cave;  // start game in the cave
    }
    
    /**
     * Create the cave and link it to the field
     */
    private void createCave()
    {
        cave = new Location("inside your cave ");
    }
    
    /**
     * Create the field and link it to the cave
     */
    private void createField()
    {
        field = new Location("in a field");
        
        field.setExit("south", cave);
        cave.setExit("north", field);
    }
    
    /**
     * Create the pond  and link it to the field
     */
    private void createPond()
    {
        pond = new Location("next to a pond");
        
        pond.setExit("east", field);
        field.setExit("west", pond);
    }
    
    /**
     * Create the cropland  and link it to the pond
     */
    private void createCropland()
    {
        cropland = new Location("in a cropland");
        
        cropland.setExit("north", pond);
        pond.setExit("south", cropland);
    }
    
    /**
     * Create the Ogre's house and link it to the field
     */
    private void createOgre_house()
    {
        ogre_house = new Location("in an Ogre's house");
        
        ogre_house.setExit("west", field);
        field.setExit("east", ogre_house);
    }
    
    /**
     * Create the dark forest and link it to the field
     */
    private void createDark_forest()
    {
        dark_forest = new Location("in a dark forest");
        
        dark_forest.setExit("south", field);
        field.setExit("north", dark_forest);
    }
    
    /**
     * Create hill and link it to dark forest
     */
    private void createHill()
    {
        hill= new Location("on a hill");
        
        hill.setExit("south", dark_forest);
        dark_forest.setExit("north", hill);
    }
    
    /**
     * Create heathland and link it to hill
     */
    private void createHeathland()
    {
        heathland = new Location("in a heathland");
        
        heathland.setExit("west", hill);
        hill.setExit("east", heathland);
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
