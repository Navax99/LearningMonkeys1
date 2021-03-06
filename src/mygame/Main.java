package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private myTimer mytimer = new myTimer(getTimer());
    private BoxField boxfield;
    private PlayerControls playercontrols;
    private PointLight lamp;
    private int score = 0;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        boxfield = new BoxField(rootNode, assetManager, 10, 10, 10);
        boxfield.setRandomBox();
        playercontrols = new PlayerControls(cam, boxfield.getNodeToFind(), inputManager);
        playercontrols.setUp();
        runTimer();
        setUpCam();

    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        if (mytimer.isfinish()) {
            boxfield.setRandomBox();
            playercontrols.setNode(boxfield.getNodeToFind());
            runTimer();
        }
        if (playercontrols.havefound()) {
            ++score;
            System.out.println("You have "+score+ " points");
            boxfield.setRandomBox();
            playercontrols.setNode(boxfield.getNodeToFind());
            runTimer();
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    private void runTimer() {
        mytimer.setTimer(EnvVariables.TIMER_MINUTES, EnvVariables.TIMER_SECONDS);
    }

    private void setUpCam() {
        cam.setLocation(new Vector3f(-2, 2, -2));
        cam.setRotation(cam.getRotation().fromAngleAxis(50 * FastMath.DEG_TO_RAD, Vector3f.UNIT_Y));
        //regenerem la camara perspectiva
        cam.setFrustumPerspective(45f, (float) cam.getWidth() / cam.getHeight(), 0.01f, 1000f);
        flyCam.setMoveSpeed(4);
        
    }
}
