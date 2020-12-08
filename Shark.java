//______________________________________________________________________________
//
// Shark extends Unit
//
// This is a shark.
//

import greenfoot.Greenfoot;

public class Shark extends Unit
{
    /* --- METHODS --- */

    /* - CONSTRUCTORS - */

        public Shark()
        {
            super(new Sprite(Game.Images.shark_left, new Vector2f(0.0f,0.0f)));

            float ystart = (float)Math.random() * (600.0f);

            if (Greenfoot.getRandomNumber(2) == 0)
            {
                spawnsLeft = false;
                velocity = new Vector2f(-1.0f, 0.0f);
                getSprite().setImage(Game.Images.shark_left);
                setPosition(new Vector2f(800.0f + getSprite().getScale().x, ystart));
            }
            else
            {
                spawnsLeft = true;
                velocity = new Vector2f(1.0f, 0.0f);
                getSprite().setImage(Game.Images.shark_right);
                setPosition(new Vector2f(0.0f - getSprite().getScale().x, ystart));
            }

        }

        /* - RETURN - */

            public boolean isOutOfBorder()
            {
                if (spawnsLeft)
                {
                    return getPosition().x > 800.0f + getSprite().getScale().x;
                }
                else
                {
                    return getPosition().x < 0.0f - getSprite().getScale().x;
                }
            }

    /* --- DATA --- */

        private boolean         spawnsLeft;
}
