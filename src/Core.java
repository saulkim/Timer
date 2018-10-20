import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Core extends Application {
    public static void main(String[] args){
	launch(args);
    }

    @Override
    public void start(Stage mainStage){
	mainStage.setTitle("Main Window");

	//menubar
	MenuBar menuBar = new MenuBar();

	//menu --file [] move to separate class maybe if it gets big enough
	final Menu menuFile = new Menu("File");

	//menu --options [] move to separate class
	final Menu menuOption = new Menu("Options");

	//menu -- timer move to separate class
	//** image not showing
        Image hourGlassImage = new Image("file:Untitled.png");
	final Menu menuTimer = new Menu("",new ImageView(hourGlassImage));
	
	//adding menu stuff to menubar
	menuBar.getMenus().addAll(menuFile,menuOption,menuTimer);


	//vbox good for menus? add some canvas within?
	VBox vBox = new VBox(menuBar);
	
	
	//make this part customizable

	//stackpane not suitable for menus because of its default stack behavior pushing things downwards?
	// StackPane root =new StackPane();
	// root.getChildren().addAll(menuBar);	


	Scene defaultScene = new Scene(vBox, 800, 600);
	mainStage.setScene(defaultScene);
	mainStage.show();
    }
}
