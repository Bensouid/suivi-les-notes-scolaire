import dao.EtudiantDAO;
import dao.MatiereDAO;
import dao.NoteDAO;

public class GestionNotes {

    public static void main(String[] args) {

        System.out.println("=== Test Gestion des Notes ===");

        // DAO
        EtudiantDAO etudiantDAO = new EtudiantDAO();
        MatiereDAO matiereDAO = new MatiereDAO();
        NoteDAO noteDAO = new NoteDAO();

        // 🧪 Test affichage des étudiants
        System.out.println("\n--- Liste des étudiants ---");
        etudiantDAO.getAllEtudiants();

        // 🧪 Test affichage des matières
        System.out.println("\n--- Liste des matières ---");
        matiereDAO.getAllMatieres();

        // 🧮 Calcul des moyennes
        System.out.println("\n--- Moyenne par étudiant ---");
        noteDAO.calculerMoyenneParEtudiant();
    }
}
