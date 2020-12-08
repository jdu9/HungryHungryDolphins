//______________________________________________________________________________
//
// Vector2f
//
// This class stores two floats.
//

import java.lang.Math;

public class Vector2f
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Vector2f()
            {
                this.x = 0.0f;
                this.y = 0.0f;
            }

            public Vector2f(float a, float b)
            {
                this.x = a;
                this.y = b;
            }

        /* - MODIFY - */

            /* Basic math operations */

                public void add(Vector2f a)
                {
                        x = x + a.x;
                        y = y + a.y;
                }

                public void substract(Vector2f a)
                {
                        x = x - a.x;
                        y = y - a.y;
                }

                public void multiply(Vector2f a)
                {
                        x = x * a.x;
                        y = y * a.y;
                }

                public void multiply(float a)
                {
                        x = x * a;
                        y = y * a;
                }

                public void divide(Vector2f a)
                {
                        x = x / a.x;
                        y = y / a.y;
                }

                public void divide(float a)
                {
                        x = x / a;
                        y = y / a;
                }

            /* Rounding */

                public void round()
                {
                    this.x = (float)getRoundedX();
                    this.y = (float)getRoundedY();
                }

                public void roundX()
                {
                    this.x = (float)getRoundedX();
                }

                public void roundY()
                {
                    this.x = (float)getRoundedY();
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

            public boolean equals(Vector2f a)
            {
                return (this.x == a.x && this.y == a.y);
            }

    /* --- DATA --- */

        public float        x;

        public float        y;

    /* --- STATIC METHODS --- */

        public static Vector2f add(Vector2f a, Vector2f b)
        {
                return new Vector2f(a.x + b.x, a.y + b.y);
        }

        public static Vector2f add(Vector2f a, float b)
        {
                return new Vector2f(a.x + b, a.y + b);
        }

        public static Vector2f multiply(Vector2f a, Vector2f b)
        {
            return new Vector2f(a.x * b.x, a.y * b.y);
        }

        public static Vector2f multiply(Vector2f a, float b)
        {
            return new Vector2f(a.x * b, a.y * b);
        }

        public static Vector2f divide(Vector2f a, Vector2f b)
        {
            return new Vector2f(a.x / b.x, a.y / b.y);
        }

        public static Vector2f divide(Vector2f a, float b)
        {
            return new Vector2f(a.x / b, a.y / b);
        }

        public static float distance(Vector2f a, Vector2f b)
        {
            return (float)Math.sqrt(Math.pow(b.x - a.x, 2.0f) + Math.pow(b.y - a.y, 2.0f));
        }

        public static float angle(Vector2f a, Vector2f b)
        {
            return (float)Math.atan2(b.x - a.x, b.y - a.y) * 180.0f / (float)Math.PI;
        }

        public static Vector2f move(float d, float a)
        {
            return new Vector2f((float)Math.cos(a * Math.PI / 180.0f) * d,
                                (float)Math.sin(a * Math.PI / 180.0f) * d);
        }
}
