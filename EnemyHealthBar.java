import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.lang.*;
/**
 * Write a description of class EnemyHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealthBar extends Actor
{
    private int health = 100;
    public EnemyHealthBar()
    {
    }

    protected void addedToWorld(World w)
    {
        updateHealthBar(0);        
    }
    
     public int updateHealthBar(int healthChange)
    {
        health = health - healthChange;  // Note: you can add health by passing in a negative change
        if( health <= 0 )
        {
            return 0;  // Let's caller know we died
        } else if( health > 100 )
        {
            health = 100;  // can't have more than the max health
        }
        
        // Redraw health bar to match current health
        GreenfootImage hb = new GreenfootImage(health, 20);
        hb.setColor(Color.GREEN);
        hb.fill();
        setImage(hb);
        setLocation(getImage().getWidth()/2 + 40, getY());
        
        return health;
    }
}
