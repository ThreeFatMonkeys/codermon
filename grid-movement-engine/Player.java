import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends GameObject
{
    GreenfootImage upI, downI, leftI, rightI;
    
    boolean walking;
    
    int direction;
    
    int walkSpeed, walkDistance;
    
    public Player()
    {
        upI = new GreenfootImage("smileyup.png");
        downI = new GreenfootImage("smileydown.png");
        leftI = new GreenfootImage("smileyleft.png");
        rightI = new GreenfootImage("smileyright.png");
        
        walking = false;
        
        gridSize = 32;
        
        walkSpeed = 5;
        walkDistance = 0;
    }

    public void act() 
    {
        if(walking)
        {
            movement();
        }
        else
        {
            control();
        }
    }    
    
    public boolean canWalk(int direction)
    {
        Solid hit;
        switch(direction)
        {
        case 270:
            hit = (Solid) getOneObjectAtOffset(0, -gridSize, Solid.class);
            break;
        case 90:
            hit = (Solid) getOneObjectAtOffset(0, gridSize, Solid.class);
            break;
        case 180:
            hit = (Solid) getOneObjectAtOffset(-gridSize, 0, Solid.class);
            break;
        case 0:
            hit = (Solid) getOneObjectAtOffset(gridSize, 0, Solid.class);
            break;
        default:
            return false;
        }
        
        if(hit != null)
        {
            return false;
        }
        return true;
    }
    
    public void control()
    {
        gridX = (getX() - (gridSize/2))/gridSize;
        gridY = (getY() - (gridSize/2))/gridSize;
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(getImage() == upI)
            {
                gridY--;
                direction = 270;
                walking = canWalk(270);
            }
            else
            {
                setImage(upI);
            }
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            if(getImage() == downI)
            {
                gridY++;
                direction = 90;
                walking = canWalk(90);
            }
            else
            {
                setImage(downI);
            }
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            if(getImage() == leftI)
            {
                gridX--;
                direction = 180;
                walking = canWalk(180);
            }
            else
            {
                setImage(leftI);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            if(getImage() == rightI)
            {
                gridX++;
                direction = 0;
                walking = canWalk(0);
            }
            else
            {
                setImage(rightI);
            }
        }
    }
    
    public void movement()
    {
        if(getImage() == upI)
        {
            setRotation(direction);
            move(walkSpeed);
            setRotation(0);
            if(getY() <= (gridY * gridSize) + gridSize/2)
            {
                setLocation(getX(), (gridY * gridSize) + gridSize/2);
                walking = false;
                walkDistance += 1;
            }
        }
        else if(getImage() == downI)
        {
            setRotation(direction);
            move(walkSpeed);
            setRotation(0);
            if(getY() >= (gridY * gridSize) + gridSize/2)
            {
                setLocation(getX(), (gridY * gridSize) + gridSize/2);
                walking = false;
                walkDistance += 1;
            }
        }
        else if(getImage() == leftI)
        {
            setRotation(direction);
            move(walkSpeed);
            setRotation(0);
            if(getX() <= (gridX * gridSize) + gridSize/2)
            {
                setLocation((gridX * gridSize) + gridSize/2, getY());
                walking = false;
                walkDistance += 1;
            }
        }
        else if(getImage() == rightI)
        {
            setRotation(direction);
            move(walkSpeed);
            setRotation(0);
            if(getX() >= (gridX * gridSize) + gridSize/2)
            {
                setLocation((gridX * gridSize) + gridSize/2, getY());
                walking = false;
                walkDistance += 1;
            }
        }  
    }
}
