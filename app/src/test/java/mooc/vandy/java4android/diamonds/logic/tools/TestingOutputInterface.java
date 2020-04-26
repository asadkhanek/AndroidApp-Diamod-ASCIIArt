package mooc.vandy.java4android.diamonds.logic.tools;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * IGNORE THIS CLASS.
 * <p>
 * This class exists to assist in the auto-grading framework that we have developed.
 * Knowledge of this class and how it works will not be required in this course at all.
 */
public class TestingOutputInterface  implements OutputInterface{

    String output = "";

    public String getString(){
        return output;
    }

    @Override
    public void print(String text) {
        output += text;
    }

    @Override
    public void print(boolean b) {
        output += b;
    }

    @Override
    public void print(int i) {
        output += i;
    }

    @Override
    public void print(char c) {
        print("" + c);
    }

    @Override
    public void println() {
        output += '\n';
    }

    @Override
    public void println(boolean b) {
        output += b + "\n";
    }

    @Override
    public void println(int i) {
        output += i + "\n";
    }

    @Override
    public void println(String text) {
        output += text + '\n';
    }

    @Override
    public void println(char c) {
        println("" + c);
    }

    @Override
    public void resetText() {
        output = "";
    }

    @Override
    public void log(String logtext) {
        // no op for now.
    }
}
