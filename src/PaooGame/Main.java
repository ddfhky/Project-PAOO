package PaooGame;

import PaooGame.GameWindow.GameWindow;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = Game.GetInstance("Find Her", 704, 384);
        paooGame.StartGame();
    }
}
