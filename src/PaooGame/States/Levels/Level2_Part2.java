package PaooGame.States.Levels;

import PaooGame.Items.Hero;
import PaooGame.Maps.Map3;
import PaooGame.Maps.Map4;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.Set;

public class Level2_Part2 extends PlayState {

    public Level2_Part2(RefLinks refLink) {
        super(refLink);
        map= MapFactory.Create(4,refLink);
    }

    @Override
    public void Update() {
        refLink.SetMap(map);
        super.Update();
        Hero hero=refLink.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(21* Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);

        if(ComingFromRight && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(20*Tile.TILE_WIDTH);
            ComingFromRight=false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }

        if(heroBounds.intersects(auxiliar) && LevelFlags.level2_part2_passed())
            State.SetState(refLink.GetGame().level2_Part3);

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
            State.SetState(refLink.GetGame().level2_Part1);
            ComingFromLeft=true;
        }

    }

}
