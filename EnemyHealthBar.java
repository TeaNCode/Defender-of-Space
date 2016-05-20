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
    private int health = 110;
    public GreenfootImage hb = new GreenfootImage(health, 20);
    public EnemyHealthBar()
    {
    }

    protected void addedToWorld(World w)
    {
        updateHealthBar(0);        
    }

    public void updateHealthBar(int healthChange)
    {
        health = health - healthChange;  // Note: you can add health by passing in a negative change
        // Redraw health bar to match current health
        if(health > 0){
            hb.scale(health, 20);
            if (health >= 50)
                hb.setColor(Color.GREEN);
            else if (health < 50 && health > 10)
                hb.setColor(Color.YELLOW);
            else if (health <= 10 && health > 0)
                hb.setColor(Color.RED);

            hb.fill();
            setImage(hb);     
            setLocation(getImage().getWidth()/2 + 40, getY());
        }
        else
            getWorld().removeObject(this);

    }
}
