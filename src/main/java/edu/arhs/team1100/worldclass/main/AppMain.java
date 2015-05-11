package edu.arhs.team1100.worldclass.main;

import edu.arhs.team1100.worldclass.handlers.MatchHandler;
import edu.arhs.team1100.worldclass.objects.Match;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMain {

    public static void main(String[] args) {
        PrintWriter writer = null;
        try {
            File file = new File("nboroqual2014text.txt");
            writer = new PrintWriter(file);
            List<Match> matches = MatchHandler.getMatches();
            for (Match m : matches) {
                writer.write(m.getMatchNumber() + ",");
                writer.write(m.getTeamNumber() + ",");
                writer.write(m.isBasketInBase() + ",");
                writer.write(m.isIdenticalPlusInBase() + ",");
                writer.write(m.isDoorOpen() + ",");
                writer.write(m.getLoopsOnScale() + ",");
                writer.write(m.isPeopleAndModel() + ",");
                writer.write(m.isModelInCirlce()+ ",");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }

    public static void main2(String[] args) {
        String argAddress = "", argUsername = "", argPassword = "";

        if (args.length != 0) {
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].equals("-ip")) {
                    argAddress = args[i + 1];
                } else if (args[i].equals("-u")) {
                    argUsername = args[i + 1];
                } else if (args[i].equals("-p")) {
                    argPassword = args[i + 1];
                }
            }
            new Client(argUsername, argPassword, argAddress).run();

        } else {
            new Client().run();
        }
    }
}
