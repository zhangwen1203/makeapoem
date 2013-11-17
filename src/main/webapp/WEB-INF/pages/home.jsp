<%@ include file="/WEB-INF/pages/includes/header.jsp"%>

<html>

<body>
<title>Make A Poem</title>
<h2>Make A Poem</h2>

<form:form method="POST" commandName="poem" action="/home">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <td><span name="sentence">First Line :</span></td>
            <td><form:input path="newSentence" name = "newSentence"/></td>
            <td><form:errors path="newSentence" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="next"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>