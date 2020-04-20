package exceptions.examples;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        try {
            game.saveGame();
        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
    }
}
