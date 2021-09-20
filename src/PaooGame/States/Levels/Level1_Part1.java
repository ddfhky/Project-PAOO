package PaooGame.States.Levels;

import PaooGame.Items.Hero;
import PaooGame.Maps.Map1;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Level1_Part1 extends PlayState {


    public Level1_Part1(RefLinks refLink) {
        super(refLink);
        map=MapFactory.Create(1,refLink);
    }

    @Override
    public void Update() {
        Hero hero=map.getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(21* Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        refLink.SetMap(map);
        super.Update();


        if(ComingFromRight && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(20*Tile.TILE_WIDTH);
            ComingFromRight =false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }


        if(heroBounds.intersects(auxiliar))
        {
            State.SetState(refLink.GetGame().level1_Part2);
            ComingFromRight =true;
        }
           //System.exit(0);
    }
}
