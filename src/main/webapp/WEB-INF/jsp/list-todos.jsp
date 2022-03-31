<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>Todo's for ${name}</title>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>
  <!-- ///home/nikhilteja/.m2/repository/org/webjars/bootstrap/5.1.3 -->
  <body>
    <div class="container">
      <h1>Here, all your todos:</h1>
      <br />
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done ?</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todos}" var="item">
            <tr>
              <td>${item.desc}</td>
              <td>${item.targetDate}</td>
              <td>${item.isDone}</td>
              <td>
                <a href="/delete-todo?id=${item.id}" class="btn btn-warning"
                  >Delete</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <br />
      <a href="/add-todo" class="button">Add a Todo Item</a>
    </div>

    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  </body>
</html>
