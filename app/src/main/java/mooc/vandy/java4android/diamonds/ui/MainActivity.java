package mooc.vandy.java4android.diamonds.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import mooc.vandy.java4android.diamonds.R;

import mooc.vandy.java4android.diamonds.logic.Logic;
import mooc.vandy.java4android.diamonds.logic.LogicInterface;

/**
 * The main UI of the App.
 */
public class MainActivity 
       extends AppCompatActivity 
       implements OutputInterface {
    /**
     * String for LOGGING.
     */
    private final static String LOG_TAG =
        MainActivity.class.getCanonicalName();

    /**
     * Logic Instance.
     */
    private LogicInterface mLogic;

    /**
     * EditText that stores the output.
     */
    private TextView mOutput;

    /**
     * The Spinner (drop down selector) that you choose which size to
     * use.
     */
    private Spinner mSizeSpinner;

    /**
     * Called when the activity is starting.
     *
     * Similar to 'main' in C/C++/Standalone Java
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // required
        super.onCreate(savedInstanceState);

        // create a new 'Logic' instance.
        mLogic = new Logic(this);

        // setup the UI.
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Initialize the views.
        mOutput = findViewById(R.id.outputET);
        mSizeSpinner = findViewById(R.id.sizeSpinner);

        // Initialize the adapter that binds the data to the mMathSpinner widget.
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,
                R.array.diamondSizes,
                android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associate the ArrayAdapter with the Spinner.
        mSizeSpinner.setAdapter(mAdapter);
    }

    /**
     * Called when Button is Pressed.
     *
     * @param buttonPress
     */
    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process(Integer.valueOf(mSizeSpinner.getSelectedItem().toString()));
    }

    /**
     * Add @a string to the EditText.
     */
    private void addToEditText(String string) {
        mOutput.setText("" + mOutput.getText() + string);
    }

    /**
     * Return the string.
     */
    @Override
    public String getString() {
        return mOutput.getText().toString();
    }

    /**
     * This prints to the output a string
     *
     * @param text
     */
    @Override
    public void print(String text) {
        Log.d(LOG_TAG, "print(String)");
        addToEditText(text);
    }

    /**
     * This prints to the output a char
     *
     * @param c
     */
    @Override
    public void print(char c) {
        Log.d(LOG_TAG, "print(char): " + c);
        print("" + c);
    }

    /**
     * This prints a boolean to the screen
     *
     * @param b
     */
    @Override
    public void print(boolean b) {
        Log.d(LOG_TAG, "print(boolean): " + b);
        print("" + b);
    }

    /**
     * This prints an int to the screen
     *
     * @param i
     */
    @Override
    public void print(int i) {
        Log.d(LOG_TAG, "print(int): " + i);
        print("" + i);
    }

    /**
     * This prints a newline to the screen
     */
    @Override
    public void println() {
        Log.d(LOG_TAG, "println()");
        addToEditText("\n");
    }

    /**
     * This prints to the screen a string then a new line
     *
     * @param text
     */
    @Override
    public void println(String text) {
        Log.d(LOG_TAG, "println(String): " + text);
        addToEditText(text + "\n");
    }

    /**
     * This prints to the screen a char then a new line
     *
     * @param c
     */
    @Override
    public void println(char c) {
        Log.d(LOG_TAG, "println(char): " + c);
        println("" + c);
    }

    /**
     * This prints to the screen a boolean then a new line
     *
     * @param b
     */
    @Override
    public void println(boolean b) {
        Log.d(LOG_TAG, "println(boolean): " + b);
        println("" + b);
    }

    /**
     * This prints to the screen an int then a new line
     *
     * @param i
     */
    @Override
    public void println(int i) {
        Log.d(LOG_TAG, "println(int): " + i);
        println("" + i);
    }

    /**
     * Reset the on-screen output (EditText box).
     */
    @Override
    public void resetText() {
        Log.d(LOG_TAG, "resetText()");
        mOutput.setText("");
    }

    /**
     * Log the @a logtext to logcat.
     * </p>
     * This method is exists to allow the Logic class to log statements to logcat (without
     * requiring the passing of the MainActivity's Context.
     */
    @Override
    public void log(String logtext) {
        Log.d(LOG_TAG, logtext);
    }
}
