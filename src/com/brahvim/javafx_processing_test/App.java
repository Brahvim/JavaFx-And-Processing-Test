package com.brahvim.javafx_processing_test;

import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import processing.core.PApplet;

// PROCESSING CANNOT USE JavaFX FOR RENDERING UNLESS WE TELL THE JVM TO EXPORT JavaFX MODULES.
// See `launch.json` for JVM arguments.

public class App extends Application {

	private static final AtomicBoolean isRunning = new AtomicBoolean();

	@Override
	public void start(final Stage p_stage) throws Exception {
		Platform.setImplicitExit(true);
		App.isRunning.set(true);

		final Menu layoutMenu = new Menu("Layout");
		final Menu listsMenu = new Menu("Lists");
		final Menu aboutMenu = new Menu("About");

		final MenuBar menuBar = new MenuBar(

				layoutMenu,
				listsMenu,
				aboutMenu

		);

		final BorderPane root = new BorderPane();
		final Scene scene = new Scene(root, 400, 300);
		root.setTop(menuBar);

		p_stage.initStyle(StageStyle.UNDECORATED);

		p_stage.setTitle("Example");
		p_stage.setScene(scene);
		p_stage.show();
	}

	@Override
	public void stop() throws Exception {
		App.isRunning.set(false);

		if (!Sketch.isRunning())
			System.exit(0);
	}

	public static boolean isRunning() {
		return App.isRunning.get();
	}

	public static void main(final String[] p_args) {
		// Do any parsin' here, bud!

		final PApplet sketch = new Sketch();
		new Thread(Application::launch).start();
		PApplet.runSketch(

				new String[] { sketch.getClass().getSimpleName() },
				sketch

		);
	}

}
