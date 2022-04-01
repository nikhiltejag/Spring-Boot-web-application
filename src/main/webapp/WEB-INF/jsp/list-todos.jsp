<%@ include file="common/header.jspf" %> <%@ include
file="common/navigation.jspf"%>

<div class="container">
  <h1>Here, all your todos:</h1>
  <br />
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is it Done ?</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${todos}" var="item">
        <tr>
          <td>${item.desc}</td>
          <td>
            <fmt:formatDate value="${item.targetDate}" pattern="dd/MM/yyyy" />
          </td>
          <td>${item.isDone}</td>
          <td>
            <a href="/update-todo?id=${item.id}" class="btn btn-primary"
              >Update</a
            >
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
<%@ include file="common/footer.jspf"%>
