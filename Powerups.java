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
    }
    
    public Powerups()
    {
        String[] powers = {"Attack", "Score", "Shield", "Penetrate", "Mystery", "Burst", "Movement", "Life"};
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
                case "Shield": shield(interceptor); break;
                case "Penetrate": penetrate(interceptor); break;
                case "Mystery": mysteryBox(); break;
                case "Burst": burst(interceptor); break;
                case "Movement": movementSpeed(interceptor); break;
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
          //int time = 100;
          //if(time != 0){
          //    time--;
          //    player.gunReloadTime = 35;
         //   }
         // else if(time == 0){
         //     player.gunReloadTime = 65;
         //  }
         player.attackSpeed = true;
    }
    
    public void score(GoodShip player)
    {
          player.score+= 500;
    }
    
    public void shield(GoodShip player)
    {
          player.shielded = true;
          getWorld().addObject(new Shield(player, 1.0), player.getX(), player.getY());
    }
    
    public void penetrate(GoodShip player)
    {
        //player.
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
        if(player instanceof PlayerShip)
        world.addLives(1);
        else if(player instanceof Player2Ship)
        world.addLives2(1);
    }
    
    public void burst(GoodShip player)
    {
        getWorld().addObject(new PlayerRocket(player),getX(),getY());
    }
    
    public void movementSpeed(GoodShip player)
    {
        player.speed = 7;
    }
    
}