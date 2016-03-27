import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String type;
    private World world;
    public Button(String type){
        this.type = type;
        setPicture();
    }
    
    public Button(String type, World world)
    {
        this(type);
        this.world = world;
    }

    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            switch(type)
            {
                case "single": Greenfoot.setWorld(new SpaceWorld(1, getStartingWave())); break;
                case "multi": Greenfoot.setWorld(new SpaceWorld(2, getStartingWave())); break;
                case "teacup": type = "teancodetext"; setPicture(); break;
                case "teancodetext": type = "teacup"; setPicture(); break;
                case "continue": Greenfoot.setWorld(world); break;
                case "back": Greenfoot.setWorld(world); break;
                case "help": Greenfoot.setWorld(new HelpWorld(world)); break;
            }
        }
    }    

    public void setPicture()
    {
        switch(type)
        {
            case "single": setImage(new GreenfootImage("Single Player",40,Color.LIGHT_GRAY,
                    new Color(0,0,0,0))); break;
            case "multi": ; setImage(new GreenfootImage("Multi-Player",40,Color.LIGHT_GRAY,
                    new Color(0,0,0,0))); break;
            case "teacup": setImage(new GreenfootImage("tecup.png")); setLocation(25, 15); break;
            case "teancodetext": setImage(new GreenfootImage("Made by TeaNCode, Copyright 2016", 12, Color.WHITE, new Color(0,0,0,0))); 
            setLocation(87, 25);break;
            case "continue": setImage(new GreenfootImage("Continue", 60, Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "back": setImage(new GreenfootImage("Back",30,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
            case "help": setImage(new GreenfootImage("Help",40,Color.LIGHT_GRAY, new Color(0,0,0,0))); break;
        }
    }
    
    static Wave[] getStartingWave()
    {
        ArrayList<SpawnableEntity> array = new ArrayList<SpawnableEntity>();
        for( int Y = 1; Y < 3; Y++)
        {
            for( int X = 1; X < 11; X++)
            {
                array.add(new SpawnableEntity(new EnemyShip1(),250 + (X * 50),150 + (Y * 50)));
            }
        }
        for( int Y = 1; Y < 3; Y++)
        {
            for( int X = 1; X < 11; X++)
            {
                array.add(new SpawnableEntity(new EnemyShip2(),250 + (X * 50),50 + (Y * 50)));
            }
        }
        array.add(new SpawnableEntity(new EnemyShip3(),500,50));
        array.add(new SpawnableEntity(new EnemyShip3(),550,50));
        array.add(new SpawnableEntity(new EnemyShip3(),600,50));
        array.add(new SpawnableEntity(new EnemyShip3(),450,50));
        
        SpawnableEntity[] blah = {new SpawnableEntity(new EnemyShip3(),450,50)};
        Wave[] toReturn = {new Wave(array.toArray(blah))};
        return toReturn;
    }
}