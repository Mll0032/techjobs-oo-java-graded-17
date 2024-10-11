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

@Test
public void testToStringStartsAndEndsWithNewLine() {
    Job job = new Job("Name",
            new Employer("Employer"),
            new Location("Location"),
            new PositionType("Position"),
            new CoreCompetency("Skill"));
    String jobString = job.toString();
    String newLine = System.lineSeparator();

    assertTrue(jobString.startsWith(newLine));
    assertTrue(jobString.endsWith(newLine));
}

@Test
    public void testToStringContainsCorrectLabelsAndData() {
    Job job = new Job("Name",
            new Employer("Employer"),
            new Location("Location"),
            new PositionType("Position"),
            new CoreCompetency("Skill"));
    String newLine = System.lineSeparator();
    String expected = newLine +
            "ID: " + job.getId() + newLine +
            "Name: Name" + newLine +
            "Employer: Employer" + newLine +
            "Location: Location" + newLine +
            "Position Type: Position" + newLine +
            "Core Competency: Skill" + newLine;
    assertEquals(expected, job.toString());
}

@Test
public void testToStringHandlesEmptyField() {
    Job job = new Job("",
            new Employer(""),
            new Location(""),
            new PositionType(""),
            new CoreCompetency(""));
    String newLine = System.lineSeparator();
    String expected = newLine +
            "ID: " + job.getId() + newLine +
            "Name: Data not available" + newLine +
            "Employer: Data not available" + newLine +
            "Location: Data not available" + newLine +
            "Position Type: Data not available" + newLine +
            "Core Competency: Data not available" + newLine;
    assertEquals(expected, job.toString());
}

}
