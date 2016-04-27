import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * creates powerups for the player to increase his ships abilities with for a short time
 * 
 * @AaronCampbell 
 * @3/24/2016-- _/__/____
 */
public class Powerups extends Actor
{
    public String typeDecide;
    
    public Powerups(String typeDecide)
    {
        this.typeDecide = typeDecide;
        setImage(typeDecide + ".png");
    }
    
    public Powerups()
    {
        String[] powers = {"Attack", "Score", "shield", "Penetrate", "Mystery", "Burst", "Movement", "Life"};
        typeDecide = powers[Greenfoot.getRandomNumber(powers.length)];
        setImage(typeDecide + ".png");
    }
    
    public void act() 
    {
        setLocation(getX(), getY() + 1);

        GoodShip interceptor = (GoodShip) (getOneIntersectingObject(GoodShip.class));
        if(interceptor != null)
            {
            switch(typeDecide)
                {
                case "Attack": attackSpeed(interceptor); break;
                case "Score": score(interceptor); break;
                case "shield": shield(interceptor); break;
                case "Penetrate": penetrate(); break;
                case "Mystery": mysteryBox(); break;
                case "Burst": burst(interceptor); break;
                case "Movement": movementSpeed(); break;
                case "Life": extraLife((SpaceWorld)(interceptor.getWorld()),interceptor); break;
            }
            getWorld().removeObject(this);
        }
        else if(getY() == 799)
            {
            getWorld().removeObject(this);
        }
    }    
    
    public void attackSpeed(GoodShip player)
    {
         if (Greenfoot.isKeyDown("UP") || Greenfoot.isKeyDown("w") )
            {
               getWorld().addObject(new PlayerRocket(player),getX(),getY());
               //GoodShip.reloadDelayCount = 30;
               //shots++;
            }
    }
    
    public void score(GoodShip player)
    {
          player.score += 500;
          Save.money += 50;
    }
    
    public void shield(GoodShip player)
    {
          player.shielded = true;
          player.shield = new Shield(player, 1.0);
          getWorld().addObject(player.shield, player.getX(), player.getY());
    }
    
    public void penetrate()
    {
       
    }
    
    public void mysteryBox()
    {
        GoodShip interceptor = (GoodShip) (getOneIntersectingObject(GoodShip.class));
        switch(typeDecide)
                {
                case "Attack": attackSpeed(interceptor); break;
                case "Score": score(interceptor); break;
                case "shield": shield(interceptor); break;
                case "Penetrate": penetrate(); break;
                case "Burst": burst(interceptor); break;
                case "Movement": movementSpeed(); break;
                case "Life": extraLife((SpaceWorld)(interceptor.getWorld()),interceptor); break;
            }
    }
    
    public void extraLife(SpaceWorld world, GoodShip player)
    {
        if(player instanceof PlayerShip)
        world.addLives(1);
        else if(player instanceof Player2Ship)
        world.addLives2(1);
    }
    
    public void burst(GoodShip player)
    {
        if (Greenfoot.isKeyDown("UP") || Greenfoot.isKeyDown("w") )
            {
               getWorld().addObject(new PlayerRocket(player),getX(),getY());
            }
    }
    
    public void movementSpeed()
    {
        
    }
    
}