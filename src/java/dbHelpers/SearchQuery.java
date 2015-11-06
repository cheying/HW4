package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pokemon;

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
    
       Properties props = new Properties(); //MWC
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void doSearch (String pokemonName){
    
        try {
            String query = "SELECT * FROM pokemon WHERE UPPER (pokemonName) LIKE ? ORDER BY pokemonID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + pokemonName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public String getHTMLTable(){
   
        String table = "";
        
        table += "<table border=1>";
        
        try {
            
            table += "<tr>";
                table += "<th>";
                table += "Pokemon ID";
                table += "</th>";
                table += "<th>";
                table += "Pokemon Name";
                table += "</th>";
                table += "<th>";
                table += "Base Exp";
                table += "</th>";
                table += "<th>";
                table += "Type";
                table += "</th>";
                table += "<th>";
                table += "Species";
                table += "</th>";
                table += "<th>";
                table += "Region";
                table += "</th>";
                table += "<th>";
                table += "Modify Entry";
                table += "</th>";
                table += "</tr>";
                
            while(this.results.next()){
                
                Pokemon pokemonz = new Pokemon();
                pokemonz.setPokemonID(this.results.getInt("pokemonID"));
                pokemonz.setPokemonName(this.results.getString("pokemonName"));
                pokemonz.setBaseExp(this.results.getInt("baseExp"));
                pokemonz.setType(this.results.getString("type"));
                pokemonz.setSpecies(this.results.getString("species"));
                pokemonz.setRegion(this.results.getString("region"));
                
                table += "<tr>";
                table += "<td>";
                table += pokemonz.getPokemonID();
                table += "</td>";
                
                table += "<td>";
                table += pokemonz.getPokemonName();
                table += "</td>";
                
                table += "<td>";
                table += pokemonz.getBaseExp();
                table += "</td>";
                
                table += "<td>";
                table += pokemonz.getType();
                table += "</td>";

                table += "<td>";
                table += pokemonz.getSpecies();
                table += "</td>";

                table += "<td>";
                table += pokemonz.getRegion();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?pokemonID=" + pokemonz.getPokemonID() + "> Update </a>" + "<a href=delete?pokemonID=" + pokemonz.getPokemonID() + ">Delete</a>";
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
                return table;
    }
    
}
