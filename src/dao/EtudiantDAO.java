package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Etudiant;
import utils.ConnexionDB;
import java.sql.Connection;

public class EtudiantDAO {

    public void ajouterEtudiant(Etudiant e) {

        String sql = "INSERT INTO etudiant(nom, prenom) VALUES (?, ?)";

        try {
            PreparedStatement ps = ConnexionDB
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

// Method bach modifier étudiant
public void modifier(Etudiant e) {
    Connection conn = null;
    PreparedStatement ps = null;
    
    try {
        conn = ConnexionDB.getConnection();
        String sql = "UPDATE etudiant SET nom=?, prenom=? WHERE id=?";
        ps = conn.prepareStatement(sql);
        
        ps.setString(1, e.getNom());
        ps.setString(2, e.getPrenom());
        ps.setInt(3, e.getId());
        
        ps.executeUpdate();
        
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

// Method bach supprimer étudiant
public void supprimer(int id) {
    Connection conn = null;
    PreparedStatement ps = null;
    
    try {
        conn = ConnexionDB.getConnection();
        String sql = "DELETE FROM etudiant WHERE id=?";
        ps = conn.prepareStatement(sql);
        
        ps.setInt(1, id);
        ps.executeUpdate();
        
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
    public List<Etudiant> getAllEtudiants() {

        List<Etudiant> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM etudiant";
            ResultSet rs = ConnexionDB
                    .getConnection()
                    .createStatement()
                    .executeQuery(sql);

            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));

                list.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
}
