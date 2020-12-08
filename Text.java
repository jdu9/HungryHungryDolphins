//______________________________________________________________________________
//
// Text
//
// The purpose of this class is to store a string and a position together. It can be drawn on a GreenfootImage.
//

import greenfoot.*;

public class Text
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS */

            public Text()
            {
                string = "";
                position = new Vector2f(0,0);
            }

            public Text(Vector2f pos, String str)
            {
                string = str;
                position = pos;
            }

        /* - MODIFY - */

            public void setPosition(Vector2f a)
            {
                position = a;
            }

            public void setString(String str)
            {
                string = str;
            }

        /* - RETURN - */

            public Vector2f getPosition()
            {
                return position;
            }

            public String getString()
            {
                return string;
            }

    /* --- DATA --- */

        private String          string;

        private Vector2f        position;
}
