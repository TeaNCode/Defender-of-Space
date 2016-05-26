import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Displays useful information for new players
 * 
 * @Tea N' Code
 */
public class HelpWorld extends World
{
    public int currentPage;
    /**
     * Constructor for objects of class HelpWorld.
     * 
     */
    public HelpWorld(World backTo)
    {    
        super(1000, 800, 1);
        setBackground("gray.fw.png");
        //Allows the user to return to the Hub
        addObject(new Button("back", backTo),500,789);
        addObject(new Button("helpNext"),967,786);
        addObject(new Button("helpPrevious"),65,786);
        currentPage = 0;
        showPage();
    }
    public void showPage()
    {
        removeObjects(getObjects(Display.class));
        if(currentPage < 0)
            currentPage = 2;
        else if(currentPage > 2)
            currentPage = 0;
        addObject(new Display("Help",60,Color.LIGHT_GRAY),getWidth() / 2, 25);
        if(currentPage == 0)
        {
            addObject(new Display("Here you are:",40,Color.LIGHT_GRAY),105,95);
            addObject(new Display(new GreenfootImage("playerShip.png")), 243,95);
            addObject(new Display("And here is player 2:",40,Color.LIGHT_GRAY),444,95);
            addObject(new Display(new GreenfootImage("player2Ship.png")),638,95);
            addObject(new Display("Your objective is to kill the enemies:",40,Color.LIGHT_GRAY),275,153);
            addObject(new Display(new GreenfootImage("enemyShip1.png")),575,156);
            addObject(new Display(new GreenfootImage("enemyShip2.png")),625,156);
            addObject(new Display(new GreenfootImage("enemyShip3.png")),675,154);
            addObject(new Display("Player 1 shoots with the w key and strafes with the a and d keys.",40,Color.LIGHT_GRAY),489,197);
            addObject(new Display("Player 2 uses the up, left, and right arrow keys. Your goal is to",40,Color.LIGHT_GRAY),469,243);
            addObject(new Display("defeat the invading alien menace. The world is depending on you.",40,Color.LIGHT_GRAY),494,285);
            addObject(new Display("Do not fail us.",40,Color.LIGHT_GRAY),115,325);
        }
        else if(currentPage == 1)
        {
            addObject(new Display("Powerups:",40,Color.LIGHT_GRAY),93,82);
            addObject(new Display(new GreenfootImage("Attack.png")),630,418);
            addObject(new Display("Attack speed, decreases reload time.",20,Color.LIGHT_GRAY),820,418);
            addObject(new Display(new GreenfootImage("Burst.png")),86,165);
            addObject(new Display("Burst, allows you to shoot bursts for some time.",20,Color.LIGHT_GRAY),310,165);
            addObject(new Display(new GreenfootImage("Life.png")),633,322);
            addObject(new Display("Life, gives you another life.",20,Color.LIGHT_GRAY),820,322);
            addObject(new Display(new GreenfootImage("Movement.png")),86,254);
            addObject(new Display("Speed, Increases your movement speed.",20,Color.LIGHT_GRAY),310,254);
            addObject(new Display(new GreenfootImage("Mystery.png")),86,340);
            addObject(new Display("Mystery, Gives you a random power-up.",20,Color.LIGHT_GRAY),310,340);
            addObject(new Display(new GreenfootImage("Penetrate.png")),86,427);
            addObject(new Display("Penetrating shot, allows your bullet to kill multiple ships.",20,Color.LIGHT_GRAY),310,427);
            addObject(new Display(new GreenfootImage("Score.png")),635,136);
            addObject(new Display("Score, increases your score & money.",20,Color.LIGHT_GRAY),820,136);
            addObject(new Display(new GreenfootImage("Shield.png")),633,233);
            addObject(new Display("Shield, gives you a shield that will protect you.",20,Color.LIGHT_GRAY),835,233);
        }
        else if(currentPage == 2)
        {
            addObject(new Display("Shop Items:",40,Color.LIGHT_GRAY),93,82);
            addObject(new Display("Attack Speed:",40,Color.LIGHT_GRAY),111,136);
            addObject(new Display("Increases player 1's attack speed",40,Color.LIGHT_GRAY), 738,136);
            addObject(new Display("Movement:",40,Color.LIGHT_GRAY),88,191);
            addObject(new Display("Allows player 1 to move faster",40,Color.LIGHT_GRAY), 760,191);
            addObject(new Display("Boss Bonus:",40,Color.LIGHT_GRAY),100,245);
            addObject(new Display("Gives player 1 a small chance to deal",40,Color.LIGHT_GRAY),708,245);
            addObject(new Display("double damage to bosses",40,Color.LIGHT_GRAY),625,299);
            addObject(new Display("High Caliber:",40,Color.LIGHT_GRAY),103,353);
            addObject(new Display("Increases player 1's Boss Bonus and",40,Color.LIGHT_GRAY),715,353);
            addObject(new Display("decreases their attack speed",40,Color.LIGHT_GRAY),657,408);
        }
    }

    /**
     * Opens the command console when '~' is pressed
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("`"))
        {
            DevConsole.showConsole();
        }
    }
}
