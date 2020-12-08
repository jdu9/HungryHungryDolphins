//______________________________________________________________________________
//
// EdibleFish extends Unit
//
// This is a fish the dolphin can eat and get hunger.
//

import greenfoot.Greenfoot;

public class EdibleFish extends Unit
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public EdibleFish()
            {
                super(new Sprite(Game.Images.fish_left, new Vector2f()));

                amplitude   = (float)Math.random() * 10.0f + 20.0f;
                phaselength = (float)Math.random() * 60.0f + 20.0f;
                ym = (float)Math.random() * 0.5f - 0.25f;
                phaseshift  = 0.0f;

                if (Greenfoot.getRandomNumber(2) == 0)
                {
                    spawnsLeft = false;
                }
                else
                {
                    spawnsLeft = true;
                }

                if (!spawnsLeft)
                {
                    // SPAWNS ON THE RIGHT SIDE
                    velocity.x = -0.25f - (float)Math.random() * 0.75f;

                    setPosition(new Vector2f(800.0f + getSprite().getScale().x, 0.0f));
                    getSprite().setImage(Game.Images.fish_left);
                    amplitude   *= -1.0f;
                    phaselength *= -1.0f;
                }
                else
                {
                    // SPAWNS ON THE LEFT SIDE
                    velocity.x = 0.25f + (float)Math.random() * 0.75f;

                    setPosition(new Vector2f(0.0f - getSprite().getScale().x, 0.0f));
                    getSprite().setImage(Game.Images.fish_right);
                }

                ystart = (float)Math.random() * 600.0f;

                setPosition(new Vector2f(getPosition().x, ystart));
            }

        /* - MODIFY - */

            public void moveSprite()
            {
                ystart += ym;
                setPosition(new Vector2f(getPosition().x + velocity.x, ystart + amplitude * (float)Math.sin(getPosition().x / phaselength + phaseshift)));
            }

        /* - RETURN - */

            public boolean isOutOfBorder()
            {
                if (spawnsLeft)
                {
                    return getPosition().x > 800.0f + getSprite().getScale().x
                           ||
                           getPosition().y < - 100.0f
                           ||
                           getPosition().y > 700.0f;
                }
                else
                {
                    return getPosition().x < 0.0f - getSprite().getScale().x
                           ||
                           getPosition().y < - 100.0f
                           ||
                           getPosition().y > 700.0f;
                }
            }

    /* --- DATA --- */

        private boolean                 spawnsLeft;

        private float                   ystart;

        private float                   ym;

        private float                   amplitude;

        private float                   phaselength;

        private float                   phaseshift;
}
