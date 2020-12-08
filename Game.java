//______________________________________________________________________________
//
// Game
//
// This class stores a list of all players, all unitgroups and also other stuff.
//

import java.util.*;
import greenfoot.*;

public class Game
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Game(DrawableScreen sc)
            {
                playing = false;
                screen = sc;
                
                clock = new Clock();

                players      = new ArrayList<Player>();

                ediblefishes = new EdibleFishGroup(20, 1.0f, 5.0f);
                sharks = new SharksGroup          (2, 5.0f);
            }

        /* - MODIFY - */

            public void start(int ps)
            {
                // initialization
                players.clear();
                ediblefishes.clear();
                sharks.clear();

                playing = true;
                switch (ps)
                {
                    case 2:
                        addPlayer(new Player(new Dolphin(new Vector2f(299.0f, 299.0f),
                                                                       0.2f,
                                                                       5.0f),
                                                           new Controls("I", "J", "K", "L")));
                    case 1:
                        addPlayer(new Player(new Dolphin(new Vector2f(399.0f, 299.0f),
                                                                       0.2f,
                                                                       5.0f),
                                                           new Controls("W", "A", "S", "D")));
                        break;
                }
                if (players.size() == 1)
                {
                    ediblefishes.setHunger(5.0f);
                }
                else if (players.size() == 2)
                {
                    ediblefishes.setHunger(2.5f);
                }
                ediblefishes.getClock().restart();
                sharks.getClock().restart();
                clock.restart();
            }
            
            public void action()
            {
                ediblefishes.spawn();
                sharks      .spawn();
                
                for (Player player : players)
                {
                    if (player.isAlive())
                    {
                        player.input();
                        player.addHunger(-0.1f);
                    }
                }
                
                ediblefishes.move();
                sharks      .move();
                
                for (Player player : players)
                {
                    if (player.isAlive())
                    {
                        {
                        Iterator<EdibleFish> it = ediblefishes.getList().iterator();
                        while (it.hasNext())
                        {
                            EdibleFish obj = it.next();
    
                            if (player.getDolphin().getSprite().intersects(obj.getSprite()))
                            {
                                player.addHunger(ediblefishes.getHunger());
                                it.remove();
                            }
                        }
                        }
    
                        Iterator<Shark> it = sharks.getList().iterator();
                        while (it.hasNext())
                        {
                            Shark obj = it.next();
    
                            if (player.getDolphin().getSprite().intersects(obj.getSprite()))
                            {
                                player.setHunger(0.0f);
                            }
                        }
                        screen.draw(player);
                    }
                }
                
                if (this.countPlayersAlive() > 1)
                {
                    if (this.getPlayer(0).getDolphin().getSprite().intersects(this.getPlayer(1).getDolphin().getSprite()))
                    {
                        float sum = this.getPlayer(0).getHunger() + this.getPlayer(1).getHunger();
                        this.getPlayer(0).setHunger(sum / 2.0f);
                        this.getPlayer(1).setHunger(sum / 2.0f);
                    }
                }
                
                {
                    Iterator<Shark> it = sharks.getList().iterator();
                    while (it.hasNext())
                    {
                        screen.draw(it.next());
                    }
                }
                
                {
                    Iterator<EdibleFish> it = ediblefishes.getList().iterator();
                    while (it.hasNext())
                    {
                        screen.draw(it.next());
                    }
                }
            }
            
            public void menu()
            {
                ediblefishes.spawn();
                sharks      .spawn();
                
                ediblefishes.move();
                sharks      .move();
                
                {
                    Iterator<Shark> it = sharks.getList().iterator();
                    while (it.hasNext())
                    {
                        screen.draw(it.next());
                    }
                }
                
                {
                    Iterator<EdibleFish> it = ediblefishes.getList().iterator();
                    while (it.hasNext())
                    {
                        screen.draw(it.next());
                    }
                }
            }
            
            public void addPlayer(Player a)
            {
                players.add(a);
            }

            public void setPlaying(boolean a)
            {
                playing = a;
            }
        /* - RETURN - */

            public boolean isPlaying()
            {
                return playing;
            }

            public int countPlayers()
            {
                return players.size();
            }

            public int countPlayersAlive()
            {
                int size = 0;
                for (Player player : players)
                {
                    if (player.isAlive() == true)
                    {
                        ++size;
                    }
                }
                return size;
            }

            public java.util.List<Player> getPlayers()
            {
                return players;
            }

            public Player getPlayer(int a)
            {
                return ((Player)players.get(a));
            }

            public Time getPlayingTime()
            {
                return clock.getElapsedTime();
            }

            public Clock getClock()
            {
                return clock;
            }

    /* --- DATA --- */

        private boolean                       playing;

        private java.util.List<Player>        players;

        private Clock                         clock;

        private EdibleFishGroup               ediblefishes;

        private SharksGroup                   sharks;
        
        private DrawableScreen                screen;



    /* --- STATIC CONSTANTS OF THE GAME --- */

        public static class Images
        {
            // Units

                public final static GreenfootImage dolphin_left   = new GreenfootImage("dolphin_left.png");

                public final static GreenfootImage dolphin_right  = new GreenfootImage("dolphin_right.png");


                public final static GreenfootImage fish_left      = new GreenfootImage("fish_left.png");

                public final static GreenfootImage fish_right     = new GreenfootImage("fish_right.png");


                public final static GreenfootImage shark_left     = new GreenfootImage("shark_left.png");

                public final static GreenfootImage shark_right    = new GreenfootImage("shark_right.png");

            // interface

                public final static GreenfootImage background     = new GreenfootImage("underwater.jpg");

                public final static GreenfootImage one            = new GreenfootImage("selection_one.png");

                public final static GreenfootImage two            = new GreenfootImage("selection_two.png");

                public final static GreenfootImage title          = new GreenfootImage("title.png");
        }
}
