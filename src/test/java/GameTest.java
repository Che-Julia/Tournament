import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void firstPlayerStronger() {
        Game game = new Game();
        Player ivan = new Player(1, "Ivan", 80);
        Player kolya = new Player(2, "Kolya", 100);

        game.register(ivan);
        game.register(kolya);

        int actual = game.round("Kolya", "Ivan");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWeaker() {
        Game game = new Game();
        Player ivan = new Player(1, "Ivan", 50);
        Player kolya = new Player(2, "Kolya", 30);

        game.register(ivan);
        game.register(kolya);

        int actual = game.round("Kolya", "Ivan");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bothPlayersAreEqual() {
        Game game = new Game();
        Player ivan = new Player(1, "Ivan", 50);
        Player kolya = new Player(2, "Kolya", 50);

        game.register(ivan);
        game.register(kolya);

        int actual = game.round("Kolya", "Ivan");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerDoesNotExist() {
        Game game = new Game();
        Player ivan = new Player(1, "Ivan", 50);
        Player kolya = new Player(2, "Kolya", 50);

        game.register(ivan);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Petya", "Ivan")
        );
    }

    @Test
    public void secondPlayerDoesNotExist() {
        Game game = new Game();
        Player ivan = new Player(1, "Ivan", 50);
        Player kolya = new Player(2, "Kolya", 50);

        game.register(ivan);
        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kolya", "Petya")
        );
    }
}
