<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>My First web page</title>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>

  <body>
    <div class="container">
      Add Todo page for ${name} <br />
      <form:form method="post" modelAttribute="todo">
        <!-- <form:hidden path="id" /> -->
        <fieldset class="form-group mb-3 mt-3">
          <form:label path="desc"> Description </form:label>
          <form:input
            path="desc"
            type="text"
            name="desc"
            class="form-control"
            required="required"
          />
          <form:errors path="desc" cssClass="text-warning" />
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
      </form:form>
    </div>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  </body>
</html>
