package PaooGame.Maps;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Hero;
import PaooGame.Items.Monsters.MonstruletRosu;
import PaooGame.Items.Monsters.MonstruletVerde;
import PaooGame.RefLinks;
import PaooGame.StaticItem.Cufar;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

public class Map1 extends Map{

    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel1Part1_Layer1.txt",
            "res/Mapa/MapaLevel1Part1_Layer2.txt",
            "res/Mapa/MapaLevel1Part1_Layer3.txt"
    };

    public Map1(RefLinks links) {


        super(paths, links);
        background= ImageLoader.LoadImage("res/textures/sky2.jpg");

        itemManager.addItem((new Cufar(refLink,544,32)));

        elementManager.addElement(Element.Piesa1.CreateNew(3* Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));
        elementManager.addElement(Element.Piesa2.CreateNew(19* Tile.TILE_WIDTH,Tile.TILE_HEIGHT));

        itemManager.addItem(new MonstruletVerde(refLink,7*Tile.TILE_WIDTH,8*Tile.TILE_HEIGHT));
        itemManager.addItem(new MonstruletRosu(refLink,19*Tile.TILE_WIDTH,Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(4*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(5*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(6*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(7*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(13*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(20*Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(21*Tile.TILE_WIDTH,Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(11*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(12*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(17*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(18*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.coin.CreateNew(2*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(3*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(4*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.coin.CreateNew(5*Tile.TILE_WIDTH,9*Tile.TILE_HEIGHT));



        Refresh();

    }

}
