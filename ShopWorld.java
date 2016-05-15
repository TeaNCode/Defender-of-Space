import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * The world that will allow the player to buy upgrades
 * 
 * @Tea N' Code
 */
public class ShopWorld extends World
{
    /**
     * Constructor for objects of class ShopWorld.
     */
    public ShopWorld(World backTo)
    {    
        super(1000, 800, 1);
        //Allows the player to return to the Hub
        addObject(new Button("back", backTo),29,789);
        for(int i = 1; i < 6; i++)
            addObject(new ShopButton("AttackSpeed" + String.valueOf(i),i * 700),i * 200 - 100,100);
        for(int i = 1; i < 6; i++)
            addObject(new ShopButton("Movement" + String.valueOf(i),i * 500 + 200),i * 200 - 100,200);
        for(int i = 1; i < 6; i++)
            addObject(new ShopButton("BossBonus" + String.valueOf(i),i * 900 - 300),i * 200 - 100,300);
        addObject(new MoneyCounter(),500,19);
    }

    /**
     * Opens the console when the player presses '~'
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
