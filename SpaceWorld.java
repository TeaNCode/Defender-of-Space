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
    private Wave[] waves;
    private int waveNumber;
    public boolean showingSummary;
    private PlayerShip player1;
    private Player2Ship player2;
    public SpaceWorld(int players, Wave[] waves)
    {
        super(1000, 800, 1);
        setBackground("space1.jpg");
        this.waves = waves;
        waves[0].spawnWave(this);
        waveNumber = 1;
        showingSummary = false;
        addObject(new Button("teacup"), 25, 15);
        player1 = new PlayerShip(this);
        addObject(new Score(player1), 126, 60);
        addObject(new Display("Player 1",20,Color.WHITE,new Color(0,0,0,0)),64,43);
        if(players == 1)
        {
            addObject(player1,500,750);
        }
        else
        {
            addObject(player1,400,750);
            player2 = new Player2Ship(this);
            addObject(new Score(player2), 886, 60);
            addObject(new Display("Player 2",20,Color.WHITE,new Color(0,0,0,0)),823,43);
            addObject(player2,600,750);
            addLives2(3);
        }
        addLives(3);
        //Greenfoot.setSpeed(50);
    }

    public void levelUp()
    {
        if(getObjects(EnemyShip.class).isEmpty())
        {
            if(waveNumber <= waves.length - 1)
            {
                waves[waveNumber].spawnWave(this);
                waveNumber++;
            }
            else
            {
                if(!showingSummary)
                {
                    showSummary(true);
                    showingSummary = true;
                }
            }
        }
        else if(getObjects(GoodShip.class).isEmpty())
        {
            showSummary(false);
            showingSummary = true;
        }
    }

    public void act()
    {
        levelUp();
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }

    public void addLives(int n)
    {
        for(int i = 0; i < n; i++)
            addObject(new Life(this,1),50,800 - 50 * lives.toArray().length);
    }

    public void addLives2(int n)
    {
        for(int i = 0; i < n; i++)
            addObject(new Life(this,2),950,800 - 50 * lives2.toArray().length);
    }

    public void showSummary(boolean win)
    {
        removeObjects(getObjects(null));
        setBackground("black.png");

        if(win)
        {
            addObject(new Display("Victory",60,Color.GREEN),getWidth() / 2, 100);
            Save.level++;
        }
        else
            addObject(new Display("Loss",60,Color.RED),getWidth() / 2,100);
        if(player2 == null)
        {
            addObject(new Display("Player 1",50,Color.LIGHT_GRAY), getWidth() / 2, 200);
            addObject(new Display("Score: " + String.valueOf(player1.score),40,Color.LIGHT_GRAY), getWidth() / 2, 300);
            addObject(new Display("Kills: " + String.valueOf(player1.enemiesKilled),40,Color.LIGHT_GRAY), getWidth() / 2, 400);
            addObject(new Display("Accuracy: " + String.valueOf(Math.round((((double)(player1.shots) 
                                    - player1.misses) / player1.shots) * 100.0)) + "% (" + String.valueOf(player1.shots - player1.misses) + " / "
                    + String.valueOf(player1.shots) + ")",40,Color.LIGHT_GRAY), getWidth() / 2, 500);

            addObject(new Button("world", new HubWorld(false),new GreenfootImage("Continue",60,Color.LIGHT_GRAY,new Color(0,0,0,0))), getWidth() / 2, 700);
        }
        else
        {
            addObject(new Display("Player 1",50,Color.LIGHT_GRAY), getWidth() / 2 - 100, 200);
            addObject(new Display("Score: " + String.valueOf(player1.score),40,Color.LIGHT_GRAY), getWidth() / 2 - 100, 300);
            addObject(new Display("Kills: " + String.valueOf(player1.enemiesKilled),40,Color.LIGHT_GRAY), getWidth() / 2 - 100, 400);
            addObject(new Display("Accuracy: " + String.valueOf(Math.round((((double)(player1.shots) 
                                    - player1.misses) / player1.shots) * 100.0)) + "% (" + String.valueOf(player1.shots - player1.misses) + " / "
                    + String.valueOf(player1.shots) + ")",40,Color.LIGHT_GRAY), getWidth() / 2 - 200, 500);

            addObject(new Display("Player 2",50,Color.LIGHT_GRAY), getWidth() / 2 + 100, 200);
            addObject(new Display("Score: " + String.valueOf(player2.score),40,Color.LIGHT_GRAY), getWidth() / 2 + 100, 300);
            addObject(new Display("Kills: " + String.valueOf(player2.enemiesKilled),40,Color.LIGHT_GRAY), getWidth() / 2 + 100, 400);
            addObject(new Display("Accuracy: " + String.valueOf(Math.round((((double)(player2.shots) 
                                    - player2.misses) / player2.shots) * 100.0)) + "% (" + String.valueOf(player2.shots - player2.misses) + " / "
                    + String.valueOf(player2.shots) + ")",40,Color.LIGHT_GRAY), getWidth() / 2 + 200, 500);

            addObject(new Button("world", new HubWorld(false),new GreenfootImage("Continue",60,Color.LIGHT_GRAY,new Color(0,0,0,0))), getWidth() / 2, 700);
        }
    }
}