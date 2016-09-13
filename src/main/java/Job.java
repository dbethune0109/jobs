import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Job{
  public String mPosition;
  private String mCompany;
  private String mLocation;
  private String mDescription;
  private Date mStartingDate;
  private Date mEndingDate;
  public Job(String positionInput, String companyInput, String locationInput, String descriptionInput, String startingDateInput, String endingDateInput ){
    mPosition = positionInput;
    mCompany = companyInput;
    mLocation = locationInput;
    mDescription = descriptionInput;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    try{ mStartingDate = formatter.parse(startingDateInput);}
    catch (ParseException e){}
    try{ mEndingDate = formatter.parse(endingDateInput);}
    catch (ParseException e){}
  }
  public Date getStartingDate(){
    return mStartingDate;
  }
  public Date getEndingDate(){
    return mEndingDate;
  }
  public String getPosition(){
    return mPosition;
  }
  public String getCompany(){
    return mCompany;
  }
  public String getLocation(){
    return mLocation;
  }
  public String getDescription(){
    return mDescription;
  }
}
