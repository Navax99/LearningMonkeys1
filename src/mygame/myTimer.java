/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.system.*;

/**
 *
 * @author Albert
 */
public class myTimer {
    
    private int totalSeconds;
    private Timer timer;
    
    myTimer(Timer timer){
        this.timer = timer;
    }
    
    public void setTimer(int minutes,int seconds){
        totalSeconds = 60*minutes + seconds;
        timer.reset();
    }
    
    public boolean isfinish(){
        return timer.getTimeInSeconds()>=totalSeconds;
    }
}
