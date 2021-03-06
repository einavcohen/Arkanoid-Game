package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * The interface animation.
 *
 * @author Einav Cohen
 * @version 24 may 2018
 */

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor1    the sensor 1
     * @param key1       the key 1
     * @param animation1 the animation 1
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor1, String key1, Animation animation1) {
        this.sensor = sensor1;
        this.key = key1;
        this.animation = animation1;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        this.animation.doOneFrame(d, dt);

        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.stop = true;
        } else {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
