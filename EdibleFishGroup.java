//______________________________________________________________________________
//
// EdibleFishGroup extends UnitGroup
//
// This class stores a list of ediblefishes and provides specific methods for them.
//

import java.util.*;

public class EdibleFishGroup extends UnitGroup
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */

            public EdibleFishGroup(int ms, float cd, float h)
            {
                super(ms, cd);
                hunger = h;
                list = new ArrayList<EdibleFish>();
            }

        /* - MODIFY - */
            
            public void spawn()
            {
                if (this.count() <= this.getMaxSize())
                {
                    if (this.getClock().getElapsedTime().asSeconds() >= this.getCooldown())
                    {
                        this.add();
                        this.getClock().restart();
                    }
                }
                else
                {
                    this.getClock().restart();
                }
            }
            
            public void move()
            {
                for (Iterator<EdibleFish> it = list.iterator(); it.hasNext();)
                {
                    EdibleFish obj = it.next();
                
                    obj.moveSprite();
                    if (obj.isOutOfBorder())
                    {
                        it.remove();
                    }
                }
            }

            public void add()
            {
                list.add(new EdibleFish());
            }

            public void add(int a)
            {
                for (int i = 0; i < a; ++i)
                {
                    list.add(new EdibleFish());
                }
            }

            public void setHunger(float a)
            {
                hunger = a;
            }

        /* - RETURN - */

            public float getHunger()
            {
                return hunger;
            }
            
            public EdibleFish get(int i)
            {
                return ((EdibleFish)list.get(i));
            }
            
    /* --- DATA --- */

        private float           hunger;
}
