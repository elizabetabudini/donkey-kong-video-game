package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.entities.Movement;

/**
 * 
 * This class models a listener for keyboard inputs.
 *
 */
public final class InputHandler extends KeyAdapter {

    private final Map<Movement, Boolean> activeInputs;
    private final Map<Integer, Movement> registeredKeys = new HashMap<>();

    /**
     * A constructor for the Inputhandler, it initializes all inputs to false and builds the register of all recognized keys.
     */
    public InputHandler() {
        super();
        activeInputs = EnumSet.allOf(Movement.class).stream().collect(Collectors.toMap(e -> e, e -> false));
        buildRegisteredInputs();
    }

    private void buildRegisteredInputs() {
        registeredKeys.put(KeyEvent.VK_DOWN, Movement.DOWN); // Move Down
        registeredKeys.put(KeyEvent.VK_S, Movement.DOWN);
        registeredKeys.put(KeyEvent.VK_RIGHT, Movement.RIGHT); // Move Right
        registeredKeys.put(KeyEvent.VK_D, Movement.RIGHT);
        registeredKeys.put(KeyEvent.VK_UP, Movement.UP); // Move Up
        registeredKeys.put(KeyEvent.VK_W, Movement.UP);
        registeredKeys.put(KeyEvent.VK_LEFT, Movement.LEFT); // Move Left
        registeredKeys.put(KeyEvent.VK_A, Movement.LEFT);
        registeredKeys.put(KeyEvent.VK_SPACE, Movement.JUMP); // Plant a bomb
    }

    /**
     * Toggles ON the key passed as argument, but only if it is an input
     * acknowledged by the class.
     * 
     * @param e
     *            The key to toggle.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        if (registeredKeys.containsKey(e.getKeyCode())) {
            this.activeInputs.replace(registeredKeys.get(e.getKeyCode()), true);
        }
    }

    /**
     * Toggles OFF the key passed as argument, but only if it is an input
     * acknowledged by the class.
     * 
     * @param e
     *            The key to toggle.
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        if (registeredKeys.containsKey(e.getKeyCode())) {
            this.activeInputs.replace(registeredKeys.get(e.getKeyCode()), false);
        }
    }

    private Boolean isKeyPressed(final Movement input) {
        return this.activeInputs.get(input);
    }

    /**
     * Parses all the registered inputs
     * 
     * @param inputState
     *            True to find all active inputs, false otherwise.
     * @return A set containing all the inputs matching the @param inputState.
     */
    public Set<Movement> parser(final boolean inputState) {
        return activeInputs.keySet().stream().filter(e -> isKeyPressed(e).equals(inputState))
                .collect(Collectors.toSet());
    }

}
