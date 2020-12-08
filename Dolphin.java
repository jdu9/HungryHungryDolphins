//______________________________________________________________________________
//
// Dolphin
//
// This is the unit owned by a player.
//

import java.lang.Math;

public class Dolphin extends Unit
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Dolphin(Vector2f pos, float acc, float vlimit)
            {
                super(new Sprite(Game.Images.dolphin_left, pos));
                acceleration  = acc;
                velocityLimit = vlimit;
            }

        /* - MODIFY - */

            void setAcceleration(float acc)
            {
                acceleration = acc;
            }

            void addAcceleration(float acc)
            {
                acceleration += acc;
            }

            void setVelocityLimit(float vlimit)
            {
                velocityLimit = vlimit;
            }

            /* CONTROLS - MOVEMENT */

                public void velocityUp()
                {
                    if (Math.abs(velocity.y) <= velocityLimit)
                    {
                        addVelocity(new Vector2f(0.0f, -(acceleration / 2.0f)));
                    }
                }

                public void velocityDown()
                {
                    if (Math.abs(velocity.y) <= velocityLimit)
                    {
                        addVelocity(new Vector2f(0.0f, +(acceleration / 2.0f)));
                    }
                }

                public void velocityLeft()
                {
                    if (Math.abs(velocity.x) <= velocityLimit)
                    {
                        addVelocity(new Vector2f(-(acceleration / 2.0f), 0.0f));
                    }
                }

                public void velocityRight()
                {
                    if (Math.abs(velocity.x) <= velocityLimit)
                    {
                        addVelocity(new Vector2f(+(acceleration / 2.0f), 0.0f));
                    }
                }

                public void moveSprite()
                {
                    velocity.multiply(0.975f);
                    sprite.setPosition(Vector2f.add(getPosition(), velocity));
                    if (getPosition().x < 0)
                    {
                        setPosition(new Vector2f(0.0f, getPosition().y));
                        velocity.x = 0.0f;
                    }
                    if (getPosition().x > 800 - getSprite().getScale().x)
                    {
                        setPosition(new Vector2f(800.0f - getSprite().getScale().x, getPosition().y));
                        velocity.x = 0.0f;
                    }
                    if (getPosition().y < 0)
                    {
                        setPosition(new Vector2f(getPosition().x, 0.0f));
                        velocity.y = 0.0f;
                    }
                    if (getPosition().y > 600 - getSprite().getScale().y)
                    {
                        setPosition(new Vector2f(getPosition().x, 600.0f - getSprite().getScale().y));
                        velocity.y = 0.0f;
                    }
                }

    /* --- DATA --- */

        private float               acceleration;

        private float               velocityLimit;
}
