<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title>List of cards</title></head>
  <body>
    <h1><fmt:message key="cards.heading"/></h1>
    <p>Greetings, it is now <c:out value="${model.time}"/></p>
    <h2>List of cards:</h2>
    <c:forEach items="${model.cards}" var="card">
    	<c:out value="${card.title}" /> <br>
    	<c:out value="${card.description}" /> <br>
    	-----------------------------------------------<br>
    </c:forEach>
    
    <a href="<c:url value="addcard.htm"/>">Add card</a> 
  </body>
</html>