import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class InventoryItem here.
 * 
 * @author Tea N' Code
 */
public class InventoryItem extends Actor
{
    private String type;
    private boolean active;
    public InventoryItem(String type, boolean active)
    {
        this.type = type;
        this.active = active;

        setPicture();
    }

    /**
     * Act - do whatever the InventoryItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(!active)
            {
                if(Utilities.arrayContains(Save.activeItems,null))
                {
                    String[] inventory = {"nice b8 m8"};
                    inventory = Save.inventory.toArray(inventory);
                    int[] index = Utilities.arrayFind(inventory,type);
                    Save.inventory.remove(index[0]);
                    int[] options = Utilities.arrayFind(Save.activeItems,null);
                    Save.activeItems[options[0]] = type;
                    InventoryWorld world = (InventoryWorld) getWorld();
                    world.update();
                }
            }
            else
            {
                int[] index = Utilities.arrayFind(Save.activeItems,type);
                Save.activeItems[index[0]] = null;
                Save.inventory.add(type);
                InventoryWorld world = (InventoryWorld) getWorld();
                world.update();
            }
        }
    }    

    public void setPicture()
    {
        if(type.startsWith("AttackSpeed"))
        {
            String number = type.substring(11,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("AttackSpeed " + number,30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type.startsWith("Movement"))
        {
            String number = type.substring(8,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("Movement " + number,30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type.startsWith("BossBonus"))
        {
            String number = type.substring(9,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("BossBonus " + number,30,Color.BLACK,new Color(0,0,0,0)));
        }
        else if(type.startsWith("HighCaliber"))
        {
            String number = type.substring(11,type.length());
            number = Utilities.intToRomanNumerals(Integer.valueOf(number));
            setImage(new GreenfootImage("HighCaliber " + number,30,Color.BLACK,new Color(0,0,0,0)));
        }
    }
}
