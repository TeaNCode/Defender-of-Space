import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * The World that the main game takes place in
 * 
 * @Tea N' Code
 */
public class SpaceWorld extends World
{
    //Stores the player's lives
    public ArrayList<Life> lives = new ArrayList<Life>();
    public ArrayList<Life> lives2 = new ArrayList<Life>();
    //Stores the waves for the level
    private Wave[] waves;
    //Which wave we're on
    private int waveNumber;
    //Whether or not the summary is being shown
    public boolean showingSummary;
    //Holds the players
    private PlayerShip player1;
    private Player2Ship player2;
    //If the player is doing an endless run
    public boolean endless;
    public SpaceWorld(int players, boolean endless, Wave[] waves)
    {
        super(1000, 800, 1);
        setBackground("space1.jpg");
        this.endless = endless;
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
            //Adds info for player 2 and stuff
            addObject(player1,400,750);
            player2 = new Player2Ship(this);
            addObject(new Score(player2), 886, 60);
            addObject(new Display("Player 2",20,Color.WHITE,new Color(0,0,0,0)),823,43);
            addObject(player2,600,750);
            addLives2(3);
        }
        addLives(3);
        Greenfoot.setSpeed(50);
    }

    /**
     * Checks if we should load the next level/end the game
     */
    public void levelUp()
    {
        if(!showingSummary)
            if(getObjects(EnemyShip.class).isEmpty())
            {
                if(endless)
                {
                    HubWorld.getRandomLevel(waveNumber,true)[0].spawnWave(this);
                    waveNumber++;
                }
                else
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
            }
            else if(getObjects(GoodShip.class).isEmpty())
            {
                showSummary(false);
                showingSummary = true;
            }
    }

    /**
     * Opens the command console when the player presses '~'
     * Runs the above method
     */
    public void act()
    {
        levelUp();
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }

    /**
     * Gives player 1 additional lives
     */
    public void addLives(int n)
    {
        for(int i = 0; i < n; i++)
            addObject(new Life(this,1),50,800 - 50 * lives.toArray().length);
    }

    /**
     * Gives player 2 additional lives
     */
    public void addLives2(int n)
    {
        for(int i = 0; i < n; i++)
            addObject(new Life(this,2),950,800 - 50 * lives2.toArray().length);
    }

    /**
     * Shows a summary of the player(s)' preformance during the level
     */
    public void showSummary(boolean win)
    {
        removeObjects(getObjects(null));
        setBackground("black.png");

        //show win or loss
        if(win)
        {
            addObject(new Display("Victory",60,Color.GREEN),getWidth() / 2, 100);
            if(Save.level == 5)
                Save.winner = true;
            Save.level++;
        }
        else
            addObject(new Display("Loss",60,Color.RED),getWidth() / 2,100);

        if(endless && player1.enemiesKilled > Save.endlessHighScore)
            Save.endlessHighScore = player1.enemiesKilled;

        //add info
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

    public SpaceWorld regenerate()
    {
        SpaceWorld world = new SpaceWorld(player2 == null ? 1 : 2, endless, waves);
        return world;
    }
}