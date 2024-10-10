package org.launchcode.techjobs.oo;


import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
@Test
public void testSettingJobId() {
    Job job1 = new Job();
    Job job2 = new Job();
    assertNotEquals(job1.getId(), job2.getId());
}

@Test
public void testJobConstructorSetsAllFields(){
    Job job = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));

    assertEquals("Product tester", job.getName());
    assertTrue(job.getName() instanceof String);
    assertEquals("ACME", job.getEmployer().getValue());
    assertTrue(job.getEmployer() instanceof Employer);
    assertEquals("Desert", job.getLocation().getValue());
    assertTrue(job.getLocation() instanceof Location);
    assertEquals("Quality control", job.getPositionType().getValue());
    assertTrue(job.getPositionType() instanceof PositionType);
    assertEquals("Persistence", job.getCoreCompetency().getValue());
    assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

}

@Test
public void testJobsForEquality() {
    Job job1 = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));
    Job job2 = new Job("Product tester",
            new Employer("ACME"),
            new Location("Desert"),
            new PositionType("Quality control"),
            new CoreCompetency("Persistence"));

    assertFalse(job1.equals(job2));
}

}
