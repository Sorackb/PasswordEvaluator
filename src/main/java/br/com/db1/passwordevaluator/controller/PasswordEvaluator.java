package br.com.db1.passwordevaluator.controller;

import br.com.db1.passwordevaluator.businessrule.Evaluator;
import br.com.db1.passwordevaluator.model.Request;
import br.com.db1.passwordevaluator.model.Report;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/")
public class PasswordEvaluator {

  @POST
  @Produces("application/json")
  public Report evaluate(Request request) {

    try {
      return Evaluator.evaluate(request.getPassword());
    } catch (ReflectiveOperationException ex) {
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
