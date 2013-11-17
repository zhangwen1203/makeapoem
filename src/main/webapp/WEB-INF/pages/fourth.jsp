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

<form:form method="POST" commandName="poem" action="/home/fourth">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <td><span name="sentence">Fourth Line :</span></td>
            <td><form:input path="newSentence" /></td>
            <td><form:errors path="newSentence" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="next"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>