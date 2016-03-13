import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    public Life(SpaceWorld world, int n)
    {
        setImage("heart.png");
        if(n == 1)
        world.lives.add(this);
        else if(n == 2)
        world.lives2.add(this);
    }
}
