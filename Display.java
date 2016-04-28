import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * class to display objects like in helpworld
 * 
 * @TeaNCode
 */
public class Display extends Actor
{
    /**
     * A constructor that displays 'text' with a size of 40 in Black with a Transparent background
     */
    public Display(String text)
    {
        setImage(new GreenfootImage(text,40,Color.BLACK,new Color(0,0,0,0)));
    }

    /**
     * A constructor that displays 'text' with a size of 'size' in Black with a Transparent background
     */
    public Display(String text,int size)
    {
        setImage(new GreenfootImage(text,size,Color.BLACK,new Color(0,0,0,0)));
    }

    /**
     * A constructor that displays 'text' with a size of 'size' in 'foreground' with a Transparent background
     */
    public Display(String text,int size,Color foreground)
    {
        setImage(new GreenfootImage(text,size,foreground,new Color(0,0,0,0)));
    }

    /**
     * A constructor that displays 'text' with a size of 'size' in 'foreground' with a 'background' background
     */
    public Display(String text,int size,Color foreground,Color background)
    {
        setImage(new GreenfootImage(text,size,foreground,background));
    }  
    
    /**
     * A constructor that displays 'text' with a size of 'size' in 'foreground' with a 'background' background, with the text having an outline of 'outline'
     */
    public Display(String text,int size,Color foreground,Color background,Color outline)
    {
        setImage(new GreenfootImage(text,size,foreground,background,outline));
    }
    
    /**
     * A constructor that displays 'image', primarily to be used for displaying images
     */
    public Display(GreenfootImage image)
    {
        setImage(image);
    }
}