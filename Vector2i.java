//______________________________________________________________________________
//
// Vector2i
//
// This class stores two integers.
//

import java.lang.Math;

public class Vector2i
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Vector2i()
            {
                this.x = 0;
                this.y = 0;
            }

            public Vector2i(int a, int b)
            {
                this.x = a;
                this.y = b;
            }

        /* - MODIFY - */

            /* Basic math operations */

                public void add(Vector2i a)
                {
                        x = x + a.x;
                        y = y + a.y;
                }

                public void substract(Vector2i a)
                {
                        x = x - a.x;
                        y = y - a.y;
                }

                public void multiply(Vector2i a)
                {
                        x = x * a.x;
                        y = y * a.y;
                }

                public void multiply(int a)
                {
                        x = x * a;
                        y = y * a;
                }

                public void divide(Vector2i a)
                {
                        x = x / a.x;
                        y = y / a.y;
                }

                public void divide(int a)
                {
                        x = x / a;
                        y = y / a;
                }

        /* - RETURN - */

            public int getRoundedX()
            {
                return (int)(this.x + 0.5f);
            }

            public int getRoundedY()
            {
                return (int)(this.y + 0.5f);
            }

            public boolean equals(Vector2i a)
            {
                return (this.x == a.x && this.y == a.y);
            }

    /* --- DATA --- */

        public int        x;

        public int        y;

    /* --- STATIC METHODS --- */

        public static Vector2i add(Vector2i a, Vector2i b)
        {
                return new Vector2i(a.x + b.x, a.y + b.y);
        }

        public static Vector2i add(Vector2i a, int b)
        {
                return new Vector2i(a.x + b, a.y + b);
        }

        public static Vector2i multiply(Vector2i a, Vector2i b)
        {
            return new Vector2i(a.x * b.x, a.y * b.y);
        }

        public static Vector2i multiply(Vector2i a, int b)
        {
            return new Vector2i(a.x * b, a.y * b);
        }

        public static Vector2i divide(Vector2i a, Vector2i b)
        {
            return new Vector2i(a.x / b.x, a.y / b.y);
        }

        public static Vector2i divide(Vector2i a, int b)
        {
            return new Vector2i(a.x / b, a.y / b);
        }

        public static int distance(Vector2i a, Vector2i b)
        {
            return (int)(Math.sqrt(Math.pow(b.x - a.x, 2.0f) + Math.pow(b.y - a.y, 2.0f)) + 0.5f);
        }

        public static int angle(Vector2i a, Vector2i b)
        {
            return (int)(Math.atan2(b.x - a.x, b.y - a.y) * 180.0f / Math.PI + 0.5f);
        }

        public static Vector2i move(int d, int a)
        {
            return new Vector2i((int)(Math.cos(a * Math.PI / 180.0f) * d + 0.5f),
                                (int)(Math.sin(a * Math.PI / 180.0f) * d + 0.5f));
        }
}
