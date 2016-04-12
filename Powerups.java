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
    SpaceWorld world;
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
        
        if(getOneIntersectingObject(GoodShip.class) != null)
            {
            getWorld().removeObject(this);
            switch(typeDecide)
                {
                case "Attack": attackSpeed(world); break;
                case "Score": score(world); break;
                case "Sheild": shield(world); break;
                case "Penetrate": plasmaPenetrate(world); break;
                case "Mystery": mysteryBox(world); break;
                case "Burst": burst(world); break;
                case "Movement": movementSpeed(world); break;
                case "Life": extraLife(world); break;
            }
        }
        else if(getY() == 799)
            {
            getWorld().removeObject(this);
        }
    }    
    
    public void attackSpeed(SpaceWorld world)
    {
        
    }
    
    public void score(SpaceWorld world)
    {
        
    }
    
    public void shield(SpaceWorld world)
    {
        
    }
    
    public void plasmaPenetrate(SpaceWorld world)
    {
        
    }
    
    public void mysteryBox(SpaceWorld world)
    {
        
    }
    
    public void extraLife(SpaceWorld world)
    {
        world.addLives(1);
    }
    
    public void burst(SpaceWorld world)
    {
        
    }
    
    public void movementSpeed(SpaceWorld world)
    {
        
    }
    
}