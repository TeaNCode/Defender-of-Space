import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoodShip here.
 * 
 * @author Tea 
 */
public abstract class GoodShip extends Destroyable
{
    //How long we have to reload
    public int gunReloadTime;
    //What our score is
    public int score;
    //How many enemies we've killed
    public int enemiesKilled;
    //How many shots we've fired
    public int shots;
    //How many times we hit nothing
    public int misses;
    //If we're shielded
    public boolean shielded;
    //Stores the shield
    public Shield shield;
    //How far we are to being done reloading
    public int reloadDelayCount;
    //The world we're in
    public SpaceWorld world;
    //If we should delete ourselves
    public boolean delete;
    //How much longer we have spawn protection
    public int spawnProtection;
    //How fast we are
    public int speed;
    //How long we get to shoot faster
    public int attackBoostedTime;
    //If we shoot faster
    public boolean attackSpeed;
    //If our bullets go through enemies
    public boolean penetrate;
    //If we shoot bursts
    public boolean burst;
    //How many penetrating shots we've shot
    public int penShots;
    //How many bursts we've shot
    public int burstShots;
}
