package view;

import javax.swing.JPanel;

import view.ViewInterface.MenuCard;
import view.menu.menuPanels.*;

public interface ViewInterface {
    /**
     * It starts the application and shows the main menu.
     */
    enum MenuCard {
        HOME(new HomePanel()),
        //SCORES(new ScoresScene()),
        SETTINGS(new SettingsPanel()),
        CREDITS(new InfoPanel());

        private final JPanel panel;

        /**
         * Constructs a new MenuCard.
         * 
         * @param panel
         *      the {@link JPanel} to show when the "card" is selected.
         */
        MenuCard(final JPanel panel) {
            this.panel = panel;
        }

        /**
         * @return the {@link JPanel} associated to the MenuCard.
         */
        public JPanel getPanel() {
            return this.panel;
        }
    }
    
    public void replaceCard(final MenuCard card);
    void closeView();
    public GameScreenPanel getGameScreen();
 

}
