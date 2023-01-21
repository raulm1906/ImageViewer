package view.ui;

import model.Image;

/**
 *
 * @author Raúl Marrero Marichal
 */

public interface ImageDisplay {
    Image current();
    void show(Image image);
}