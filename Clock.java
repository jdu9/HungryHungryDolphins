//______________________________________________________________________________
//
// Clock
//
// Simple clock to mesure the time since last restart.
//

public class Clock
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public Clock()
            {
                startTime = new Time(System.currentTimeMillis());
            }

        /* - MODIFY - */

            public void restart()
            {
                startTime.set(System.currentTimeMillis());
            }

            public void add(Time a)
            {
                startTime.add(a);
            }

        /* - RETURN - */

            public Time getElapsedTime()
            {
                return Time.substract(new Time(System.currentTimeMillis()),startTime);
            }

    /* --- DATA --- */

        private Time            startTime; // in milliseconds
}
