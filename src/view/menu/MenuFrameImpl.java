package view.menu;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import utilities.ImageLoader;

public class MenuFrameImpl implements MenuFrame {
    private static final Double HEIGHT = 0.8;
    private static final Double WIDHT = 0.45;

    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    
    private static volatile MenuFrame menuFrame;
    private final JFrame frame;
    
    //creates and initializes a new menu frame
    private MenuFrameImpl() {
        this.frame = new JFrame();
        initialize();
    }
    
    //crea il menu frame solo alla prima chiamata
    public static MenuFrame getMenuFrame() {
        if (menuFrame == null) {
            synchronized (MenuFrameImpl.class) {
                if (menuFrame == null) {
                    menuFrame = new MenuFrameImpl();
                }
            }
        }
        return menuFrame;
    }
    
    private void initialize() {
        this.frame.setTitle("Donkey Kong - MENU");
        ImageIcon icon = ImageLoader.getInstance().getImage("images/donkeyIcon.png");
        this.frame.setIconImage(icon.getImage());
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));
        
        this.frame.getContentPane().setLayout(new CardLayout());
        //associate panel to enum of possible panels
        Arrays.stream(MenuPanel.values()).forEach(p -> frame.getContentPane().add(p.getPanel(), p.name()));
        
    }
    
    @Override
    public void closeView() {
        this.frame.dispose();    
    }
    
    @Override
    public void showView() {
        this.frame.setVisible(true);   
    }

    @Override
    public void replacePanel(MenuPanel panel) {
        Objects.requireNonNull(panel);
        final CardLayout cardLay = (CardLayout) (this.frame.getContentPane().getLayout());
        cardLay.show(this.frame.getContentPane(), panel.name());
        
    }

    

}
