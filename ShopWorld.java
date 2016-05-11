import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * The world that will allow the player to buy upgrades
 * 
 * @Tea N' Code
 */
public class ShopWorld extends World
{
    /**
     * Constructor for objects of class ShopWorld.
     */
    public ShopWorld(World backTo)
    {    
        super(1000, 800, 1);
        //Allows the player to return to the Hub
        addObject(new Button("back", backTo),29,789);
        //Tells them what is going on
        addObject(new Display("Nothing yet",50,Color.BLACK,new Color(0,0,0,0)),500,400);
    }
    
    /**
     * Opens the console when the player presses '~'
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
