import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {

    public static void main(String[] args) {

        try {
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestion_notes",
                "root",
                ""
            );

            System.out.println("Connexion réussie ✅");

        } catch (SQLException e) {
            System.out.println("Erreur ❌");
            e.printStackTrace();
        }
    }
}
