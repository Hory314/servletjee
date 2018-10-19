<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="doc_header.jsp"/>
<form method="post">
    <input type="text" name="title1" placeholder="tytuł">
    <input type="text" name="author1" placeholder="autor">
    <input type="text" name="isbn1" placeholder="isbn">
    <br>
    <input type="text" name="title2" placeholder="tytuł">
    <input type="text" name="author2" placeholder="autor">
    <input type="text" name="isbn2" placeholder="isbn">
    <br>
    <input type="text" name="title3" placeholder="tytuł">
    <input type="text" name="author3" placeholder="autor">
    <input type="text" name="isbn3" placeholder="isbn">
    <br>
    <input type="text" name="title4" placeholder="tytuł">
    <input type="text" name="author4" placeholder="autor">
    <input type="text" name="isbn4" placeholder="isbn">
    <br>
    <input type="text" name="title5" placeholder="tytuł">
    <input type="text" name="author5" placeholder="autor">
    <input type="text" name="isbn5" placeholder="isbn">
    <input type="submit">
</form>
<jsp:include page="doc_footer.jsp"/>