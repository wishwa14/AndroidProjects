package com.example.wishwa.unittest;

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Wishwa on 21/09/2016.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    @SmallTest
    public void testEditText(){
        EditText et = (EditText) getActivity().findViewById(R.id.editText);
        assertNotNull(et);
    }
    @SmallTest
    public void testButton(){
        Button bt = (Button) getActivity().findViewById(R.id.button);
        assertNotNull(bt);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
