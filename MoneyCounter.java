import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * counter for the amount of money you have
 * 
 * @author TeaNCode
 */
public class MoneyCounter extends Actor
{
    private int money;
    
    public MoneyCounter()
    {
        //constructor that draws initial image
        money = Save.money;
        draw();
    }
    
    /**
     * Act - do whatever the MoneyCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //saves and updates money
        if(Save.money != money)
        {
            money = Save.money;
            draw();
        }
    }    
    
    public void draw()
    {
        //draws money counter
        setImage(new GreenfootImage("Cash money: " + String.valueOf(money),40,new Color(218,165,32),new Color(0,0,0,0)));
    }
}
