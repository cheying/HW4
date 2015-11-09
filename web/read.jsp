<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pokedex</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    <body>
        
        <div class="wrap"> <!-- div to hold all other divs -->
        
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
        
        <h1>Christine's Pokedex</h1>
      
        <%= table %>
        
        <br><br>
        
        <a href="add">Add A New Pokemon</a>
        <br>
        <br>
        <a href="search.jsp">Search Pokemon</a>
        
        </div> <!-- close the wrap div -->
        
    </body>
</html>
