/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.olutvarasto.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import wad.olutvarasto.domain.Olut;

@Service
public class SimpleOlutPalvelu implements OlutPalvelu{
    
    private static int counter = 0;
    private List<Olut> oluet = new ArrayList();

    @Override
    public Olut lisaaOlut(Olut olut) {
        olut.setId(++counter);
        oluet.add(olut);
        
        return olut;
    }

    @Override
    public void poistaOlut(int tunnus) {
        for(Olut o : oluet) {
            if(o.getId() == tunnus) {
                oluet.remove(o);
                return;
            }
        }
    }

    @Override
    public Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut) {
        for (Olut o : oluet) {
            if (o.getId() == tunnus) {
                int temp = oluet.indexOf(o);
                oluet.remove(o);
                oluet.add(temp, olut);
                return olut;
            }
        }
        oluet.add(olut);
        return olut;
    }

    @Override
    public Olut annaOlut(int tunnus) {
        for (Olut e : oluet) {
            if (e.getId() == tunnus) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Olut> listaaOluet() {
        return oluet;
    }
    
}
