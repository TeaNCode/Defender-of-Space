/**
 * Write a description of class DevOptions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DevOptions  
{
    //Makes the player invulnerable
    static final boolean invulnerable = false;
    //More enemy attacks
    static final int attackMultiplier = 1;
    //Bullets collide with each other.
    //BUG: When bullets hit top of world with this enabled it throws an error
    static final boolean realism = false;
    //Allows the player to go past where the enemies can shoot on the X axis
    static final boolean hiding = false;
    //Allows the player to fire without reloading
    static final boolean minigun = false;
}
