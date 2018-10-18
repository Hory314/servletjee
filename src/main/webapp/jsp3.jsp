<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="WEB-INF/views/doc_header.jsp"/>
<p>a = ${empty param.a ? "nie podano" : param.a}</p>
<p>b = ${empty param.b ? "nie podano" : param.b}</p>
<p>${cookie.foo.value}</p>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p><c:out value="${param.a}" default="9" /></p>
<p><c:out value="${param.b}" default="4" /></p>
<jsp:include page="WEB-INF/views/doc_footer.jsp" />