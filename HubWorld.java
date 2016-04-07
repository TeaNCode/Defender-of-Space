import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
        addObject(new Button("world",new SpaceWorld(1,getLevel(1)),new GreenfootImage("\n\nFly solo",50,Color.WHITE,Color.BLACK)),200,200);
        addObject(new Button("world",new SpaceWorld(2,getLevel(1)),new GreenfootImage("\n\nTeamwork makes the dreamwork",50,Color.WHITE,Color.BLACK)),434,376);
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
        else
        {
            JOptionPane.showMessageDialog(null,"You have requested a level that hasn't been coded yet.","Game over man, game over.",JOptionPane.WARNING_MESSAGE);
        }
        
        return waves.toArray(blahW);
    }
}
