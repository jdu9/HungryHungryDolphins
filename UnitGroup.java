//______________________________________________________________________________
//
// UnitGroup
//
// This class stores a list of units and provides specific methods for all.
//

import java.util.*;

public abstract class UnitGroup
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public UnitGroup()
            {
                max_size = 10;
                cooldown = 10.0f;
                clock = new Clock();
                list = new ArrayList();
            }

            public UnitGroup(int ms, float cd)
            {
                max_size = ms;
                cooldown = cd;
                clock = new Clock();
            }

        /* - MODFIY - */

            public abstract void add();

            public abstract void add(int a);

            public void clear()
            {
                list.clear();
            }

            public void setMaxSize(int a)
            {
                max_size = a;
            }

            public void setCooldown(float a)
            {
                cooldown = a;
            }

        /* - RETURN - */

            public Clock getClock()
            {
                return clock;
            }

            public void restartClock()
            {
                clock.restart();
            }

            public int count()
            {
                return list.size();
            }

            public int getMaxSize()
            {
                return max_size;
            }

            public float getCooldown()
            {
                return cooldown;
            }
            
            public java.util.List getList()
            {
                return list;
            }

    /* --- DATA --- */

        protected ArrayList             list;

        private int                     max_size;

        private Clock                   clock;

        private float                   cooldown; // as seconds
}
