<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="doc_header.jsp"/>


<h1>"${book.title}"</h1> <p>${book.author}, (${book.isbn})</p>

<jsp:include page="doc_footer.jsp"/>