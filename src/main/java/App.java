import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobs", request.session().attribute("jobs"));
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> jobs = request.session().attribute("jobs");
      if (jobs == null) {
        jobs = new ArrayList<Job>();
        request.session().attribute("jobs", jobs);
      }
      String position = request.queryParams("position");
      String company = request.queryParams("company");
      String location = request.queryParams("location");
      String description = request.queryParams("description");
      String startingDate = request.queryParams("startingDate");
      String endingDate = request.queryParams("endingDate");

      Job myJob = new Job(position, company, location, description, startingDate, endingDate);
      jobs.add(myJob);
      model.put("jobs", request.session().attribute("jobs"));
      model.put("formatter", formatter);
      model.put("template","templates/resume.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
