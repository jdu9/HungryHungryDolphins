//______________________________________________________________________________
//
// Time
//

public class Time
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Time() { }

            public Time(long t) { milliseconds = t; }

        /* - MODIFY - */

            public void set(long t)
            {
                milliseconds = t;
            }

            public void add(Time a)
            {
                milliseconds += a.asMilliseconds();
            }

        /* - RETURN - */

            public float asMinutes()
            {
                return milliseconds / 60000.0f;
            }

            public float asSeconds()
            {
                return milliseconds / 1000.0f;
            }

            public long asMilliseconds()
            {
                return milliseconds;
            }

            public long asMicroSeconds()
            {
                return milliseconds * 1000;
            }

        /* - STATIC METHODS - */

            public static Time substract(Time a, Time b)
            {
                return new Time(a.asMilliseconds() - b.asMilliseconds());
            }

    /* --- DATA --- */

        private long        milliseconds;
}
