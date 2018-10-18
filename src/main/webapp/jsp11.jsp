<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/views/doc_header.jsp"/>
<c:out value="${role}" default="guest"/>
<jsp:include page="WEB-INF/views/doc_footer.jsp"/>