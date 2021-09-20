package PaooGame.Maps;


import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.NPC.Negustor;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Map3 extends Map{

    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel2Part1_Layer1.txt",
            "res/Mapa/MapaLevel2Part1_Layer2.txt",
            "res/Mapa/MapaLevel2Part1_Layer3.txt"
    };

    public Map3( RefLinks links) {
        super(paths, links);
        background= ImageLoader.LoadImage("res/textures/backgroundLvl2.png");

        elementsToBeRefreshed.add(Element.coin.CreateNew(3* Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(4*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(10*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(11*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(13*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(13*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(14*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(16*Tile.TILE_WIDTH,0));
        elementsToBeRefreshed.add(Element.coin.CreateNew(17*Tile.TILE_WIDTH,0));
        elementsToBeRefreshed.add(Element.coin.CreateNew(18*Tile.TILE_WIDTH,0));

        elementsToBeRefreshed.add(Element.coin.CreateNew(10*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(8*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(6*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(14*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));


        itemManager.addItem(new Negustor(refLink,10*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));

        Refresh();
    }

    @Override
    public void Update()
    {
        super.Update();
        Rectangle water=new Rectangle(5*Tile.TILE_WIDTH,11*Tile.TILE_HEIGHT,2*Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        if(itemManager.getHero().getCollisionsBounds(0,0).intersects(water))
        {
            itemManager.getHero().SetX(2*Tile.TILE_WIDTH);
            itemManager.getHero().SetY(9*Tile.TILE_HEIGHT);
        }
    }

}
