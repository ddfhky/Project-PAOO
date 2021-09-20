package PaooGame.States.Levels;

import PaooGame.Items.Hero;
import PaooGame.Maps.Map3;
import PaooGame.Maps.Map5;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Level2_Part3 extends PlayState {


    public Level2_Part3(RefLinks refLink) {
        super(refLink);
        map= MapFactory.Create(5,refLink);
    }

    @Override
    public void Update() {
        refLink.SetMap(map);
        super.Update();
        Hero hero=refLink.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(21* Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        if(heroBounds.intersects(auxiliar))
            State.SetState(refLink.GetGame().winState);

        auxiliar=new Rectangle(0,9*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);


        if(ComingFromLeft && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(Tile.TILE_WIDTH);
            ComingFromLeft =false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }


        if(heroBounds.intersects(auxiliar))
        {
            State.SetState(refLink.GetGame().level2_Part2);
            ComingFromLeft=true;
        }

    }

}
