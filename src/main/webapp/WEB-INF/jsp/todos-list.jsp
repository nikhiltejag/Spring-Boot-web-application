<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>Todo's for ${name}</title>
    <link
      href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>

  <body>
    <div class="container">
      <h1>Here, all your todos:</h1>
      <br />
      <table>
        <thead>
          <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done ?</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todos}" var="item">
            <tr>
              <td>${item.desc}</td>
              <td>${item.targetDate}</td>
              <td>${item.isDone}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <br />
      <a href="/add-todo">Add a Todo Item</a>
    </div>

    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </body>
</html>
