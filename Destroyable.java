import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Framework for actors that can be destroyed by Projectiles
 * 
 * @Tea N' Code
 */
public abstract class Destroyable extends ScriptedActor
{   
    public abstract void hit(Projectile hitee);
}
