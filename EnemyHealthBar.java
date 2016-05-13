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
    public int barWidth;
    public int barHeight;
    public int scale;
    EnemyBoss boss;
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
        setLocation(boss.getX(), boss.getY() - 50);
    }    

    public void draw(EnemyBoss owner)
    {
        //drawLine(boss.getX() - 50, boss.getY() - 10, boss.getX() + 50, boss.getY() - 15);
    }
}
