package PaooGame.Items.Monsters;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Character;
import PaooGame.RefLinks;
import PaooGame.Tiles.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MonstruletVerde extends Monster {

    //Animation animTransf_dr,animTransf_stg;
    //private BufferedImage image;

    public MonstruletVerde(RefLinks refLink, float x, float y) {
        //constructorul de baza
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT,
                Assets.Monstrulet_Verde_dr);


        //animatia de transformare a monstruletului (atunci cand moare)
        //animTransf_dr=new Animation(500, Assets.Monstrulet_VerdeTransformare_dr);
        //animTransf_stg=new Animation(500,Assets.Monstrulet_VerdeTransformare_stg);

    }

  /*  @Override
    public void Draw(Graphics g) {

        //g.drawImage(Assets.Monstrulet_Verde_dr,(int)(x),(int)(y),width,height,null);

    }*/

    @Override
    public void die() {

    }


}
