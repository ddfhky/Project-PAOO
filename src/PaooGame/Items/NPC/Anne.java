package PaooGame.Items.NPC;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.States.Levels.LevelFlags;
import PaooGame.States.State;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class Anne extends NPC{

    private Rectangle DetectionHeroRectangle;
    private boolean HeroDetected=false;

    public Anne(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        normalBounds.x = 11;
        normalBounds.y = 14;
        normalBounds.width = 12;
        normalBounds.height = 19;

        image= Assets.Anne;

        DetectionHeroRectangle=new Rectangle((int)x-2*Tile.TILE_WIDTH,(int)y-Tile.TILE_HEIGHT,5*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT);

    }

    @Override
    public void Update() {

        HeroDetected= refLink.GetMap().getItemManager().getHero().getCollisionsBounds(0, 0).intersects(DetectionHeroRectangle);

    }

    @Override
    public void Draw(Graphics g) {

        g.drawImage(image,(int)(x),(int)(y),width,height,null);

      //  if(HeroDetected)
        //    g.drawImage(Assets.mesajNegustor,(int)x- Tile.TILE_WIDTH,(int)y-2*Tile.TILE_HEIGHT,null);

    }

    @Override
    public void die() {

    }

    public void Interact(){

        refLink.GetGame().winState.SetAsCurrent();

    }

}
