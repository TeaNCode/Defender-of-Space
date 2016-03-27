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
        
        if(getOneIntersectingObject(GoodShip.class) != null)
            {
            getWorld().removeObject(this);
            switch(typeDecide)
                {
                case "Attack": attackSpeed(); break;
                case "Score": score(); break;
                case "Sheild": shield(); break;
                case "Penetrate": plasmaPenetrate(); break;
                case "Mystery": mysteryBox(); break;
                case "Burst": burst(); break;
                case "Movement": movementSpeed(); break;
                case "Life": extraLife(); break;
            }
        }
        else if(getY() == 799)
            {
            getWorld().removeObject(this);
        }
    }    
    
    public void attackSpeed(){
        
    }
    
    public void score(){
        
    }
    
    public void shield(){
        
    }
    
    public void plasmaPenetrate(){
        
    }
    
    public void mysteryBox(){
        
    }
    
    public void extraLife(){
        
    }
    
    public void burst(){
        
    }
    
    public void movementSpeed(){
        
    }
    
}