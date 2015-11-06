/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Christine Heying
 */
public class ReadRecord {

    private Connection conn;
    private ResultSet results;

    private Pokemon pokemon = new Pokemon();
    private int pokemonID;

    public ReadRecord(int pokemonID) {

        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");

        this.pokemonID = pokemonID;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doRead() {

        try {
            // set up a string to hold our qury
            String query = "SELECT * FROM pokemon WHERE pokemonID = ?";

            // create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);

            // fill in the preparedstatement
            ps.setInt(1, pokemonID);

            // execute the query
            this.results = ps.executeQuery();

            this.results.next();

            pokemon.setPokemonID(this.results.getInt("pokemonID"));
            pokemon.setPokemonName(this.results.getString("pokemonName"));
            pokemon.setBaseExp(this.results.getInt("baseExp"));
            pokemon.setType(this.results.getString("type"));
            pokemon.setSpecies(this.results.getString("species"));
            pokemon.setRegion(this.results.getString("region"));
       
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Pokemon getPokemon(){
        
        return this.pokemon;
    }
    

}
