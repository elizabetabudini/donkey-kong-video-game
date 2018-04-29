package view;

public interface MenuFrameInterface {
    /**
     * disposes the menu frame when a new game is starting
     */
    void dispose();

    /**
     * It displays the menu Frame
     */
    void showMenu();

    /**
     * This method initializes the MenuFrame setting all the MenuCards
     */
    void initialize();
}
