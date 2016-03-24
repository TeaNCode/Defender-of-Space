import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private GoodShip owner;
    public Score(GoodShip owner)
    {
        this.owner = owner;
        setImage(new GreenfootImage("Score: " + owner.score + " Enemies Killed: " + owner.enemiesKilled, 20, Color.WHITE, new Color(0,0,0,0)));
    }

    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //displays the score board
        setImage(new GreenfootImage("Score: " + owner.score + " Enemies Killed: " + owner.enemiesKilled, 20, Color.WHITE, new Color(0,0,0,0)));
    }    
}