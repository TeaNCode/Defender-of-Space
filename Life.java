import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class to display your lives
 * 
 * @TeaNCode
 */
public class Life extends Actor
{
    public Life(SpaceWorld world, int n)
    {
        //sets image and adds lives
        setImage("heart.png");
        if(n == 1)
        world.lives.add(this);
        else if(n == 2)
        world.lives2.add(this);
    }
}
