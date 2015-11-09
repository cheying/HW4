<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        
        <div class="wrap"> <!-- div to hold all other divs -->
        
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
            
            
        
        <h1>Pokemon Database</h1>
        
        <a href="read">View All Pokemon</a>
        <br>
        <br>
        <a href="search.jsp">Search Pokemon</a>
        
            <%@ include file="includes/footer.jsp" %>
        
        
        </div> <!-- close the wrap div -->
    </body>
</html>
