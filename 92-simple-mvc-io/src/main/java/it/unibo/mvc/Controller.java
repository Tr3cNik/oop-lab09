package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT = "output.txt";
    private File file;

    /**
     * Create a single deafult file 
     */
    public Controller() {
        this.file = new File(System.getProperty("user.home") + File.separator + DEFAULT);
    }

    /**
     * Set the input file as the current file
     * 
     * @param f
     */
    public void setFile(File f) {
        this.file = f;
    }

    /**
     * Get the current file
     * 
     * @return
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Get the string format of the path of the current file
     * 
     * @return
     */
    public String getPath() {
        return this.file.toPath().toString();
    }

    /**
     * Save in the current file the input string
     * 
     * @param input
     * @throws IOException
     */
    public void saveInput(String input) throws IOException {
        Files.writeString(file.toPath(), input);
    }

}
