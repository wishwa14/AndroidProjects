package com.example.wishwa.unittest;

import android.support.test.filters.SmallTest;

import junit.framework.TestCase;

/**
 * Created by Wishwa on 21/09/2016.
 */

public class MainActivityUnitTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testchecker(){
        Calculator ma = new Calculator();
        int result = ma.checker(2,5);
        assertEquals(3,result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
