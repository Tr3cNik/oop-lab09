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
     * Create a single deafult file.
     */
    public Controller() {
        this.file = new File(System.getProperty("user.home") + File.separator + DEFAULT);
    }

    /**
     * Set the input file as the current file.
     * 
     * @param f the file setted
     */
    public void setFile(final File f) {
        this.file = f;
    }

    /**
     * Get the current file.
     * 
     * @return the current file of the controller
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Get the string format of the path of the current file.
     * 
     * @return the string rappresentation of the file's path 
     */
    public String getPath() {
        return this.file.toPath().toString();
    }

    /**
     * Save in the current file the input string.
     * 
     * @param input the string to be saved
     * @throws IOException if input is null
     */
    public void saveInput(final String input) throws IOException {
        Files.writeString(file.toPath(), input);
    }

}
