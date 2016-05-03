import greenfoot.World;
/**
 * spawns the waves in to the world
 * 
 * @TeaNCode
 */
public class Wave  
{
    private SpawnableEntity[] contents;
    /**
     * Constructor for objects of class Wave
     */
    public Wave(SpawnableEntity[] contents)
    {
        //gets content wanted in wolrd
        this.contents = contents;
    }
    
    public void spawnWave(World world)
    {
        //spawns content
        for(SpawnableEntity entity : contents)
        {
            entity.spawn(world);
        }
    }
}
