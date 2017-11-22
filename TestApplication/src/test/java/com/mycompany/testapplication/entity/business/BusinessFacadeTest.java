/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testapplication.entity.business;

import com.mycompany.testapplication.entity.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class BusinessFacadeTest {

    public BusinessFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOrderedServices method, of class BusinessFacade.
     */
    @org.junit.Test
    
    
    public void testGetOrderedServices() {
        System.out.println("getOrderedServices");
        Date start = null;
        Date end = null;
//        Map<Service, Integer> expResult = null;
        Map<Service, Integer> result = BusinessFacade.getOrderedServices(start, end);
        for (Map.Entry<Service, Integer> entry : result.entrySet()) {
            Service key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Service: " + key);
            System.err.println("Number: " + value);
            if (value > 500 || value < 200) {
                fail("The test case is a prototype.");
            }
        }
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllServices method, of class BusinessFacade.
     */
    @org.junit.Test
    public void testGetAllServices() {
        System.out.println("getAllServices");
        List<Service> expResult = new ArrayList();
        Service service1 = new Service(1, "Pool", 45.5);
        Service service2 = new Service(2, "Fitness", 30);
        Service service3 = new Service(3, "Sauna", 60);

        expResult.add(service1);
        expResult.add(service2);
        expResult.add(service3);

        List<Service> result = BusinessFacade.getAllServices();
        assertEquals(expResult, result);

    }

}
