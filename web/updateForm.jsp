<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pokemon"%>
<% Pokemon pokemon = (Pokemon) request.getAttribute("pokemon"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Pokemon</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>Update A Pokemon</h1>
        
         <form name="updateForm" action="updatePokemon" method="get">
            
            <table class="update"
                <tr>
                    <td class="right">Pokemon ID:</td>
                    <td> <input type="text" name="name" value="<%= pokemon.getPokemonID() %>" /></td>
                </tr>
                <tr>
                    <td class="right">Pokemon Name:</td>
                    <td><input type="text" name="name" value="<%= pokemon.getPokemonName() %>" /></td>
                </tr>
                <tr>
                    <td class="right">Base Exp:</td>
                    <td><input type="text" name="basexp" value="<%= pokemon.getBaseExp() %>" /></td>
                </tr>
                <tr>
                    <td class="right">Type:</td>
                    <td><input type="text" name="type" value="<%= pokemon.getPokemonName() %>" /></td>
                </tr>
                <tr>
                    <td class="right">Species:</td>
                    <td><input type="text" name="species" value="<%= pokemon.getPokemonName() %>" /></td>
                </tr>
                <tr>
                    <td class="right">Region:</td>
                    <td><input type="text" name="region" value="<%= pokemon.getPokemonName() %>" /></td>
                </tr>
            </table>
            <br>
            <div>
            <input type="submit" name="submit" value="Update" />
            <input type="reset" name="clear" value="Clear" />
            </div>
        </form>
    </body>
</html>
