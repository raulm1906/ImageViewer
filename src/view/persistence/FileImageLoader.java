package view.persistence;

import model.Image;

import java.io.*;


/**
 *
 * @author Raúl Marrero Marichal
 */

public class FileImageLoader implements ImageLoader{

    private final File[] files;

    public FileImageLoader(File folder) {
        files = folder.listFiles(imageType());
    }

    public FileFilter imageType(){
        return (File file) -> {
            String filename = file.getPath();
            return filename.endsWith(".png") || filename.endsWith(".jpg")
                    || filename.endsWith(".PNG") || filename.endsWith(".JPG");
        };
    }

    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        if(i < 0 || i >= files.length){
            return null;
        }

        return new Image() {
            @Override
            public String name() {
                return files[i].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream(new FileInputStream(files[i]));
                } catch (FileNotFoundException e){
                    return null;
                }
            }

            @Override
            public Image next() {
                return i == files.length -1? imageAt(0) : imageAt(i+1);
            }

            @Override
            public Image prev() {
                return i == 0 ? imageAt(files.length-1) : imageAt(i-1);
            }
        };
    }
}