<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="header" items="${headersList}" >
<p><c:out value="${header}" /></p>
</c:forEach>
<p>Hello World!</p>
