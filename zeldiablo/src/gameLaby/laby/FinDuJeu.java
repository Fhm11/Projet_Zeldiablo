package gameLaby.laby;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Modality;

/**
 * Classe utilitaire pour afficher une fenêtre de fin de jeu.
 * Affiche une popup indiquant si le joueur a gagné ou perdu.
 */
public class FinDuJeu  {

    /**
     * Affiche une fenêtre popup indiquant la fin du jeu
     * Affiche un message de victoire ou de défaite
     * @param s la fenêtre principale du jeu à fermer à la fin
     * @param v la victoire, true si le joueur a gagné, false s'il a perdu
     */
    public static void afin(Stage s, boolean v) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Fin du jeu");
        popup.setResizable(false);
        Text message;
        if (v) {
            message = new Text("🎉 BRAVO ! 🎉");
            message.setFill(Color.GREEN);
        } else {
            message = new Text(" PERDU ! ");
            message.setFill(Color.DARKRED);
        }
        message.setFont(Font.font("Arial Black", 48));
        Button btn = new Button("ALT F4");
        btn.setFont(Font.font("Arial", 20));
        btn.setStyle(
                "-fx-background-color: #007ACC; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20 10 20; " +
                        "-fx-background-radius: 10;"
        );
        btn.setOnMouseEntered(e -> btn.setStyle(
                "-fx-background-color: #005A9E; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20 10 20; " +
                        "-fx-background-radius: 10;"
        ));
        btn.setOnMouseExited(e -> btn.setStyle(
                "-fx-background-color: #007ACC; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20 10 20; " +
                        "-fx-background-radius: 10;"
        ));
        btn.setOnAction(e -> {
            popup.close();
            s.close();
        });

        VBox root = new VBox(40, message, btn);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #f0f4f7, #d9e2ec); -fx-padding: 30;");

        Scene scene = new Scene(root, 450, 250);
        popup.setScene(scene);

        popup.show();
    }
}
