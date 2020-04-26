package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */

    /** Function to print any string n times **/
    public void printString(String s, int n){
        while(n!=0) {
            mOut.print(s);
            n--;
        }
    }

     /** Function to print top/end border **/
     public void printBorder(int size){
         mOut.print("+");
         printString("-", size*2);
         mOut.println("+");
     }

     /**
     * Function to print a line of the diamond
     * parameters are:
     * size -- the size of the desired diamond
     * lineNo -- the line number to print
     * left -- the string that is the left side of diamond
     * right -- the string that is the right side of diamond
     **/
    public void printLine(int size, int lineNo, String left, String right) {
        mOut.print("|");
        printString(" ",size-lineNo);
        mOut.print(left);
        if (lineNo%2==0) { // is this an even line?
            printString("-",2*(lineNo-1));
        }
        else {
            printString("=",2*(lineNo-1));
        }
        mOut.print(right);
        printString(" ",size-lineNo);
        mOut.println("|");
    }

    /** MAIN FUNCTION **/
    public void process(int size) {
        // TODO -- add your code here
        // Printing top border
        printBorder(size);

        // printing top half of diamond
        for (int i = 1; i < size; i++) {
            printLine(size, i, "/", "\\");
        }

        // print middle of diamond
        printLine(size, size, "<", ">");

        // print bottom half of diamond
        for (int i = size - 1; i >= 1; i--) {
            printLine(size, i, "\\", "/");
        }

        // Printing end border
        printBorder(size);
    }
}
