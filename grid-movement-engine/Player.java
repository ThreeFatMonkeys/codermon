import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends GameObject
{
    GreenfootImage upI, downI, leftI, rightI;
    
    boolean walking;
    
    int direction;
    
    int walk, walkSpeed;
    
    int gridSize, gridX, gridY;
    
    public Player()
    {
        upI = new GreenfootImage("smileyup.png");
        downI = new GreenfootImage("smileydown.png");
        leftI = new GreenfootImage("smileyleft.png");
        rightI = new GreenfootImage("smileyright.png");
        
        walking = false;
        
        gridSize = 32;
        
        walk = 0;
        walkSpeed = 32;
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
        
        if(Greenfoot.isKeyDown("h"))
        {
            setLocation(int x, int y);
        }
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
                walking = true;
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
                walking = true;
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
                walking = true;
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
                walking = true;
            }
            else
            {
                setImage(rightI);
            }
        }
    }
    
    public void movement()
    {
        walk += walkSpeed;
        if(getImage() == upI)
        {
            setRotation(direction);
            move(walkSpeed);
            setRotation(0);
            if(getY() <= (gridY * gridSize) + gridSize/2)
            {
                setLocation(getX(), (gridY * gridSize) + gridSize/2);
                walking = false;
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
            }
        }  
    }
    
    public void setLocation(int x, int y)
    {
        x = 500;
        y = 500;
    }
}
