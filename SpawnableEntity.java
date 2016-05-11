import greenfoot.Actor;
import greenfoot.World;
/**
 * sets location and spanws the entities called in 'Wave'
 * 
 * @TeaNCode
 */
public class SpawnableEntity  
{
    private Actor object;
    private int x;
    private int y;
    /**
     * An actor that is ready to be made, for use in waves
     */
    public SpawnableEntity(Actor object, int x, int y)
    {
        //sets location
        this.object = object;
        this.x = x;
        this.y = y;
    }
    
    public void spawn(World world)
    {
        //adds entity
        world.addObject(object,x,y);
    }
}
