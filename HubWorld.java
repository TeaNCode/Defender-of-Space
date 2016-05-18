import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 * The Hub of activities. Allows the user to begin the level with our without a partner. Also allows them to save or go to the shop
 * 
 * @Tea N' Code
 */
public class HubWorld extends World
{
    static boolean warned;
    static Random random;

    /**
     * Constructor for objects of class HubWorld.
     * 
     */
    public HubWorld(boolean load)
    {    
        // Needs a coolio background image
        super(1000, 800, 1);
        //Whether or not to load from a save
        if(load)
            Save.loadSave("Save.sav");
        addObject(new Button("world",new SpaceWorld(1,getLevel(Save.level)),new GreenfootImage("\n\nFly solo",50,Color.WHITE,Color.BLACK)),200,200);
        addObject(new Button("world",new SpaceWorld(2,getLevel(Save.level)),new GreenfootImage("\n\nTeamwork makes the dreamwork",50,Color.WHITE,Color.BLACK)),434,376);
        addObject(new Button("world",new ShopWorld(this),new GreenfootImage("\n\nShop",50,Color.WHITE,Color.BLACK)),634,200);
        addObject(new Button("world",new SpaceWorld(1,true),new GreenfootImage("\n\nTrek through heck",50,Color.WHITE,Color.BLACK)),574,549);
        addObject(new Display("High Score (kills): " + String.valueOf(Save.endlessHighScore),40,Color.BLACK,new Color(0,0,0,0)),545,654);
        addObject(new Button("save"), 206,574);
        addObject(new Display("Current level: " + String.valueOf(Save.level),40,Color.BLACK,new Color(0,0,0,0)),233,626);
        addObject(new MoneyCounter(),229, 663);
    }

