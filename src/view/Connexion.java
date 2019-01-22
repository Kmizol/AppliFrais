package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Connexion extends Application {
private Stage primaryStage ;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage ;
		
		
		try {
			this.primaryStage  = primaryStage;
			
			
			FXMLLoader acc = new FXMLLoader() ;
			acc.setLocation(Connexion.class.getClassLoader().getResource("view/Connexion.fxml"));
			Pane cnx= (Pane)acc.load();
			Scene scene = new Scene(cnx,800,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
