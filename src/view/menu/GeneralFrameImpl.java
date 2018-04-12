package view.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GeneralFrameImpl implements GeneralFrameInterface {
    
 private static final String FRAME_NAME = "DonkeyKong";
    
    private static final double WIDTH_PERC = 0.25;
    private static final double HEIGHT_PERC = 0.5;
    private static volatile GeneralFrameInterface generalFrame;
    private final JFrame frame;

    /**
     * Constructs a new MainFrame.
     */
    private GeneralFrameImpl() {
        this.frame = new JFrame();
        initialize();
    }
    
    public static GeneralFrameInterface getMenuFrame() {
        if (generalFrame == null) {
            synchronized (GeneralFrameImpl.class) {
                if (generalFrame == null) {
                    generalFrame = new GeneralFrameImpl();
                }
            }
        }
        return generalFrame;
    }
    
    private void initialize() {
        this.frame.setTitle(FRAME_NAME);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));

        this.frame.setLocationByPlatform(true);
       
    }
    
    public void showView() {
        this.frame.setVisible(true);
    }
    
    public void closeView() {
        this.frame.dispose();
    }

}
