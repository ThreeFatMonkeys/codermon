import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    Player player;

    static final int GRIDSIZE = 32;
    
    public Game()
    {    
        super(800, 800, 1, false);
        player = new Player();
        addObject(player, grid(1), grid(1));
        addObject(new Solid(5, 5), grid(5),grid(5));
        for(int x = 0; x < getWidth()/GRIDSIZE; x++)
        {
            for(int y = (getHeight()/GRIDSIZE)/2; y < getHeight()/GRIDSIZE; y++)
            {
                addObject(new Behind(x, y), grid(x), grid(y));
            }
        }
        addObject(new Foreground(10, 10), grid(10), grid(10));
        setPaintOrder(Foreground.class, Solid.class, Player.class, Behind.class);
    }
    
    public int grid(int coord)
    {
        return (coord * GRIDSIZE) + (GRIDSIZE/2);
    }
}
