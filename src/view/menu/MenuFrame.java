package view.menu;

import javax.swing.JPanel;


import view.menu.menuPanels.InfoPanel;
import view.menu.menuPanels.HighScoresPanel;
import view.menu.menuPanels.HomePanel;
//import view.menu.menuPanels.SettingsPanel;

public interface MenuFrame {
    
    enum MenuPanel {
        HOME(new HomePanel()),
        SCORES(new HighScoresPanel()),
        //SETTINGS(new SettingsPanel()),
        INFO(new InfoPanel());

        private final JPanel panel;

        MenuPanel(final JPanel panel) {
            this.panel = panel;
        }
    
        public JPanel getPanel() {
            return this.panel;
        }
    }
 
        void showView();
  
        void replacePanel(MenuPanel panel);
        
        void closeView();

}
