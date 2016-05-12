import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class EnemyHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealthBar extends Actor
{
    public int barWidth;
    public int barHeight;
    public int scale;
    public EnemyHealthBar(int scale)
    {
        barWidth = 100 * scale;
        barHeight = 10;
    }

    /**
     * Act - do whatever the EnemyHealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void draw(EnemyBoss owner)
    {

    }
}
