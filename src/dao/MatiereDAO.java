package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Matiere;
import utils.ConnexionDB;

public class MatiereDAO {

    public void ajouterMatiere(Matiere m) {

        String sql = "INSERT INTO matiere(libelle, coefficient) VALUES (?, ?)";

        try {
            PreparedStatement ps = ConnexionDB
                    .getConnection()
                    .prepareStatement(sql);

            ps.setString(1, m.getLibelle());
            ps.setInt(2, m.getCoefficient());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Matiere> getAllMatieres() {

        List<Matiere> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM matiere";
            ResultSet rs = ConnexionDB
                    .getConnection()
                    .createStatement()
                    .executeQuery(sql);

            while (rs.next()) {
                Matiere m = new Matiere();
                m.setId(rs.getInt("id"));
                m.setLibelle(rs.getString("libelle"));
                m.setCoefficient(rs.getInt("coefficient"));

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
