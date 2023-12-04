package dao;

import com.mysql.cj.jdbc.Driver;
import config.Config;
import models.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLQuotesDAO {

    private Connection connection = null;

    public void createConnection(){
        System.out.println("connecting to db");
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException sqlx){
            System.out.println("Error connecting to db ..." + sqlx.getMessage());
        }
    }


    public List<Quote> getQuotes(){
        List<Quote> quotes = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * from quotes");
            while (resultSet.next()){
                quotes.add(new Quote(
                        resultSet.getString("author"),
                        resultSet.getString("content")));
            }

        } catch (SQLException sqlx){
            System.out.println(sqlx.getMessage());
        }

        return quotes;
    }

    public void closeConnection(){
        System.out.println("closing DB connection");
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException sqlx){
                System.out.println(sqlx.getMessage());
            }
        }
    }


    public long insertQuote(){

        // create a connection

        // create a statement & execute it

        // close connection

        return 0;
    }

}
