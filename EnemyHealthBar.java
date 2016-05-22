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
    private double currentHealth;
    private double maxHealth;
    private double healthPercent;
    public GreenfootImage hb;
    public EnemyHealthBar(int currentHealth, int maxHealth)
    {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        healthPercent = currentHealth / maxHealth;
        hb = new GreenfootImage((int)healthPercent * 100, 20);
    }

    protected void addedToWorld(World w)
    {
        updateHealthBar(0);        
    }

    public void updateHealthBar(int healthChange)
    {
        currentHealth += healthChange;  // Note: you can add health by passing in a positive change
        healthPercent = currentHealth / maxHealth;
        // Redraw health bar to match current health
        if(healthPercent > 0)
        {
            hb.scale((int)(healthPercent * 100), 20);
            if (healthPercent >= .3)
                hb.setColor(Color.GREEN);
            else if (healthPercent < .3 && healthPercent > .1)
                hb.setColor(Color.YELLOW);
            else if (healthPercent <= .1)
                hb.setColor(Color.RED);

            hb.fill();
            setImage(hb);     
            setLocation(getImage().getWidth()/2 + 40, getY());
        }
        else
            getWorld().removeObject(this);
    }
}
