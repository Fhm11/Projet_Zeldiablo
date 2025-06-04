package gameLaby.laby;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class FinDuJeu {

    public static void afin(Stage s, boolean v) {
        Stage pop = new Stage();
        pop.initModality(Modality.APPLICATION_MODAL);
        pop.setTitle("Fin du jeu");
        VBox root = new VBox(30);
        root.setAlignment(Pos.CENTER);
        Text message;
        if (v) {
            message = new Text("VICTOIRE !");
        } else {
            message = new Text("PERDU !");
        }
        message.setFont(Font.font("Verdana", 50));

        Button boutonQuitter = new Button("Quitter");
        boutonQuitter.setOnAction(e -> {
            pop.close();
            s.close();  
        });
        
        pop.setOnCloseRequest(event -> {
            s.close();
        });

        root.getChildren().addAll(message, boutonQuitter);

        Scene sceneFin = new Scene(root, 600, 400);
        pop.setScene(sceneFin);
        pop.show();
    }
}
