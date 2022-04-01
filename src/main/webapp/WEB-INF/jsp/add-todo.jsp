<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> <%@
include file="common/header.jspf" %> <%@ include file="common/navigation.jspf"%>

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

    <fieldset class="form-group mb-3 mt-3">
      <form:label path="desc"> Target Date </form:label>
      <form:input
        path="targetDate"
        type="text"
        name="targetDate"
        class="form-control"
        required="required"
      />
      <form:errors path="targetDate" cssClass="text-warning" />
    </fieldset>

    <button type="submit" class="btn btn-success">Add</button>
  </form:form>
</div>

<%@ include file="common/footer.jspf"%>
