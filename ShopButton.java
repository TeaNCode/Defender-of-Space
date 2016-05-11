import greenfoot.*;

/**
 * A version of Button for ShopWorld, to not clutter Button
 * 
 * @author Tea N' Code
 */
public class ShopButton extends Actor
{
    private String type;
    private int cost;
    
    public ShopButton(String type, int cost)
    {
        this.type = type;
        this.cost = cost;
        
        setPicture();
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            
        }
    }
    
    public void setPicture()
    {
        
    }
}
