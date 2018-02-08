/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emanu
 */
public class SQLLogin extends SQLiteConnect {

    public SQLLogin() {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Login("
                    + "UserId INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "User TEXT,"
                    + "Pass TEXT,"
                    + "Perfil TEXT);");

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void create(Login l) {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Login VALUES(?,?,?,?);");
            stm.setString(2, l.getUser());
            stm.setString(3, l.getPass());
            stm.setString(4, l.getPerfil());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void delete() {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Login WHERE UserId = ?;");
            stm.setInt(1, 3);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void update(Login l) {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE Login SET"
                    + "User = ?,"
                    + "Pass = ?,"
                    + "Perfil = ?"
                    + "WHERE UserId = ?");

            stm.setString(1, l.getUser());
            stm.setString(2, l.getPass());
            stm.setString(1, l.getPerfil());
            stm.setInt(4, l.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

    }

    public List<Login> all() {
        ArrayList<Login> result = new ArrayList();
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Login ORDER BY UserId ASC;");

            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SQLLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

        return result;
    }

    public Login isLogin(String User, String Pass) {
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Login WHERE User = ?");
            stm.setString(1, User);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Login l = new Login(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return null;
    }

}
