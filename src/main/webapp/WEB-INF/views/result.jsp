<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="doc_header.jsp"/>
<c:forEach var="book" items="${books}">
    <p>"${book.title}", ${book.author}</p>
</c:forEach>
<jsp:include page="doc_footer.jsp"/>