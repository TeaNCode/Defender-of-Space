import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * One of the various enemies that you will face
 * 
 * @Tea N' Code
 */
public class EnemyShip1 extends EnemyShip
{
    /**
     * 1 stands for right, anything else stands for left
     */
    public EnemyShip1(int direction)
    {
        setImage("enemyShip1.png");
        this.direction = direction;
        script = "normal";
        end = false;
    }

    /**
     * For comments please inquire within.
     */
    public void act() 
    {
        //Check if the ship should move down
        moveCheck();
        if(script.equals("normal"))
        {
            //Moves the ship
            move();
            //Shoots
            if(Greenfoot.getRandomNumber(3999) + 1 <= 1  * DevConsole.specialMultiplier)
            {
                script = "burst 0";
            }
            else if(Greenfoot.getRandomNumber(1999) + 1 <= 1 * DevConsole.attackMultiplier)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
        }
        else if(script.startsWith("down "))
        {
            //Moves the ship down
            downScript();
        }
        else if(script.startsWith("burst "))
        {
            //Moves the ship
            move();
            //Interprets the script
            Scanner input = new Scanner(script);
            input.next();
            int i = input.nextInt();
            //Shoots
            if(i % 3 == 1)
            {
                getWorld().addObject(new EnemyRocket(90,this), getX(), getY());
            }
            //Increments/resets the script
            if(i == 7)
                script = "normal";
            else
                script = "burst " + String.valueOf(i + 1);
        }

        //Ends the game
        if(end)
        {
            SpaceWorld temp = (SpaceWorld)(getWorld());
            temp.showSummary(false);
            temp.showingSummary = true;
        }
    }    

    //Called when the ship is hit by a Projectile
    public void hit(Projectile hitee)
    {
        if(hitee.owner instanceof GoodShip)
        {
            //Deletes the projectile
            if(!hitee.penetrate)hitee.delete();
            else hitee.penetrate = false;
            //Adds a powerup
            addPowerup();
            //Deletes itself
            getWorld().removeObject(this);
            Save.money += 10;
            //The owner of the projectile that killed this enemy
            GoodShip killer = (GoodShip) (hitee.owner);
            killer.score += 100;
            killer.enemiesKilled++;
        }
    }
}