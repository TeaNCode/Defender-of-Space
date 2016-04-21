import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld()
    {    
        super(1000, 800, 1); 
        setBackground("gray.fw.png");
        DevConsole.initialize();
        WebSave.initialize();
        HubWorld.warned = false;

        addObject(new Button("newgame"), getWidth() / 2, 550);
        if(UserInfo.isStorageAvailable())
        addObject(new Button("continuegame"), getWidth() / 2, 450);
        addObject(new Display(new GreenfootImage("TeaNCode.png")), 301, 127);
        addObject(new Button("help",this), getWidth() / 2, 650);
        addObject(new Display("Defender of Space",100,Color.LIGHT_GRAY),getWidth() / 2,300);
        Greenfoot.start();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}