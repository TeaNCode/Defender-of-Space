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
    public Powerups(String typeDecide)
    {
        //a construct for testing that lets you decide the powerup picked
        this.typeDecide = typeDecide;
        setImage(typeDecide + ".png");
    }

    public Powerups()
    {
        //a constructor used by the enemies to generate a random powerup
        String[] powers = {"Attack", "Score", "Shield", "Penetrate", "Mystery","Burst", "Movement", "Life"};
        typeDecide = powers[Greenfoot.getRandomNumber(powers.length)];
        
        //Gives the possibility of a rare, powerful powerup
        if(Greenfoot.getRandomNumber(9999) + 1 == 1){
            typeDecide = "MegaMystery";
        }
        
        setImage(typeDecide + ".png");
    }

    public Powerups(boolean mystery)
    {
        //a constructor used by the enemies to generate a random powerup that cannot be a mystery box
        String[] powers = {"Attack", "Score", "Shield", "Penetrate", "Burst", "Movement", "Life"};
        typeDecide = powers[Greenfoot.getRandomNumber(powers.length)];
        setImage(typeDecide + ".png");
    }

    public void act() 
    {
        //move down screen
        setLocation(getX(), getY() + 1);
        //if caught reads the pick and runs the code
        GoodShip interceptor = (GoodShip) (getOneIntersectingObject(GoodShip.class));
        if(interceptor != null)
        {
            switch(typeDecide)
            {
                case "Attack": attackSpeed(interceptor); break;
                case "Score": score(interceptor); break;
                case "Shield": shield(interceptor); break;
                case "Penetrate": penetrate(interceptor); break;
                case "Mystery": mysteryBox(interceptor); break;
                case "MegaMystery": megaMysteryBox(interceptor); break;
                case "Burst": burst(interceptor); break;
                case "Movement": movementSpeed(interceptor); break;
                case "Life": extraLife((SpaceWorld)(interceptor.getWorld()),interceptor); break;
            }
            getWorld().removeObject(this);
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
        player.attackBoostedTime += 350;
        if(player.attackBoostedTime == 350)
        player.gunReloadTime -= 20;
    }

    public void score(GoodShip player)
    {
        //increases score
        player.score+= 500;
    }

    public void shield(GoodShip player)
    {
        //shields player
        if(!player.shielded)
        {
            player.shielded = true;
            player.shield = new Shield(player, 1.38);
            getWorld().addObject(player.shield, player.getX(), player.getY());
        }
    }

    public void penetrate(GoodShip player)
    {
        //makes bullets penetrate
        player.penetrate = true;
        player.penShots += 2;
    }

    public void mysteryBox(GoodShip player)
    {
        //runs mystery choosing a random powerup to give the player
        getWorld().addObject(new Powerups(true), player.getX(), player.getY() - 75);
    }

    public void megaMysteryBox(GoodShip player)
    {
        //runs Megamystery choosing 5 random powerups to give the player
        getWorld().addObject(new Powerups(true), player.getX(), player.getY() - 75);
        getWorld().addObject(new Powerups(true), player.getX(), player.getY() - 175);
        getWorld().addObject(new Powerups(true), player.getX(), player.getY() - 275);
        getWorld().addObject(new Powerups(true), player.getX(), player.getY() - 375);
        getWorld().addObject(new Powerups(true), player.getX(), player.getY() - 475);
    }

    public void mysteryBox()
    {
        GoodShip interceptor = (GoodShip) (getOneIntersectingObject(GoodShip.class));
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
        player.burstShots += 3;
    }

    public void movementSpeed(GoodShip player)
    {
        //increases player movement speed
        player.speed += 2;
        player.movementCount++;
    }

}