import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
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
        addObject(new Display("Inventory",50,Color.BLACK,new Color(0,0,0,0)),500,20);
        addObject(new Display("Active Items",50,Color.BLACK,new Color(0,0,0,0)),500,500);
        populateWorld();
    }

    public void populateWorld()
    {
        String[] inventory = {"have fun"};
        inventory = Save.inventory.toArray(inventory);
        int counter = 0;
        int y = 0;
        int x = 100;
        for(String item : inventory)
        {
            if(item != null)
            {
                if(counter % 5 == 0)
                {
                    y += 100;
                    x = 100;
                }
                addObject(new InventoryItem(item,false,counter),x,y);
                x += 200;
                counter++;
            }
        }
        
        x = 200;
        y = 500;
        counter = 0;
        for(String item : Save.activeItems)
        {
            if(item != null)
            {
                if(counter % 3 == 0)
                {
                    y += 100;
                    x = 200;
                }
                addObject(new InventoryItem(item,true,counter),x,y);
                x += 300;
                counter++;
            }
        }
    }
    
    public void update()
    {
        removeObjects(getObjects(InventoryItem.class));
        populateWorld();
    }
}
