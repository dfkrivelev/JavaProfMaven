package homework33;

public class Sega {
    private Games game;

    public void setGame(Games game) {
        this.game = game;
    }

    public void startGame() {
        System.out.println("SEEEGAAAA загрузилась. Можно играть");
        game.playing();
    }
}
