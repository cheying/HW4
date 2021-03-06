<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>

        <div class="wrap"> <!-- div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <h1>Add A New Pokemon</h1>

            <div class="addForm">
                <form name="addForm" action="addPokemon" method="get">

                    <label>Pokemon Name:</label>
                    <input type="text" name="name" value="" />
                    <br>
                    <label>Base Experience:</label>
                    <input type="text" name="basexp" value="" />
                    <br>
                    <label>Type:</label>
                    <input type="text" name="type" value="" />
                    <br>
                    <label>Species:</label>
                    <input type="text" name="species" value="" />
                    <br>
                    <label>Region:</label>
                    <input type="text" name="region" value="" />
                    <br>
                    </div>
                    <div class="buttons">
                        <input type="submit" name="submit" value="Submit" />
                        <input type="reset" name="clear" value="Clear" />
                    </div>

                </form>

            </div> <!-- close the wrap div -->


    </body>
</html>
