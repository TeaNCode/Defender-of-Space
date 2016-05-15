import greenfoot.*;
import java.awt.Color;
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
            //If they can buy it and don't already have it
            if(Save.money > cost && !Save.inventory.contains(type) && !Utilities.arrayContains(Save.activeItems,type))
            {
                Save.money -= cost;
                Save.inventory.add(type);
            }
        }
    }
    
    public void setPicture()
    {
        if(type.startsWith("AttackSpeed"))
        {
            String number = type.substring(11,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("AttackSpeed " + number + "\nCost: " + String.valueOf(cost),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type.startsWith("Movement"))
        {
            String number = type.substring(8,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("Movement " + number + "\nCost: " + String.valueOf(cost),30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type.startsWith("BossBonus"))
        {
            String number = type.substring(9,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("BossBonus " + number + "\nCost: " + String.valueOf(cost),30,Color.BLACK,new Color(0,0,0,0)));
        }
    }
}
