//______________________________________________________________________________
//
// Unit
//
// This class stores a Sprite and a velocity (Vector2f) which moves if you call moveSprite().
//

public class Unit
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Unit()
            {
                sprite   = null;
                velocity = new Vector2f(0.0f, 0.0f);
            }

            public Unit(Sprite spr)
            {
                sprite   = spr;
                velocity = new Vector2f(0.0f, 0.0f);
        }

        /* - MODIFY - */

            /* SPRITE */

                public void setPosition(Vector2f pos)
                {
                    sprite.setPosition(pos);
                }

                public void moveSprite()
                {
                    sprite.setPosition(Vector2f.add(sprite.getPosition(), velocity));
                }

            /* VELOCITY */

                protected void setVelocity(Vector2f v)
                {
                    velocity = v;
                }

                protected void setVelocity(float vx, float vy)
                {
                    velocity.x = vx;
                    velocity.y = vy;
                }

                protected void addVelocity(Vector2f v)
                {
                    velocity.add(v);
                }

        /* - RETURN */

            public Sprite getSprite()
            {
                return sprite;
            }

            public Vector2f getVelocity()
            {
                return velocity;
            }

            public Vector2f getPosition()
            {
                return sprite.getPosition();
            }

    /* --- DATA --- */

        protected Sprite        sprite;

        protected Vector2f      velocity;
}
