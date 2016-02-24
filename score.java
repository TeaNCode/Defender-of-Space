import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class score extends Actor
{
    static int enemysKilled;
    public score()
    {
        enemysKilled = 0;
        setImage(new GreenfootImage("Score: " + enemyShip3.score + " Enemies Killed: " + enemysKilled, 20, Color.WHITE, Color.BLACK));
    }

    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //displays the score board
        setImage(new GreenfootImage("Score: " + enemyShip3.score + " Enemies Killed: " + enemysKilled, 20, Color.WHITE, Color.BLACK));
        if(enemysKilled == 44)
        {
            //displays "you win" and "next level"
            setLocation(500,450);
            setImage(new GreenfootImage("You Win!", 50, Color.YELLOW, Color.BLACK));
            Greenfoot.delay(10);

            setImage(new GreenfootImage("Next Level!", 50, Color.YELLOW, Color.BLACK));
            setLocation(100, 60);
            Greenfoot.delay(50);
        }
    }    
}
