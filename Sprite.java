//______________________________________________________________________________
//
// Sprite
//
// This class is a movable image (Sprite).
//

import greenfoot.*;
import java.util.Vector;

public class Sprite
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Sprite(String filename)
            {
                image = new GreenfootImage(filename);
                position = new Vector2f(0.0f, 0.0f);
                scale = new Vector2f((float)(image.getWidth()), (float)(image.getHeight()));
            }

            public Sprite(String filename, Vector2f pos)
            {
                image = new GreenfootImage(filename);
                position = pos;
                scale = new Vector2f((float)(image.getWidth()), (float)(image.getHeight()));
            }

            public Sprite(GreenfootImage img)
            {
                image = img;
                position = new Vector2f(0.0f, 0.0f);
                scale = new Vector2f((float)(image.getWidth()), (float)(image.getHeight()));
            }

            public Sprite(GreenfootImage img, Vector2f pos)
            {
                image = img;
                position = pos;
                scale = new Vector2f((float)(image.getWidth()), (float)(image.getHeight()));
            }

        /* - MODIFY - */

            /* POSITION */

                public void setPosition(Vector2f pos)
                {
                    position = pos;
                }

                public void setPosition(float px, float py)
                {
                    position.x = px;
                    position.y = px;
                }

                public void move(Vector2f p)
                {
                    position.x += p.x;
                    position.y += p.y;
                }

                public void move(float dx, float dy)
                {
                    position.x += dx;
                    position.y += dy;
                }

            /* GREENFOOT IMAGE */

                public void setImage(GreenfootImage img)
                {
                    image = img;
                }

                public void setRotation(float d)
                {
                    rotation = d;
                    image.rotate((int)(rotation + 0.5f));
                }

                public void setScale(Vector2f s)
                {
                    scale = s;
                    image.scale(scale.getRoundedX(), scale.getRoundedY());
                }

        /* - RETURN - */

            /* INTERSECTION */

                public boolean intersects(Sprite a)
                {
                    // Tests if this Sprite intersects with another Sprite
                    return !(this.getPosition().x + this.getScale().x < a.getPosition().x
                             ||
                             a.getPosition().x + a.getScale().x < this.getPosition().x
                             ||
                             this.getPosition().y + this.getScale().y < a.getPosition().y
                             ||
                             a.getPosition().y + a.getScale().y < this.getPosition().y);
                }

                public boolean intersects(MouseInfo a)
                {
                    // Tests if this Sprite intersects with the position of the mouse
                   return !(this.getPosition().x + this.getScale().x < a.getX()
                            ||
                            a.getX() < this.getPosition().x
                            ||
                            this.getPosition().y + this.getScale().y < a.getY()
                            ||
                            a.getY() < this.getPosition().y);
                }

            public Vector2f getPosition()
            {
                return position;
            }

            public float getRotation()
            {
                return rotation;
            }

            public GreenfootImage getImage()
            {
                return image;
            }

            public Vector2f getScale()
            {
                return scale;
            }

    /* --- DATA --- */

        private GreenfootImage          image;

        private Vector2f                position;

        private Vector2f                scale;

        private float                   rotation;
}
