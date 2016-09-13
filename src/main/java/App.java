import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobs", request.session().attribute("jobs"));
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/places", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> jobs = request.session().attribute("jobs");
      if (jobs == null) {
           jobs = new ArrayList<Place>();
           request.session().attribute("jobs", jobs);
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
