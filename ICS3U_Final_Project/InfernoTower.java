import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class inferno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfernoTower extends Tower
{
    /**
     * Act - do whatever the inferno wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    ArrayList<int[]> positions;
     
    public InfernoTower(TowerTile tile)
    {
        super(tile);
        this.fire_rate = 900;
        image = new GreenfootImage("inferno_tower1.png");
        image.scale(40,60);
        setImage(image);
        setRadius(150);
        lv = new Label("Level " + getLevel(), 20);
        lv.setFillColor(Color.RED);
    }
    
    public void addedToWorld(World game)
    {
        world = (Game)game;
        positions = world.tiles;
    }
    
    public void act() 
    {
        super.act();
        displayLevel();
        if(time.millisElapsed()>900)
        {
            
            time.mark();
            Enemy target = checkClosest();

            if(target != null)
            {
                Fireball f = new Fireball(target, this);
                getWorld().addObject(f, getX(), getY());
            }
            
        }
    }    
    
    public void displayLevel()
    {
       lv.setValue("Level " + getLevel());
       getWorld().addObject(lv, this.getX(), this.getY()-36);
    }
    
    
}