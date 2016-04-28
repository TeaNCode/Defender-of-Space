import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MoneyCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoneyCounter extends Actor
{
    private int money;
    
    public MoneyCounter()
    {
        draw();
    }
    
    /**
     * Act - do whatever the MoneyCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Save.money != money)
        {
            money = Save.money;
            draw();
        }
    }    
    
    public void draw()
    {
        setImage(new GreenfootImage("Cash money: " + String.valueOf(money),40,new Color(218,165,32),new Color(0,0,0,0)));
    }
}
