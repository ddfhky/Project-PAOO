package PaooGame.StaticItem;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Cufar extends StaticItem{


    public Cufar(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);

        bounds.x=3;
        bounds.y=(int) (height/2f);
        bounds.width=width-6;
        bounds.height=(int)(height-height/2f);
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.cufar,(int)(x),(int)(y),width,height,null);
    }

    @Override
    public void die() {
        refLink.GetMap().getElementManager().addElement(Element.BluePotion_Element.CreateNew((int)(x),(int)(y)));
    }
}
