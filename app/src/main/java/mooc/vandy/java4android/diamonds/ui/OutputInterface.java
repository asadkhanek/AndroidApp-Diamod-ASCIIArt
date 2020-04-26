package mooc.vandy.java4android.diamonds.ui;

/**
 * Define the methods that the User Interface [MainActivity] will
 * implement. Ignore this interface for now - they will be covered
 * later in this course.
 */
public interface OutputInterface {
    /**
     * Return the string.
     */
    String getString();

    /**
     * This prints a string to the screen
     * @param text
     */
    void print(String text);

    /**
     * This prints a char to the screen
     * @param c
     */
    void print(char c);

    /**
     * This prints a boolean to the screen
     * @param b
     */
    void print(boolean b);

    /**
     * This prints an int to the screen
     * @param i
     */
    void print(int i);

    /**
     * This prints a newline to the screen
     */
    void println();

    /**
     * This prints to the screen a string then a new line
     * @param text
     */
    void println(String text);

    /**
     * This prints to the screen a char then a new line
     * @param c
     */
    void println(char c);

    /**
     * This prints to the screen a boolean then a new line
     * @param b
     */
    void println(boolean b);

    /**
     * This prints to the screen an int then a new line
     * @param i
     */
    void println(int i);

    /**
     * Reset the on-screen output (EditText box).
     */
    void resetText();

    /**
     * Log the @a logtext to logcat.
     */
    void log(String logtext);
}
