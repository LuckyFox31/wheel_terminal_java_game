import Tools.Sentences;
import Tools.Utils;

import java.util.Random;

public class Game {
    // -- Attributes --

    private static Random random = new Random();

    private String[][] boardNumbers = {
            {"1","rouge"}, {"2","noir"}, {"3","rouge"},
            {"4","noir"}, {"5","rouge"}, {"6","noir"},
            {"7","rouge"}, {"8","noir"}, {"9","rouge"},
            {"10","noir"}, {"11","noir"}, {"12","rouge"},
            {"13","noir"}, {"14","rouge"}, {"15","noir"},
            {"16","rouge"}, {"17","noir"}, {"18","rouge"},
            {"19","rouge"}, {"20","noir"}, {"21","rouge"},
            {"22","noir"}, {"23","rouge"}, {"24","noir"},
            {"25","rouge"}, {"26","noir"}, {"27","rouge"},
            {"28","noir"}, {"29","noir"}, {"30","rouge"},
            {"31","noir"}, {"32","rouge"}, {"33","noir"},
            {"34","rouge"}, {"35","noir"}, {"36","rouge"}
    };


    // -- Init --

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        game.showRules();
        game.start(
            Utils.getUserInput(
                Sentences.startGameSentence + Sentences.yesOrNoAskInput,
                new String[]{"Y", "n"}
            )
        );
    }


    // -- Methods --

    protected void showRules(){
        System.out.println(
                "\n\u001b[35;1m▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\u001b[0m\n" +
                "\u001b[31;1m♠\u001b[0m Bienvenue sur le jeu de la \u001b[36;1mRoulette\u001b[0m ! \u001b[31;1m♠\u001b[0m\n" +
                "\u001b[35;1m▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\u001b[0m\n\n\n" +
                "              \u001b[31;1m-- Règles --\u001b[0m               \n" +
                "• Vous devez misez votre argent\n" +
                "• Vous pouvez miser sur :\n" +
                "  \u001b[33;1m[1]\u001b[0m Couleur \u001b[36;1m(x2)\u001b[0m\n" +
                "  \u001b[33;1m[2]\u001b[0m Pair \u001b[36;1m(x2)\u001b[0m\n" +
                "  \u001b[33;1m[3]\u001b[0m Impair \u001b[36;1m(x2)\u001b[0m\n" +
                "  \u001b[33;1m[4]\u001b[0m Manque (nombre de 0 à 18) \u001b[36;1m(x2)\u001b[0m\n" +
                "  \u001b[33;1m[5]\u001b[0m Passe (nombre de 19 à 36) \u001b[36;1m(x2)\u001b[0m\n" +
                "  \u001b[33;1m[6]\u001b[0m Numéro simple \u001b[36;1m(x36)\u001b[0m\n"
        );
    }

    protected void start(String userInput) throws InterruptedException {
        boolean startGame = userInput.equals("Y");

        Utils.clearConsole();

        if(!startGame){
            Utils.animateSentence(Sentences.exitGameSentence, 4);
            System.exit(0);
        }

        Utils.animateSentence(Sentences.initGameSentence, 4);
        Utils.clearConsole();

        initGame();
    }

    protected void initGame() throws InterruptedException {
        boolean restart;

        do{
            turnWheel();

            restart = Utils.getUserInput(
                    Sentences.reRollWheelSentence + Sentences.yesOrNoAskInput,
                    new String[]{"Y", "n"}
            ).equals("Y");
        } while(restart);
    }

    protected void turnWheel() throws InterruptedException {
        int sortedNumber = random.nextInt(boardNumbers.length) + 1;
        Utils.spinAnimation(sortedNumber, boardNumbers);
    }


    // -- Getters --

    public String[][] getBoardNumbers() {
        return boardNumbers;
    }


    // -- Setters --

    public void setBoardNumbers(String[][] boardNumbers) {
        this.boardNumbers = boardNumbers;
    }
}
