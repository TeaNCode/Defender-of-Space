import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * creates powerups for the player to increase his ships abilities with for a short time
 * 
 * @TeaNCode 
 * @3/24/2016-- 4/28/2016
 */
public class Powerups extends Actor
{
    public String typeDecide;
    public boolean mysteried;
    public Powerups(String typeDecide)
    {
        //a construct for testing that lets you decide the powerup picked
        this.typeDecide = typeDecide;
    }

    public Powerups()
    {
        //a constructor used by the enemies to generate a random powerup
        mysteried = false;
        String[] powers = {"Attack", "Score", "Shield", "Penetrate", "Mystery", "Burst", "Movement", "Life"};
        typeDecide = powers[Greenfoot.getRandomNumber(powers.length)];
        setImage(typeDecide + ".png");
    }

    public void act() 
    {
        //move down screen
        setLocation(getX(), getY() + 1);

        //if caught reads the picak and runs the code
        GoodShip interceptor = (GoodShip) (getOneIntersectingObject(GoodShip.class));
        if(interceptor != null)
        {
            if(mysteried)
            {
                //checked for mystery so you wont roll it again
                switch(typeDecide)
                {
                    case "Attack": attackSpeed(interceptor); break;
                    case "Score": score(interceptor); break;
                    case "Shield": shield(interceptor); break;
                    case "Penetrate": penetrate(interceptor); break;
                    case "Burst": burst(interceptor); break;
                    case "Movement": movementSpeed(interceptor); break;
                    case "Life": extraLife((SpaceWorld)(interceptor.getWorld()),interceptor); break;
                }
                getWorld().removeObject(this);
                mysteried = false;
            }
            else
            {
                switch(typeDecide)
                {
                    case "Attack": attackSpeed(interceptor); break;
                    case "Score": score(interceptor); break;
                    case "Shield": shield(interceptor); break;
                    case "Penetrate": penetrate(interceptor); break;
                    case "Mystery": mysteryBox(interceptor); break;
                    case "Burst": burst(interceptor); break;
                    case "Movement": movementSpeed(interceptor); break;
                    case "Life": extraLife((SpaceWorld)(interceptor.getWorld()),interceptor); break;
                }
                getWorld().removeObject(this);
            }
        }
        else if(getY() == 799)
        {
            //removes if at end of world
            getWorld().removeObject(this);
        }
    }    

    public void attackSpeed(GoodShip player)
    {
        //gives attack speed
        player.attackSpeed = true;
    }

    public void score(GoodShip player)
    {
        //increases score
        player.score+= 500;
    }

    public void shield(GoodShip player)
    {
        //shields player
        player.shielded = true;
        getWorld().addObject(new Shield(player, 1.0), player.getX(), player.getY());
    }

    public void penetrate(GoodShip player)
    {
        //makes bullets penetrate
        player.penetrate = true;
        player.penShots = 0;
    }

    public void mysteryBox(GoodShip player)
    {
        //runs mystery choosing a random powerup to give the player
        getWorld().addObject(new Powerups(), player.getX(), player.getY() - 75);
        mysteried = true;
    }

    public void extraLife(SpaceWorld world, GoodShip player)
    {
        //gives player extra life
        if(player instanceof PlayerShip)
            world.addLives(1);
        else if(player instanceof Player2Ship)
            world.addLives2(1);
    }

    public void burst(GoodShip player)
    {
        //makes next 5 shots be burst shots
        player.burst = true;
        player.burstShots = 0;
    }

    public void movementSpeed(GoodShip player)
    {
        //increases player movement speed
        player.speed = 7;
    }

}