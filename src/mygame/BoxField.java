/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.asset.*;
import com.jme3.system.Timer;
import com.jme3.system.lwjgl.LwjglTimer;
import java.util.Random;

/**
 *
 * @author albert
 */
class BoxField {

    private Box box;
    private Geometry[][][] geometrys;
    private Material mat_normal;
    private Material mat_catch;
    private int actualx,actualy,actualz;
    private int sizex,sizey,sizez;
    private Random rnd = new Random();
    private boolean finish;
    private boolean found;
    
    public BoxField(AssetManager assetManager ,int i0, int i1, int i2) {
        
        sizex = i0;
        sizey = i1;
        sizez = i2;
        
        box = new Box(1, 1, 1);
        geometrys = new Geometry[i0][i1][i2];
        mat_normal = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_normal.setColor("Blue", ColorRGBA.Blue);
        mat_catch = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat_catch.setColor("Yellow", ColorRGBA.Yellow);

        int boxnum = 0;
        for (int i = 0; i < i0; ++i) {
            for (int j = 0; j < i1; ++j) {
                for (int k = 0; k < i2; ++k) {
                    geometrys[i][j][k] = new Geometry("Box " + boxnum, box);
                    geometrys[i][j][k].setMaterial(mat_normal);
                    ++boxnum;
                }
            }
        }

    }
    
    public void start(){
        finish = false;
        geometrys[actualx][actualy][actualz].setMaterial(mat_normal);
        
        actualx = rnd.nextInt()%sizex;
        actualy = rnd.nextInt()%sizey;
        actualz = rnd.nextInt()%sizez;
        
        geometrys[actualx][actualy][actualz].setMaterial(mat_catch);
        startTimer(1,0);
    }

    private void startTimer(int minutes, int seconds) {
        
    }
    
    private void updateTimer(){
        
    }
    
    public boolean isfinish(){
        return finish;
    }
    
    public boolean youfindit(){
        return found;
    }
    
}
