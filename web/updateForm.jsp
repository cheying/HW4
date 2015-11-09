<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pokemon"%>
<% Pokemon pokemon = (Pokemon) request.getAttribute("pokemon");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>

        <div class="wrap"> <!-- div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <h1>Update A Pokemon</h1>
            <div class="main">
                <form name="updateForm" action="updatePokemon" method="get">
                    <fieldset>
                        <label class="right">Pokemon ID:</label>
                        <input type="text" name="id" value="<%= pokemon.getPokemonID()%>" readonly/>
                        <br>
                        <label class="right">Pokemon Name:</label>
                        <input type="text" name="name" value="<%= pokemon.getPokemonName()%>"/>
                        <br>
                        <label class="right">Base Exp:</label>
                        <input type="text" name="basexp" value="<%= pokemon.getBaseExp()%>"/>
                        <br>
                        <label class="right">Type:</label>
                        <input type="text" name="type" value="<%= pokemon.getType()%>"/>
                        <br>
                        <label class="right">Species</label>
                        <input type="text" name="species" value="<%= pokemon.getSpecies()%>"/>
                        <br>
                        <label class="right">Region</label>
                        <input type="text" name="region" value="<%= pokemon.getRegion()%>"/>  
                        <div>
                            <input type="submit" name="submit" value="Update" />
                            <input type="reset" name="clear" value="Clear" />
                        </div>
                        </div>
                </form>
            </div> <!-- close the wrap div -->
    </body>
</html>
