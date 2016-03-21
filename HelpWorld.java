import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
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
        addObject(new Display("Help",60,Color.LIGHT_GRAY),getWidth() / 2, 25);
        addObject(new Display("Here you are:",40,Color.LIGHT_GRAY),105,95);
        addObject(new Display(new GreenfootImage("playerShip.png")), 243,95);
        addObject(new Display("And here is player 2:",40,Color.LIGHT_GRAY),444,95);
        addObject(new Display(new GreenfootImage("player2Ship.png")),638,95);
    }
}
