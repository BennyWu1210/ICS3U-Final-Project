import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{

    /**
     * Constructor for objects of class Intro.
     * 
     */
    SimpleTimer t = new SimpleTimer();
    GifImage intro = new GifImage("Intro_screen.gif");
    List<GreenfootImage> background = intro.getImages();
    int imageIndex = 0;
    static int length = 960;
    static int width = 483;
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(length, width, 1); 
        for(GreenfootImage i: background)
        {
            i.scale(length, width);
        }
        setBackground(background.get(imageIndex));
        t.mark();
        displayTitle();
        createButton();
    }
    
    public void act()
    {
        
        setBackground(background.get(imageIndex));
        
        if(t.millisElapsed()>100)
        {
            getImage();
        }
        

        /*
        if(Greenfoot.mouseClicked(null))
        {
            Game g = new Game();
            Greenfoot.setWorld(g);
        }
        */
    }
    
    public GreenfootImage getImage()
    {

        GreenfootImage image = background.get(imageIndex);
        imageIndex ++;
        t.mark();
            
        if (imageIndex>=background.size())
        {
            imageIndex = 0;
        }
            
        return image;

    }
    

    public void createButton()
    {
        GreenfootImage b = new GreenfootImage("start_button03.tif");
        StartButton button = new StartButton(b, (int)(232), 
                                            (int)(112));
        addObject(button, length/2, width*4/5);
    }
    
    public void displayTitle()
    {
        
        Label l = new Label("Welcome to Benny's Tower Defense",52);
        addObject(l, length/2, width/8);
    }
}