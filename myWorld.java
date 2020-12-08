import greenfoot.*;
import java.util.*;
import java.lang.Math;
import java.util.ArrayList;
import java.awt.Font;

public class myWorld extends World
{
    // Constructor
    public myWorld()
    {
        // INITIALIZATION
        super(800, 600, 1, false);

        screen = new DrawableScreen(getBackground());
        game = new Game(screen);

        Font f1 = new Font("ARIAL", 0, 20);
        getBackground().setFont(f1);

        // CLOCKS
        fpsclock         = new Clock();
        fpsclockcooldown = new Clock();

        // TEXTS
        text_fps = new Text(new Vector2f(0.0f, 16.f), "FPS: ");
        text_pt  = new Text(new Vector2f(0.0f, 16.f + 20.0f), "");

        text_h1  = new Text(new Vector2f(0.0f, 16.f + 40.0f), "");
        text_h2  = new Text(new Vector2f(0.0f, 16.f + 60.0f), "");

        // BUTTONS
        b1 = new Button(Game.Images.one, new Vector2f(99,199));
        b2 = new Button(Game.Images.two, new Vector2f(500,199));
    }

    public void started()
    {
        // "stops" the clock if the game is paused.
        game.getClock().add(fpsclock.getElapsedTime());

        Greenfoot.setSpeed(50);
    }

    public void act()
    {
        Greenfoot.setSpeed(50);
        screen.clear();
        
        MouseInfo mouse = Greenfoot.getMouseInfo();

        
        if (game.isPlaying())
        {
            game.action();

            text_pt.setString("PT: " + game.getPlayingTime().asSeconds());

            switch (game.countPlayers())
            {
                case 2:
                    text_h2.setString("Hunger 2: " + (int)(game.getPlayer(1).getHunger() + 0.5f));
                case 1:
                    text_h1.setString("Hunger 1: " + (int)(game.getPlayer(0).getHunger() + 0.5f));
                    break;
            }
            if (game.countPlayersAlive() == 0)
            {
                b1 = new Button(Game.Images.one, new Vector2f(99,199));
                b2 = new Button(Game.Images.two, new Vector2f(500,199));
                game.setPlaying(false);
            }
        }
        else
        {
            game.menu();
            
            screen.draw(b1);
            screen.draw(b2);
            
            if (mouse != null)
            {
                if (mouse.getClickCount() > 0)
                {
                    if (b1.intersects(mouse))
                    {
                        game.start(1);
                        b1 = null;
                        b2 = null;
                        text_h2.setString("");
                    }

                    else if (b2.intersects(mouse))
                    {
                        game.start(2);
                        b1 = null;
                        b2 = null;
                    }
                }
            }
            screen.draw(Game.Images.title, 0, 0);
        }


        if (fpsclockcooldown.getElapsedTime().asSeconds() > 0.1f)
        {
            text_fps.setString("FPS: " + (int)(1.0f / fpsclock.getElapsedTime().asSeconds() + 0.5f));
            fpsclockcooldown.restart();
        }
        screen.draw(text_fps);
        screen.draw(text_pt);
        screen.draw(text_h1);
        screen.draw(text_h2);
        fpsclock.restart();
    }

    /* DATA */

    private Button b1;
    private Button b2;

    private Game game;
    private DrawableScreen screen;

    private Clock fishCooldown;
    private Clock fpsclock;
    private Clock fpsclockcooldown;

    private Text text_fps;
    private Text text_pt;
    private Text text_h1;
    private Text text_h2;
}
