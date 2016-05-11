import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.io.File;
/**
 * The opening menu. Allows the user to start a new game or load a previous game.
 * 
 * @Tea N' Code
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
        //Initialize variables so no nulls are reached
        DevConsole.initialize();
        Save.initialize();
        HubWorld.warned = false;
        HubWorld.random = null;

        addObject(new Button("newgame"), getWidth() / 2, 550);
        File save = new File("Save.sav");
        if(save.exists() && save.canRead())
        addObject(new Button("continuegame"), getWidth() / 2, 450);
        addObject(new Display(new GreenfootImage("TeaNCode.png")), 301, 127);
        addObject(new Button("help",this), getWidth() / 2, 650);
        addObject(new Display("Defender of Space",100,Color.LIGHT_GRAY),getWidth() / 2,300);
        Greenfoot.start();
    }
    
    /**
     * Opens the command console when the user presses '~'
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
