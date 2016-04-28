import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoodShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GoodShip extends Destroyable
{
    public int gunReloadTime;
    public int score;
    public int enemiesKilled;
    public int shots;
    public int misses;
    public boolean shielded;
    public Shield shield;
    public int reloadDelayCount;
    public SpaceWorld world;
    public boolean delete;
    public int spawnProtection;
    public int speed;
    public int attackBoostedTime;
    public boolean attackSpeed;
    public boolean penetrate;
    public boolean burst;
    public int penShots;
    public int burstShots;
}
