package utilities;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * This class is used to obtain a new Image from the filename.
 * Since we only need one object of this class, this class is designed using the Singleton pattern to avoid copies.
 */
public final class ImageLoader {
        private static ImageLoader imgl;
	private final Map<String, Image> loadedImages;
	
	/**
         * Creates a new ImageLoader.
         */
        private ImageLoader() {
                this.loadedImages = new HashMap<>();
        }
        
        /**
         * Returns the Singleton instance of the ImageLoader. If it's the
         * first call creates a new instance.
         *
         * @return the Singleton instance of the ImageLoader.
         */
        public static ImageLoader getLoader() {
                if (ImageLoader.imgl == null) {
                        ImageLoader.imgl = new ImageLoader();
                }
                return ImageLoader.imgl;
        }
	

	/**
	 * This method is used to return an Image out of the file represented by the path.
	 * @param path The image's path inside the project folder.
	 * @return An image of the input image.
	 */

	public Image getImage(final String path) {

	    try {
                if (!this.loadedImages.containsKey(path)) {
                        this.loadedImages.put(path, new Image(ImageLoader.class.getResourceAsStream("/" + path)));
                }
                return this.loadedImages.get(path);
        } catch (final Exception e) {
                System.out.println("Error while loading " + path);
        }
        return null;
	}

}