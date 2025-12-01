package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> list;
    private String nextString;

    /**
     * Constructor for a Simple Controller.
     */
    public SimpleController() {
        this.list = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printOnOutput() {
        if (nextString == null) {
            throw new IllegalStateException("The string is null");
        }
        list.add(nextString);
        System.out.println(nextString); // NOPMD
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextStringToPrint(final String s) {
        this.nextString = s;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getStringHistory() {
        return new LinkedList<>(list);
    }

}
