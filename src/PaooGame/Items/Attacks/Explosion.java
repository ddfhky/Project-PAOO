package PaooGame.Items.Attacks;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Explosion extends Attack{

    public Explosion(int x, int y) {
        super(25, Assets.Explosion, Assets.Explosion.length*25, x, y);
    }



}
