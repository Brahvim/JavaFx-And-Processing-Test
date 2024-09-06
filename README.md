# JavaFX-And-Processing-Test

Do Processing and JavaFX apps work together? Yes!  
This repo also shows you how overriding `PApplet::exitActual()` can allow you to ensure that Processing does not close all windows when its own window exits.

Finally, it is important to communicate between both your `PApplet`s and your JavaFX `Stage`s when they have been closed.  
I guess a better way to deal with this is to have a global "registry" of sorts to allow you to register all windows and shutdown the JVM when they have all closed. Or better, do so with two methods that notify of a window starting and closing.

...No automation for stuff like this without hacking into the Swing/JOGL/JavaFX windowing APIs *(or... native calls?!)*, sorry.

Finally, Processing cannot be used with the JavaFX renderer without exporting the right modules - and I think doing it at runtime is the only option if you don't modify your JavaFX SDK's source code to allow unnamed Java modules to access it.

...By "doing it at runtime", I'm referring to JVM flags.  
Now, I gave up on this very quickly due to time constraints, but you can see [how I tried doing it]((https://github.com/Brahvim/JavaFX-And-Processing-Test/tree/main/.vscode/launch.json)). Perhaps read the OpenJDK JVM docs?
