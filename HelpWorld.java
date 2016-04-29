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
        addObject(new Display("Player 1 shoots with the w key and strafes with the a and d keys.",40,Color.LIGHT_GRAY),489,197);
        addObject(new Display("Player 2 uses the up, left, and right arrow keys. Your goal is to",40,Color.LIGHT_GRAY),469,243);
        addObject(new Display("defeat the invading alien menace. The world is depending on you.",40,Color.LIGHT_GRAY),494,285);
        addObject(new Display("Do not fail us.",40,Color.LIGHT_GRAY),115,325);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
