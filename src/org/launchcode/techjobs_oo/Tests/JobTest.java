package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;

import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    Job job1;
    Job job2;
    Job job3;

    @Before
    public void createJobObject() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId(){
        assertTrue(job1.getId()+1 == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job3.getName() == "Product tester");
        assertTrue(job3.getEmployer().toString() == "ACME");
        assertTrue(job3.getLocation().toString() == "Desert");
        assertTrue(job3.getPositionType().toString() == "Quality control");
        assertTrue(job3.getCoreCompetency().toString() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testJobForBlankLine(){
        assertEquals(job3.toString(), ("ID: " + job3.getId() + " \n" + "Name: " + job3.getName() + " \n" +
            "Employer: " + job3.getEmployer() + " \n" + "Location: " + job3.getLocation() + " \n" + "Position Type: " +
                job3.getPositionType() + " \n" + "Core Competency: " + job3.getCoreCompetency() + " "));
    }

    @Test
    public void testJobForBlankFields(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location(), new PositionType(), new CoreCompetency());
        assertEquals(job4.toString(), ("ID: " + job4.getId() + " \n" + "Name: " + job4.getName() + " \n" +
                "Employer: " + job4.getEmployer() + " \n" + "Location: " + "Data not available" + " \n" + "Position Type: " +
                "Data not available" + " \n" + "Core Competency: " + "Data not available" + " "));
    }

    @Test
    public void testDoesNotExist(){
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
    }


}
