package PaooGame.Maps;


import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.NPC.Anne;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

public class Map5 extends Map{

    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel2Part3_Layer1.txt",
            "res/Mapa/MapaLevel2Part3_Layer2.txt",
            "res/Mapa/MapaLevel2Part3_Layer3.txt",
            "res/Mapa/MapaLevel2Part3_Layer4.txt"
    };
    public Map5( RefLinks links) {
        super(paths, links);
        background= ImageLoader.LoadImage("res/textures/backgroundLvl2.png");

        elementsToBeRefreshed.add(Element.coin.CreateNew(5*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(6*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(7*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(8*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(9*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(10*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(11*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));


        elementsToBeRefreshed.add(Element.coin.CreateNew(2*Tile.TILE_WIDTH,0));
        elementsToBeRefreshed.add(Element.coin.CreateNew(3*Tile.TILE_WIDTH,0));
        elementsToBeRefreshed.add(Element.coin.CreateNew(3*Tile.TILE_WIDTH,8*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(2*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(4*Tile.TILE_WIDTH,7*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(13*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));


        elementsToBeRefreshed.add(Element.coin.CreateNew(9*Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(10*Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(11*Tile.TILE_WIDTH,Tile.TILE_HEIGHT));

        itemManager.addItem(new Anne(refLink,19*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));

        Refresh();
    }

}
