/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author emanu
 */
public class SQLiteConnect {

    Connection conn = null;

    public Connection open() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Gestor");
            return conn;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
