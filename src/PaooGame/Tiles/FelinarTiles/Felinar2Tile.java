package PaooGame.Tiles.FelinarTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Felinar2Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Felinar2Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.felinar2, id);
    }
}


