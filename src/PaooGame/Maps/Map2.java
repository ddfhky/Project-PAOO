package PaooGame.Maps;


import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Monsters.MonstruletRosu;
import PaooGame.Items.Monsters.MonstruletVerde;
import PaooGame.RefLinks;
import PaooGame.StaticItem.Cufar;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

public class Map2 extends Map{

    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel1Part2_Layer1.txt",
            "res/Mapa/MapaLevel1Part2_Layer2.txt",
            "res/Mapa/MapaLevel1Part2_Layer3.txt",
            "res/Mapa/MapaLevel1Part2_Layer4.txt"
    };
    public Map2( RefLinks links) {
        super(paths, links);
        background= ImageLoader.LoadImage("res/textures/sky2.jpg");

        itemManager.addItem((new Cufar(refLink,0,4*Tile.TILE_HEIGHT)));

        elementManager.addElement(Element.Piesa3.CreateNew(5* Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));
        elementManager.addElement(Element.Piesa4.CreateNew(20*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        itemManager.addItem(new MonstruletVerde(refLink,9*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        itemManager.addItem(new MonstruletRosu(refLink,4*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(5*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(6*Tile.TILE_WIDTH,8*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(7*Tile.TILE_WIDTH,7*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(8*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(16*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(15*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(14*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(11*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(16*Tile.TILE_WIDTH,7*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(17*Tile.TILE_WIDTH,8*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(18*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(17*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(18*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        Refresh();
    }

}
