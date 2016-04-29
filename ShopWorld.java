import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ShopWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopWorld extends World
{
    /**
     * Constructor for objects of class ShopWorld.
     * 
     */
    public ShopWorld(World backTo)
    {    
        super(1000, 800, 1);
        addObject(new Button("back", backTo),29,789);
        addObject(new Display("Nothing yet",50,Color.BLACK,new Color(0,0,0,0)),500,400);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
