import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpWorld extends World
{
    /**
     * Constructor for objects of class HelpWorld.
     * 
     */
    public HelpWorld(World backTo)
    {    
        super(1000, 800, 1);
        setBackground("gray.fw.png");
        addObject(new Button("back", backTo),29,789); 
    }
}
