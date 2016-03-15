/**
 * Write a description of class Wave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave  
{
    private SpawnableEntity[] contents;
    /**
     * Constructor for objects of class Wave
     */
    public Wave(SpawnableEntity[] contents)
    {
        this.contents = contents;
    }
    
    public void spawnWave()
    {
        for(SpawnableEntity entity : contents)
        {
            entity.spawn();
        }
    }
}
