package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Method for printing in the standard output.
     */
    void printOnOutput();

    /**
     * Method for setting the next string to be printed.
     * 
     * @param s the string to be setted
     */
    void setNextStringToPrint(String s);

    /**
     * Method for getting the next string to be printed.
     * 
     * @return the next string
     */
    String getNextStringToPrint();

    /**
     * Method for getting all the strings printed.
     * 
     * @return a list of all strings printed
     */
    List<String> getStringHistory();
}
