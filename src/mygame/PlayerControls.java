/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.input.*;
import com.jme3.input.controls.*;
import com.jme3.math.Ray;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Albert
 */
public class PlayerControls {

    private InputManager inputManager;
    private Spatial nodetofind;
    private Camera cam;
    private final static Trigger TRIGGER_FOUND = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    private final static String MAPPING_FOUND = "Block Found";
    private boolean found;
    private ActionListener listener = new ActionListener() {
        public void onAction(String name, boolean isPressed, float tpf) {
            if (name.equals(MAPPING_FOUND) && isPressed) {
                CollisionResults results = new CollisionResults();
                Ray ray = new Ray(cam.getLocation(), cam.getDirection());
                nodetofind.collideWith(ray, results);
                if (results.size() > 0) {
                    if (results.getClosestCollision().getDistance() <= EnvVariables.CATCH_DISTANCE) {
                        found = true;
                    }
                }
            }
        }
    };

    public PlayerControls(Camera cam, Spatial nodetofind, InputManager inputManager) {
        this.inputManager = inputManager;
        this.cam = cam;
        this.nodetofind = nodetofind;
    }

    private void setMapping() {
        inputManager.addMapping(MAPPING_FOUND, TRIGGER_FOUND);
    }

    private void setListener() {
        inputManager.addListener(listener, MAPPING_FOUND);
    }

    public boolean havefound() {
        boolean aux = found;
        found = false;
        return aux;
    }

    public void setNode(Spatial nodetofind) {
        this.nodetofind = nodetofind;
    }

    public void setUp() {
        setMapping();
        setListener();
    }
}
