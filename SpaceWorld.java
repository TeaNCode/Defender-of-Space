import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class spaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorld extends World
{
    public ArrayList<Life> lives = new ArrayList<Life>();
    /**
     * Constructor for objects of class spaceWorld.
     * 
     */
    public SpaceWorld()
    {    
        // Create a new world with 1000x900 cells with a cell size of 1x1 pixels.
        super(1000, 900, 1); 
        //populate the world
        DevConsole.initialize();
        populate();
        addObject(new Button("cup"), 25, 15);
        addObject(new Score(), 100, 60);
        addObject(new PlayerShip(this),500,800);
        addLives(3);
        Greenfoot.setSpeed(50);
    }

    public void populate()
    {
        for( int Y = 1; Y < 3; Y++)
        {
            for( int X = 1; X < 11; X++)
            {
                addObject(new EnemyShip2(),250 + (X * 50),150 + (Y * 50));
            }
        }
        for( int Y = 1; Y < 3; Y++)
        {
            for( int X = 1; X < 11; X++)
            {
                addObject(new EnemyShip1(),250 + (X * 50),50 + (Y * 50));
            }
        }
        addObject(new EnemyShip3(),500,50);
        addObject(new EnemyShip3(),550,50);
        addObject(new EnemyShip3(),600,50);
        addObject(new EnemyShip3(),450,50);
    }

    public void levelUp()
    {
        //brings you to the next level
        if(Score.enemysKilled == 44)
        {
            //  Score.enemysKilled = 0;
            for( int Y = 1; Y < 3; Y++)
            {
                for( int X = 1; X < 11; X++)
                {
                    addObject(new EnemyShip2(),250 + (X * 50),150 + (Y * 50));
                }
            }
            for( int Y = 1; Y < 3; Y++)
            {
                for( int X = 1; X < 11; X++)
                {
                    addObject(new EnemyShip1(),250 + (X * 50),50 + (Y * 50));
                }
            }
        }
        //probably need to create seperate worlds for diffrent levels
    }

    public void act()
    {
        //levelUp();
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }

    public void addLives(int n)
    {
        for(int i = 0; i < n; i++)
            addObject(new Life(this),950,800 - 50 * lives.toArray().length);
    }
}