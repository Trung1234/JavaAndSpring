<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h1>Student List</h1>
    
    <br/><br/>
    <div>
      <table border="1">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Mark</th>
        </tr>
        <c:forEach  items="${students}" var ="student">
        <tr>
          <td>${student.id}</td>
          <td>${student.name}</td>
          <td>${student.mark}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
</body>
</html>