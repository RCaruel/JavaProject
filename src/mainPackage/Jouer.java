package mainPackage;

import java.util.Scanner;

public class Jouer {

    /**
     *
     * @param database
     * @param scanner
     */

    public static void play(Database database, Scanner scanner){

        database.mapPlayer1[0][0] = "312";
        database.mapPlayer1[0][1] = "191";
        database.mapPlayer1[0][2] = "071";
        database.mapPlayer1[0][3] = "192";
        database.mapPlayer1[0][4] = "072";
        database.mapPlayer1[1][0] = "332";
        database.mapPlayer1[1][1] = "500";
        database.mapPlayer1[1][2] = "391";
        database.mapPlayer1[1][3] = "392";
        database.mapPlayer1[1][4] = "151";
        database.mapPlayer1[2][0] = "272";
        database.mapPlayer1[2][1] = "031";
        database.mapPlayer1[2][2] = "152";
        database.mapPlayer1[2][3] = "471";
        database.mapPlayer1[2][4] = "032";
        database.mapPlayer1[3][0] = "351";
        database.mapPlayer1[3][1] = "472";
        database.mapPlayer1[3][2] = "231";
        database.mapPlayer1[3][3] = "352";
        database.mapPlayer1[3][4] = "111";
        database.mapPlayer1[4][0] = "232";
        database.mapPlayer1[4][1] = "112";
        database.mapPlayer1[4][2] = "431";
        database.mapPlayer1[4][3] = "311";
        database.mapPlayer1[4][4] = "432";

        System.out.println(database.nbJoueurs);
        System.out.println(CalcScore.play(database.mapPlayer1, database));
        //code du jeu

    }

}
