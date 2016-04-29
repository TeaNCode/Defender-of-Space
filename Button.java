import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * buttons for clicking on and navigating the worlds(The Bifrost)
 * 
 * @author TeaNCode
 */
public class Button extends Actor
{
    private String type;
    private World world;
    public Button(String type){
        //normal constructor for button(no world declaration)
        this.type = type;
        setPicture();
    }

    public Button(String type, World world)
    {
        //button constructor that lets you choose which world its in
        this(type);
        this.world = world;
    }

    public Button(String type, World world, GreenfootImage image)
    {
        this.type = type;
        this.world = world;
        setImage(image);
    }

    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            //checks for if the mouse clicks a button and which
            switch(type)
            {
                case "teacup": type = "teancodetext"; setPicture(); break;
                case "teancodetext": type = "teacup"; setPicture(); break;
                case "world": Greenfoot.setWorld(world); break;
                case "back": Greenfoot.setWorld(world); break;
                case "help": Greenfoot.setWorld(new HelpWorld(world)); break;
                case "newgame": Greenfoot.setWorld(new HubWorld(false)); break;
                case "continuegame": Greenfoot.setWorld(new HubWorld(true)); break;
                case "save": Save.saveWarn(Save.prepareString(),"Save.sav"); break;
            }
        }
    }    

    public void setPicture()
    {
        //sets pictures of buttons
        switch(type)
        {
            case "teacup": setImage(new GreenfootImage("tecup.png")); setLocation(25, 15); break;
            case "teancodetext": setImage(new GreenfootImage("Made by TeaNCode, Copyright 2016", 12, Color.WHITE, new Color(0,0,0,0))); 
            setLocation(87, 25);break;
            case "world": setImage(new GreenfootImage("Continue", 60, Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "back": setImage(new GreenfootImage("Back",30,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "help": setImage(new GreenfootImage("Help",40,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "newgame": setImage(new GreenfootImage("New Game",40,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "continuegame": setImage(new GreenfootImage("Continue Game",40,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "save": setImage(new GreenfootImage("Save Game",40,Color.BLACK, new Color(0,0,0,0))); break;
        }
    }
}