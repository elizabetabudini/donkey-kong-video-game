package view;

import javax.swing.JFrame;

public final class ClosureHandler {

        private static final ClosureHandler CLOSUREHANDLER = new ClosureHandler();

        private ClosureHandler() {
        };

        /**
         * Getter of the singleton.
         * 
         * @return The singleton instance of the class.
         */
        static ClosureHandler getClosureHandler() {
            return ClosureHandler.CLOSUREHANDLER;
        }

 
        static void closeGame(final JFrame frame) {
           
            System.exit(0);
        }
}
