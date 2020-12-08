//______________________________________________________________________________
//
// Player
//
// This class represents a player and stores things like hunger as a float, if he's alive as a boolean..
//

import greenfoot.*;
import java.lang.Math;

public class Player
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Player(Dolphin dlph, String u, String l, String d, String r)
            {
                alive = true;
                dolphin = dlph;
                controls = new Controls(u, l, d, r);
                direction_left = true;

                hunger = 100;
            }

            public Player(Dolphin dlph, Controls c)
            {
                alive = true;
                dolphin = dlph;
                controls = new Controls(c.up, c.left, c.down, c.right);
                direction_left = true;

                hunger = 100;
            }

        /* - MODIFY - */

            public void input()
            {
                // moves the dolphin depending on where the player wants to go (movement keys)
                if (Greenfoot.isKeyDown(controls.up))
                {
                    dolphin.velocityUp();
                }
                else if (Greenfoot.isKeyDown(controls.down))
                {
                    dolphin.velocityDown();
                }

                if (Greenfoot.isKeyDown(controls.left))
                {
                    if (!direction_left)
                    {
                        dolphin.getSprite().setImage(Game.Images.dolphin_left);
                        direction_left = true;
                    }
                    dolphin.velocityLeft();
                }
                else if (Greenfoot.isKeyDown(controls.right))
                {
                    if (direction_left)
                    {
                        dolphin.getSprite().setImage(Game.Images.dolphin_right);
                        direction_left = false;
                    }
                    dolphin.velocityRight();
                }
                dolphin.moveSprite();
            }

            public void setAlive(boolean a)
            {
                alive = a;
            }

            /* - HUNGER - */

                public void setHunger(float a)
                {
                    if (a > 0)
                    {
                        if (a <= 100)
                        {
                            hunger = a;
                        }
                        else
                        {
                            hunger = 100;
                        }
                    }
                    else
                    {
                        hunger = 0;
                        alive = false;
                    }
                }

                public void addHunger(float a)
                {
                    setHunger(getHunger() + a);
                }

        /* - RETURN - */

            public Vector2f getPosition()
            {
                return dolphin.getPosition();
            }

            public Dolphin getDolphin()
            {
                return dolphin;
            }

            public boolean intersects(Sprite a)
            {
                return dolphin.getSprite().intersects(a);
            }

            public boolean isAlive()
            {
                return alive;
            }

            public float getHunger()
            {
                return hunger;
            }

    /* --- DATA --- */

        private Dolphin                     dolphin;

        private Controls                    controls;

        private float                       hunger;

        private boolean                     direction_left;

        private boolean                     alive;

}
