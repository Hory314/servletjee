<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="doc_header.jsp"/>
<form method="post">
    <input type="text" name="title" placeholder="tytuł">
    <input type="text" name="author" placeholder="autor">
    <input type="text" name="isbn" placeholder="isbn">
    <input type="submit">
</form>
<jsp:include page="doc_footer.jsp"/>