package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.ConnexionDB;
import java.sql.PreparedStatement;
public class NoteDAO {
public void ajouterNote(int etudiantId, int matiereId, double valeur) {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = ConnexionDB.getConnection();
        String sql = "INSERT INTO note (etudiant_id, matiere_id, valeur) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, etudiantId);
        ps.setInt(2, matiereId);
        ps.setDouble(3, valeur);
        ps.executeUpdate();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try { if (ps != null) ps.close(); } catch (Exception e) {}
    }
}
public double calculerMoyenne(int idEtudiant) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    double moyenne = 0.0;
    
    try {
        conn = ConnexionDB.getConnection();
String sql = "SELECT AVG(valeur) as moyenne FROM note WHERE etudiant_id = ?";        ps = conn.prepareStatement(sql);
        ps.setInt(1, idEtudiant);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            moyenne = rs.getDouble("moyenne");
        }
        
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    return moyenne;
}
    public void calculerMoyenneParEtudiant() {

        String sql =
            "SELECT e.id, e.nom, e.prenom, " +
            "SUM(n.valeur * m.coefficient) / SUM(m.coefficient) AS moyenne " +
            "FROM note n " +
            "JOIN etudiant e ON n.etudiant_id = e.id " +
            "JOIN matiere m ON n.matiere_id = m.id " +
            "GROUP BY e.id, e.nom, e.prenom";

        try {
            Connection con = ConnexionDB.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("nom") + " " +
                    rs.getString("prenom") +
                    " | Moyenne = " + rs.getDouble("moyenne")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
