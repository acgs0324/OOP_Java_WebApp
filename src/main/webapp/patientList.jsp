<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
  <style>
    body {
      font-family: 'Courier New', monospace;
      margin: 10px;
      padding: 0;
      /*display: flex;*/
      /*color: #FFFFFF;*/
      /*justify-content: center;*/
      /*align-items: center;*/
      /*height: 100vh;*/
    }
    h1 {
      color: #0b0d40;
      font-size: 36px;
      letter-spacing: 2px;
      margin-bottom: 50px;
      text-align: center;
    }
    h2 {
        color: #0b0d40;
        font-size: 24px;
        letter-spacing: 2px;
        margin-bottom: 10px;
    }
    table {
      border: 2px solid black; /* Adjusted border thickness */
      border-collapse: collapse;
      margin-left: auto;
      margin-right: auto; /* Center table on the page */
      width: 100%; /* Adjust as needed */
    }
    th, td {
      border: 1px solid black;
      padding: 5px;
      text-align: center; /* Center text within cells */
    }
    th {
      background-color: #f2f2f2; /* Light grey background for header */
    }
    .back-button {
      display: inline-block;
      background-color: #b3cde0;
      color: #0b0d40;
      font-size: 18px;
      padding: 15px 30px;
      text-decoration: none;
      border-radius: 50px;
      margin-right: 20px;
      transition: background-color 0.3s ease;
      border: none;
      cursor: pointer;
    }

    .back-button:hover {
      background-color: #6497b1;
    }
  </style>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <a href="#" onclick="history.back()" class="back-button">Back to Previous Page</a>
  <h2>Patients List:</h2>
<%--  <table>--%>
<%--    <tr>--%>
<%--      <th>Data</th>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--      List<String> patients = (List<String>) request.getAttribute("patientNames");--%>
<%--      if (patients != null) {--%>
<%--        for (String patient : patients)--%>
<%--        {--%>
<%--          String href = "dummypage.html";--%>
<%--    %>--%>
<%--    <tr>--%>
<%--      <td><%= patient %></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        }--%>
<%--      }--%>
<%--    %>--%>
<%--  </table>--%>
  <table>
    <tr>
      <th>ID</th><th>BIRTHDATE</th><th>DEATHDATE</th><th>SSN</th><th>DRIVERS</th><th>PASSPORT</th>
      <th>PREFIX</th><th>FIRST</th><th>LAST</th><th>SUFFIX</th><th>MAIDEN</th><th>MARITAL</th>
      <th>RACE</th><th>ETHNICITY</th><th>GENDER</th><th>BIRTHPLACE</th><th>ADDRESS</th>
      <th>CITY</th><th>STATE</th><th>ZIP</th>
    </tr>
    <%
      List<List<String>> table = (List<List<String>>) request.getAttribute("table");
      if (table != null && !table.isEmpty()) {
        int numRows = table.get(0).size(); // Assuming all columns have the same number of rows
        for (int row = 0; row < numRows; row++) {
    %>
    <tr>
      <%
        for (List<String> column : table) {
          String cellValue = column.size() > row ? column.get(row) : "";
      %><td><%= cellValue %></td><%
      }
    %>
    </tr>
    <%
        }
      }
    %>
  </table>

<%--  <ul>--%>
<%--    <%--%>
<%--      List<String> patients = (List<String>) request.getAttribute("patientNames");--%>
<%--      for (String patient : patients)--%>
<%--      {--%>
<%--        String href = "dummypage.html";--%>
<%--    %>--%>
<%--    <li><a href="<%=href%>"><%=patient%></a>--%>
<%--    </li>--%>
<%--    <% } %>--%>
<%--  </ul>--%>
<%--    <h2>Patients 2:</h2>--%>
<%--  <ul>--%>
<%--    <%--%>
<%--      List<String> patients_2 = (List<String>) request.getAttribute("patientNames_2");--%>
<%--      for (String patient_2 : patients_2)--%>
<%--      {--%>
<%--        String href = "dummypage.html";--%>
<%--    %>--%>
<%--    <li><a href="<%=href%>"><%=patient_2%></a>--%>
<%--    </li>--%>
<%--    <% } %>--%>
<%--  </ul>--%>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
