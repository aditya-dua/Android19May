package com.adityadua.testingdeploymentdemo19m;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AdityaDua on 03/06/18.
 */
public class MainActivityTest {
    @Test
    public void checkProduct() throws Exception {

        assertEquals(MainActivity.checkProduct(10,20),200);

    }

}