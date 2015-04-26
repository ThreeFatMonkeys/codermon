import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    Player player;
    
    public Game()
    {    
        super(800, 800, 1, false);
        player = new Player();
        addObject(player, 48, 48);
    }
}
