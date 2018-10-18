<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/views/doc_header.jsp"/>

<c:forEach begin="${start}" end="${end}" var="i">
    <p>${i}</p>
</c:forEach>


<jsp:include page="WEB-INF/views/doc_footer.jsp"/>