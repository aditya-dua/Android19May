package com.adityadua.testingdeploymentdemo19m;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    int result;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void multiplication_isValid(){
        assertEquals("There seems an error",4*2,result);
    }

    @Before
    public void setData(){
        result = 10;
    }


}