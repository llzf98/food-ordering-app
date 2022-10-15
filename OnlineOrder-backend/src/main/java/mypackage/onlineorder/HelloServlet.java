package mypackage.onlineorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import mypackage.onlineorder.entity.Customer;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
   private String message;

   public void init() {
      message = "Hello World!";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.setContentType("application/json");
      ObjectMapper mapper = new ObjectMapper();
      Customer customer= new Customer();
      customer.setEmail("sun@laioffer.com");
      customer.setPassword("123456");
      customer.setFirstName("rick");
      customer.setLastName("sun");
      customer.setEnabled(true);

      response.getWriter().print(mapper.writeValueAsString(customer));
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      Customer customer = new ObjectMapper().readValue(request.getReader(), Customer.class);

      // Print customer information to IDE console
      System.out.println("Email is: " + customer.getEmail());
      System.out.println("First name is: " + customer.getFirstName());
      System.out.println("Last name is: " + customer.getLastName());


      // Return status = ok as response body to the client
      response.setContentType("application/json");
      JSONObject jsonResponse = new JSONObject();
      jsonResponse.put("status", "ok");
      response.getWriter().print(jsonResponse);
   }


   public void destroy() {
   }
}