    /**
     * Returns the wave that corresponds to the player's current level
     */
    public static Wave[] getLevel(int level)
    {
        ArrayList<Wave> waves = new ArrayList<Wave>();
        SpawnableEntity[] blahSE = {new SpawnableEntity(new EnemyShip3(),450,50)};
        Wave[] blahW = {new Wave(blahSE)};

        if(level == 1)
        {
            ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();
            for( int Y = 1; Y < 3; Y++)
            {
                for( int X = 1; X < 11; X++)
                {
                    wave1.add(new SpawnableEntity(new EnemyShip1(1),250 + (X * 50),150 + (Y * 50)));
                }
            }
            for( int Y = 1; Y < 3; Y++)
            {
                for( int X = 1; X < 11; X++)
                {
                    wave1.add(new SpawnableEntity(new EnemyShip2(2),250 + (X * 50),50 + (Y * 50)));
                }
            }
            wave1.add(new SpawnableEntity(new EnemyShip3(),450,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),500,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),550,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),600,50));

            waves.add(new Wave(wave1.toArray(blahSE)));
        }
        else if(level == 2)
        {
            ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();
            ArrayList<SpawnableEntity> wave2 = new ArrayList<SpawnableEntity>();

            for( int Y = 1; Y < 3; Y++)
            {
                for( int X = 1; X < 11; X++)
                {
                    wave1.add(new SpawnableEntity(new EnemyShip1(2),250 + (X * 50),50 + (Y * 50)));
                }
            }

            for( int Y = 1; Y < 3; Y++)
            {
                for( int X = 1; X < 11; X++)
                {
                    wave2.add(new SpawnableEntity(new EnemyShip2(2),250 + (X * 50),50 + (Y * 50)));
                }
            }

            waves.add(new Wave(wave1.toArray(blahSE)));
            waves.add(new Wave(wave2.toArray(blahSE)));
        }
        else if(level == 3)
        {
            ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();
            ArrayList<SpawnableEntity> wave2 = new ArrayList<SpawnableEntity>();

            wave1.add(new SpawnableEntity(new EnemyShip4(2),500,50));

            for(int x = 1; x < 11; x++)
            {
                wave2.add(new SpawnableEntity(new EnemyShip4(2),250 + (x * 50),150));
            }
            for(int x = 1; x < 11; x+=2)
            {
                wave2.add(new SpawnableEntity(new EnemyShip1(2),250 + (x * 50),100));
            }
            for(int x = 2; x < 11; x+=2)
            {
                wave2.add(new SpawnableEntity(new EnemyShip2(2),250 + (x * 50),100));
            }

            waves.add(new Wave(wave1.toArray(blahSE)));
            waves.add(new Wave(wave2.toArray(blahSE)));
        }
        else if(level == 4)
        {
            ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();

            wave1.add(new SpawnableEntity(new EnemyShip3(),400,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),450,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),500,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),550,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),600,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),650,50));

            for(int x = 1; x < 11; x+=3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip4(2),250 + (x * 50),100));
            }
            for(int x = 2; x < 11; x+=3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip1(2),250 + (x * 50),100));
            }
            for(int x = 3; x < 11; x+=3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip2(2),250 + (x * 50),100));
            }

            for(int x = 1; x < 11; x+=2)
            {
                wave1.add(new SpawnableEntity(new EnemyShip1(2),250 + (x * 50),150));
            }
            for(int x = 2; x < 11; x+=2)
            {
                wave1.add(new SpawnableEntity(new EnemyShip2(2),250 + (x * 50),150));
            }

            for(int x = 1; x < 11; x+=3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip4(1),250 + (x * 50),200));
            }
            for(int x = 2; x < 11; x+=3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip1(1),250 + (x * 50),200));
            }
            for(int x = 3; x < 11; x+=3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip2(1),250 + (x * 50),200));
            }

            for(int x = 1; x < 11; x+=2)
            {
                wave1.add(new SpawnableEntity(new EnemyShip1(1),250 + (x * 50),250));
            }
            for(int x = 2; x < 11; x+=2)
            {
                wave1.add(new SpawnableEntity(new EnemyShip2(1),250 + (x * 50),250));
            }

            waves.add(new Wave(wave1.toArray(blahSE)));
        }
        else if(level == 5){
            ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();

            wave1.add(new SpawnableEntity(new EnemyBoss1(),500,50));
            wave1.add(new SpawnableEntity(new EnemyHealthBar(1), 500, 100));

            waves.add(new Wave(wave1.toArray(blahSE)));
        }
        else
        {
            return getRandomLevel(level,false);
        }

        return waves.toArray(blahW);
    }

    public static Wave[] getRandomLevel(int level,boolean endless)
    {
        ArrayList<Wave> waves = new ArrayList<Wave>();
        SpawnableEntity[] blahSE = {new SpawnableEntity(new EnemyShip3(),450,50)};
        Wave[] blahW = {new Wave(blahSE)};

        ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();
        if(!warned && !endless)
        {
            warned = true;
            JOptionPane.showMessageDialog(null,"The next level will be a random level because you have requested a level that hasn't been coded yet.","Game over man, game over.",JOptionPane.WARNING_MESSAGE);
        }

        if(random == null)
        {
            if(!Save.winner)
            {
                random = new Random();
            }
            else
            {
                String input = JOptionPane.showInputDialog(null,"Enter a seed for the random level or press cancel for a random seed");
                if(input != null)
                {
                    long seed;
                    try
                    {
                        seed = Long.valueOf(input);
                    }
                    catch(Exception e)
                    {
                        seed = input.hashCode();
                    }
                    random = new Random(seed);
                }
                else
                {
                    random = new Random();
                }
            }
        }

        int times = random.nextInt(30) + 1 + (int)(Math.pow(level,2) / 2);
        for(int i = 0; i < times; i++)
        {
            int enemyType = random.nextInt(4);
            if(enemyType == 0)
            {
                wave1.add(new SpawnableEntity(new EnemyShip1(random.nextInt(2) + 1),random.nextInt(701) + 161,random.nextInt(301) + 10));
            }
            else if(enemyType == 1)
            {
                wave1.add(new SpawnableEntity(new EnemyShip2(random.nextInt(2) + 1),random.nextInt(701) + 161,random.nextInt(301) + 10));
            }
            else if(enemyType == 2)
            {
                wave1.add(new SpawnableEntity(new EnemyShip3(),random.nextInt(701) + 161,random.nextInt(301) + 10));
            }
            else if(enemyType == 3)
            {
                wave1.add(new SpawnableEntity(new EnemyShip4(random.nextInt(2) + 1),random.nextInt(701) + 161,random.nextInt(301) + 10));
            }
        }

        waves.add(new Wave(wave1.toArray(blahSE)));
        return waves.toArray(blahW);
    }

    /**
     * Opens the command console if the player presses '~'
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
