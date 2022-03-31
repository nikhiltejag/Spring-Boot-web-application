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
      <form method="post">
        <fieldset class="form-group m-3">
          <label> Description </label>
          <input type="text" name="desc" class="form-control" required />
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
      </form>
    </div>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  </body>
</html>
