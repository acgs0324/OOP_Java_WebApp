package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/search.html")
public class SearchServlet extends HttpServlet
{
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//  {
//    // Use the model to do the search and put the results into the request object sent to the
//    // Java Server Page used to display the results.
//    Model model = ModelFactory.getModel();
//    Set<Integer> searchResult = model.search(request.getParameter("search_string"));
//    request.setAttribute("result", searchResult);
//    List<String> columnNames = model.get("FIRST");
//    request.setAttribute("columnNames", columnNames);
//
//    // Invoke the JSP page.
//    ServletContext context = getServletContext();
//    RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
//    dispatch.forward(request, response);
//  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String search_string = request.getParameter("search_string");
    Model model = ModelFactory.getModel();
    List<List<String>> searchTable = model.getTable();

    if (search_string != null && !search_string.isEmpty()) {
      System.out.println("Search string: " + search_string);
      searchTable= model.searchTable(search_string);
    }
    request.setAttribute("searchResults", searchTable);
    request.setAttribute("search_string", search_string);

    RequestDispatcher dispatch = request.getRequestDispatcher("/search.jsp");
    dispatch.forward(request, response);
  }
}
