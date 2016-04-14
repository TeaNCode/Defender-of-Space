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
        turn(270);
    }
    
    public Powerups()
    {
        String[] powers = {"Attack", "Score", "Shield", "Penetrate", "Mystery", "Burst", "Movement", "Life"};
        typeDecide = powers[Greenfoot.getRandomNumber(powers.length)];
        turn(270);
    }
    
    public void act() 
    {
        move(-1);
        
        GoodShip interceptor = (GoodShip) (getOneIntersectingObject(GoodShip.class));
        if(interceptor != null)
            {
            getWorld().removeObject(this);
            switch(typeDecide)
                {
                case "Attack": attackSpeed(); break;
                case "Score": score(interceptor); break;
                case "Sheild": shield(interceptor); break;
                case "Penetrate": plasmaPenetrate(); break;
                case "Mystery": mysteryBox(); break;
                case "Burst": burst(); break;
                case "Movement": movementSpeed(); break;
                case "Life": extraLife((SpaceWorld)(interceptor.getWorld()),interceptor); break;
            }
        }
        else if(getY() == 799)
            {
            getWorld().removeObject(this);
        }
    }    
    
    public void attackSpeed()
    {
         
    }
    
    public void score(GoodShip player)
    {
         player.score+= 500;
    }
    
    public void shield(GoodShip player)
    {
       player.shielded = true;
       getWorld().addObject(new Display("shield.png"), player.getX(), player.getY());
    }
    
    public void plasmaPenetrate()
    {
       //maybe depending on if we do the plasma class
    }
    
    public void mysteryBox()
    {
       
    }
    
    public void extraLife(SpaceWorld world, GoodShip player)
    {
        if(player instanceof PlayerShip)
        world.addLives(1);
        else if(player instanceof Player2Ship)
        world.addLives2(1);
    }
    
    public void burst()
    {
        
    }
    
    public void movementSpeed()
    {
        
    }
    
}