import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 * Write a description of class HubWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HubWorld extends World
{
    /**
     * Constructor for objects of class HubWorld.
     * 
     */
    public HubWorld(boolean load)
    {    
        // Needs a coolio background image
        super(1000, 800, 1);
        Wave[] level = getLevel(Save.level);
        addObject(new Button("world",new SpaceWorld(1,level),new GreenfootImage("\n\nFly solo",50,Color.WHITE,Color.BLACK)),200,200);
        addObject(new Button("world",new SpaceWorld(2,level),new GreenfootImage("\n\nTeamwork makes the dreamwork",50,Color.WHITE,Color.BLACK)),434,376);
    }

    public Wave[] getLevel(int level)
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
            wave1.add(new SpawnableEntity(new EnemyShip3(),500,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),550,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),600,50));
            wave1.add(new SpawnableEntity(new EnemyShip3(),450,50));
            
            
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
        else
        {
            ArrayList<SpawnableEntity> wave1 = new ArrayList<SpawnableEntity>();
            JOptionPane.showMessageDialog(null,"The next level will be a random level because you have requested a level that hasn't been coded yet.","Game over man, game over.",JOptionPane.WARNING_MESSAGE);
            //String input = JOptionPane.showInputDialog(null,"Enter a seed for the random level or press cancel for a random seed");
            Random random;
            /**if(input != null)
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
            {**/
                random = new Random();
            //}
            
            int times = random.nextInt(31) + 10;
            if(random.nextInt(1000000) == 0)
                times = 100;
            for(int i = 0; i < times; i++)
            {
                int enemyType = random.nextInt(3);
                if(enemyType == 0)
                {
                    wave1.add(new SpawnableEntity(new EnemyShip1(random.nextInt(2) + 1),random.nextInt(701) + 140,random.nextInt(301) + 10));
                }
                else if(enemyType == 1)
                {
                    wave1.add(new SpawnableEntity(new EnemyShip2(random.nextInt(2) + 1),random.nextInt(701) + 140,random.nextInt(301) + 10));
                }
                else
                {
                    wave1.add(new SpawnableEntity(new EnemyShip3(),random.nextInt(701) + 140,random.nextInt(301) + 10));
                }
            }
            
            waves.add(new Wave(wave1.toArray(blahSE)));
        }
        
        return waves.toArray(blahW);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
