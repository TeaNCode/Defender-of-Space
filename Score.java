import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * class counting and displaying score
 * 
 * @TeaNCode
 */
public class Score extends Actor
{
    private GoodShip owner;
    public Score(GoodShip owner)
    {
        //displays score and enemies killed
        this.owner = owner;
        setImage(new GreenfootImage("Score: " + owner.score + " Enemies Killed: " + owner.enemiesKilled, 20, Color.WHITE, new Color(0,0,0,0)));
    }

    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //changes the score board
        setImage(new GreenfootImage("Score: " + owner.score + " Enemies Killed: " + owner.enemiesKilled, 20, Color.WHITE, new Color(0,0,0,0)));
    }    
}