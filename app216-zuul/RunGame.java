
/**
 * Plays the game without creating a game object
 *
 * @Lottie Scragg
 * @12/01/2002
 */
public class RunGame
{   
    private static Game game;
    public static void main(String[] args)
    {
        game = new Game();
        game.play();
    }
}
