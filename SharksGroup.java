import java.util.*;

public class SharksGroup extends UnitGroup 
{
    /* --- METHODS --- */

        /* - CONSTRUCTORS - */
        
            public SharksGroup(int ms, float cd)
            {
                super(ms, cd);
                list = new ArrayList<Shark>();
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
                for (Iterator<Shark> it = list.iterator(); it.hasNext();)
                {
                    Shark obj = it.next();
                
                    obj.moveSprite();
                    if (obj.isOutOfBorder())
                    {
                        it.remove();
                    }
                }
            }
    
            public void add()
            {
                list.add(new Shark());
            }
            
            public void add(int a)
            {
                for (int i = 0; i < a; ++i)
                {
                    list.add(new Shark());
                }
            }
            
        /* - RETURN - */
    
            public Shark get(int i)
            {
                return ((Shark)list.get(i));
            }
}
