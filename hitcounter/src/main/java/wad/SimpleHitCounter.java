/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import org.springframework.stereotype.Service;

@Service
public class SimpleHitCounter implements HitCounter {
    private int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void incrementCount() {
        if (count < 100) {
            count = count + 10;
        }
        else {
            count = 0;
        }
    }     
}