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
    private String i;
    public Button(String type){
        this.type = type;
        setPicture();
        i = "cup";
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
                case "cup": change(); break;
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
            case "cup": setImage("tecup.png");
        }
    }

    public void change(){
        if(i.equals("cup")){
            setLocation(75, 25);
            setImage(new GreenfootImage("Made by TeaNCode, Copyright 2016", 12, Color.WHITE, new Color(0,0,0,0)));
            i = "info";
        }
        else{
            setLocation(30, 15);
            setImage("tecup.png");
            i = "cup";
        }
    }
    
    public Wave[] getStartingWave()
    {
        ArrayList<SpawnableEntity> array = new ArrayList<SpawnableEntity>();
        for( int Y = 1; Y < 3; Y++)
        {
            for( int X = 1; X < 11; X++)
            {
                array.add(new SpawnableEntity(new EnemyShip2(),250 + (X * 50),150 + (Y * 50), getWorld()));
            }
        }
        for( int Y = 1; Y < 3; Y++)
        {
            for( int X = 1; X < 11; X++)
            {
                array.add(new SpawnableEntity(new EnemyShip1(),250 + (X * 50),50 + (Y * 50), getWorld()));
            }
        }
        array.add(new SpawnableEntity(new EnemyShip3(),500,50, getWorld()));
        array.add(new SpawnableEntity(new EnemyShip3(),550,50, getWorld()));
        array.add(new SpawnableEntity(new EnemyShip3(),600,50, getWorld()));
        array.add(new SpawnableEntity(new EnemyShip3(),450,50, getWorld()));
        
        Wave[] toReturn = {(SpawnableEntity)(array.toArray())};
        return new Wave((SpawnableEntity)(array.toArray()));
    }
}