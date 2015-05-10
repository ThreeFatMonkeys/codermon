import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameObject extends Actor
{
    int gridSize, gridX, gridY;
    
    public GameObject()
    {
        gridSize = 32;
    }
    
    public GameObject(int x, int y)
    {
        gridSize = 32;
        gridX = x;
        gridY = y;
    }
}
