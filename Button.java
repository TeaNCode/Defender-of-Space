import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
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
                case "single": Greenfoot.setWorld(new SpaceWorld()); break;
                case "title": getWorld().removeObject(this); break;
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
            case "title": setImage("TeaNCode.png"); break;
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
}