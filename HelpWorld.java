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
        addObject(new Display("Your objective is to kill the enemies:",40,Color.LIGHT_GRAY),275,153);
        addObject(new Display(new GreenfootImage("enemyShip1.png")),575,156);
        addObject(new Display(new GreenfootImage("enemyShip2.png")),625,156);
        addObject(new Display(new GreenfootImage("enemyShip3.png")),675,154);
        addObject(new Display("Player 1 shoots with the up arrow key and strafes with the left and",40,Color.LIGHT_GRAY),494,197);
        addObject(new Display("right arrow keys. Player 2 uses w, a, and d.",40,Color.LIGHT_GRAY),327,243);
    }
}
