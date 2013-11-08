<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<html>
<body>
<h1>Make A Poem</h1>

<c:forEach var="sentence" items="${sentences}">
    <tr>
        <td><c:out value="${sentence}"></c:out></td>
        <p></p>
    </tr>
</c:forEach>
    <form name="input" action="/home/third" method="post">
        Third line:
        <input type="text" name="third" />
        <input type="submit" value="Next" />
     </form>
</body>
</html>