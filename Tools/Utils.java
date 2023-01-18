package Tools;

import java.util.Scanner;

public class Utils {
    // -- Attributes --

    private static Scanner scanner = new Scanner(System.in);
    private static String[] loaderSymbols = new String[]{
            "\u001b[31;1m♥\u001b[0m",
            "\u001b[33;1m♦\u001b[0m",
            "\u001b[32;1m♣\u001b[0m",
            "\u001b[35;1m♠\u001b[0m"
    };


    // -- Methods --

    public static String getUserInput(String message, String[] needToBeEqual){
        boolean restart = false;
        String userInput;

        do{
            System.out.println(message+"\n");

            userInput = scanner.nextLine();
            System.out.print("\u001b[3A\u001b[0J");

            for(String symbol: needToBeEqual){
                restart = !userInput.equals(symbol);

                if(!restart) break;
            }
        } while(restart);

        return userInput;
    }

    public static void animateSentence(String sentence, int loop) throws InterruptedException {
        for (int x = 0; x < loop; x++) {
            for (int y = 0; y < loaderSymbols.length ; y++) {
                Thread.sleep(100);
                System.out.print(sentence + loaderSymbols[y] + "\r");
            }
        }
    }

    public static void clearConsole(){
        System.out.print("\u001b[2J");
    }

    public static void spinAnimation(int to, String[][] boardNumbers) throws InterruptedException {
        for (int x = 0; x < 3; x++) {
            if (x < 2){
                for(String[] boardNumber: boardNumbers){
                    String backgroundColor = boardNumber[1].equals("rouge") ? "\u001b[41;1m\u001b[37m" : "\u001b[42m\u001b[30m";

                    System.out.print(" " + backgroundColor + " " + boardNumber[0] + " \u001b[0m   \r");
                    Thread.sleep(100);
                }
            } else {
                for (int i = 0; i < to; i++) {
                    String backgroundColor = boardNumbers[i][1].equals("rouge") ? "\u001b[41;1m\u001b[37m" : "\u001b[42m\u001b[30m";

                    if(i == to - 1){
                        System.out.println(" " + backgroundColor + " " + boardNumbers[i][0] + " \u001b[0m   ");
                    } else {
                        System.out.print(" " + backgroundColor + " " + boardNumbers[i][0] + " \u001b[0m   \r");
                    }

                    if(i >= (to - 1) / 2){
                        Thread.sleep(400);
                    }
                    else if(i >= (to - 1) / 3){
                        Thread.sleep(300);
                    }
                    else if(i >= (to - 1) / 4){
                        Thread.sleep(200);
                    } else {
                        Thread.sleep(100);
                    }
                }
            }
        }
    }
}
