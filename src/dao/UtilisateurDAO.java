package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Utilisateur;
import utils.ConnexionDB;

public class UtilisateurDAO {

    public Utilisateur login(String username, String password) {

        Utilisateur u = null;

        try {
            Connection con = ConnexionDB.getConnection();
            String sql = "SELECT * FROM utilisateur WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Utilisateur();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }
}
