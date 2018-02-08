/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author emanu
 */
public class Login {
    int id;
    String user;
    String pass;
    String perfil;

    public Login(int id, String user, String pass, String perfil) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.perfil = perfil;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    
    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", perfil=" + perfil + '}';
    }
    
    
    
}
