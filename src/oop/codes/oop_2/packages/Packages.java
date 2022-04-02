package src.oop.codes.oop_2.packages;

import src.oop.codes.oop_2.nayaPackage.Msg;

import static src.oop.codes.oop_2.packages.Message.message;

public class Packages {
    public static void main(String[] args) {

        System.out.println("hello oop");
        message();
        Msg.msg();
        // but how does java knows which package is this code from and how
        // is it running here -> by that import statement there

        //How does the Java run-time system know where to look for packages that you create? The answer has three parts.
        //- First, by default, the Java run-time system uses the current working directory as its starting point.
        //Thus, if your package is in a subdirectory of the current directory, it will be found.
        //- Second, you can specify a directory path or paths by setting the CLASSPATH environmental variable.
        //- Third, you can use the -classpath option with java and javac to specify the path to your classes.

    }
}
