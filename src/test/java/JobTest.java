import org.junit.*;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobTest {
  @Test
  public void job_testingConstructor_true(){
    String position = "";
    String company = "";
    String location = "";
    String description = "";
    String startingDate = "";
    String endingDate = "";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    assertEquals(true, testJob instanceof Job);
  }
  @Test
  public void job_testingGetStartingDate_dateinyyyyMMdd(){
    String position = "";
    String company = "";
    String location = "";
    String description = "";
    String startingDate = "1991-06-06";
    String endingDate = "";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String stringDate = formatter.format(testJob.getStartingDate());
    assertEquals(startingDate,stringDate);
  }
  @Test
  public void job_testingGetEndingDate_dateinyyyyMMdd(){
    String position = "";
    String company = "";
    String location = "";
    String description = "";
    String startingDate = "";
    String endingDate = "1999-12-31";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String stringDate = formatter.format(testJob.getEndingDate());
    assertEquals(endingDate,stringDate);
  }
  @Test
  public void job_testinggetposition_mgr(){
    String position = "mgr";
    String company = "";
    String location = "";
    String description = "";
    String startingDate = "";
    String endingDate = "";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    assertEquals(position, testJob.getPosition());
  }
  @Test
  public void job_testingGetCompany_spark(){
    String position = "";
    String company = "spark";
    String location = "";
    String description = "";
    String startingDate = "";
    String endingDate = "";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    assertEquals(company, testJob.getCompany());
  }
  @Test
  public void job_testingGetLocation_here(){
    String position = "";
    String company = "";
    String location = "here";
    String description = "";
    String startingDate = "";
    String endingDate = "";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    assertEquals(location, testJob.getLocation());
  }
  @Test
  public void job_testingGetDescription_fuckit(){
    String position = "";
    String company = "";
    String location = "";
    String description = "fuckit";
    String startingDate = "";
    String endingDate = "";
    Job testJob = new Job( position, company, location, description, startingDate, endingDate);
    assertEquals(description, testJob.getDescription());
  }

}
