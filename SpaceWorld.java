import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * Write a description of class spaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorld extends World
{
    public ArrayList<Life> lives = new ArrayList<Life>();
    public ArrayList<Life> lives2 = new ArrayList<Life>();

    public SpaceWorld(int players)
    {
        super(1000, 800, 1);
        setBackground("space1.jpg");
        DevConsole.initialize();
        populate();
        addObject(new Button("cup"), 25, 15);
        PlayerShip player1 = new PlayerShip(this);
        addObject(new Score(player1), 886, 60);
        if(players == 1)
        {
            addObject(player1,500,750);
        }
        else
        {
            addObject(player1,600,750);
            Player2Ship player2 = new Player2Ship(this);
            addObject(new Score(player2), 126, 60);
            addObject(player2,400,750);
            addLives2(3);
        }
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
        /**
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
         */
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
            addObject(new Life(this,1),950,800 - 50 * lives.toArray().length);
    }

    public void addLives2(int n)
    {
        for(int i = 0; i < n; i++)
            addObject(new Life(this,2),50,800 - 50 * lives2.toArray().length);
    }
    
    public void showSummary()
    {
        List<GoodShip> players = getObjects(GoodShip.class);
        removeObjects(getObjects(null));
        setBackground("black.png");
        
        GoodShip player1 = players.get(0);
        GoodShip player2 = new Player2Ship(this);
        boolean players2;
        try
        {
            player2 = players.get(1);
            players2 = true;
        }
        catch(IndexOutOfBoundsException e)
        {
            players2 = false;
        }
        
        addObject(new Display("Summary",60,Color.LIGHT_GRAY),getWidth() / 2, 100);
        if(!players2)
        {
            addObject(new Display("Player 1",50,Color.LIGHT_GRAY), getWidth() / 2, 200);
            addObject(new Display("Score: " + String.valueOf(player1.score),40,Color.LIGHT_GRAY), getWidth() / 2, 300);
            addObject(new Display("Kills: " + String.valueOf(player1.enemiesKilled),40,Color.LIGHT_GRAY), getWidth() / 2, 400);
        }
    }
}