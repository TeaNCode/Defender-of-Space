import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InventoryWorld here.
 * 
 * @author Tea N' Code
 */
public class InventoryWorld extends World
{
    /**
     * Constructor for objects of class InventoryWorld.
     * 
     */
    public InventoryWorld(World backTo)
    {    
        super(1000, 800, 1);
        addObject(new Button("back", backTo),29,789);
        
    }
    
    public void populateWorld()
    {
        String[] inventory = {"have fun"};
        inventory = Save.inventory.toArray(inventory);
        int counter 
    }
}
