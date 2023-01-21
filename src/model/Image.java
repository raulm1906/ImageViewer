package model;

import java.io.InputStream;

/**
 *
 * @author Raúl Marrero Marichal
 */

public interface Image {

    String name();
    InputStream stream();
    Image next();
    Image prev();
}