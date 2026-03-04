public class App{

    public static void main(String[] args){

        GameConfig config = new GameConfig(4, 1, 50);
        Game game = new Game(config);
        game.runGame();
    }
}