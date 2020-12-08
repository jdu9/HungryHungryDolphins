//______________________________________________________________________________
//
// DrawableScreen
//

import greenfoot.*;

public class DrawableScreen
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public DrawableScreen(GreenfootImage a)
            {
                dimage = a;
            }

        /* - MODIFY - */

            public void clear()
            {
                dimage.drawImage(Game.Images.background, 0, 0);
            }

            /* DRAW */

                public void draw(GreenfootImage a, int x, int y)
                {
                    dimage.drawImage(a,
                        x,
                        y);
                }

                public void draw(Sprite a)
                {
                    dimage.drawImage(a.getImage(),
                        (int)(a.getPosition().x + 0.5f),
                        (int)(a.getPosition().y + 0.5f));
                }

                public void draw(Unit a)
                {
                    dimage.drawImage(a.getSprite().getImage(),
                        (int)(a.getPosition().x + 0.5f),
                        (int)(a.getPosition().y + 0.5f));
                }

                public void draw(Player a)
                {
                    dimage.drawImage(a.getDolphin().getSprite().getImage(),
                        (int)(a.getPosition().x + 0.5f),
                        (int)(a.getPosition().y + 0.5f));
                }

                public void draw(Text a)
                {
                    dimage.drawString(a.getString(),
                        (int)(a.getPosition().x + 0.5f),
                        (int)(a.getPosition().y + 0.5f));
                }

    /* --- DATA --- */

        private GreenfootImage dimage; // greenfoot background
}
