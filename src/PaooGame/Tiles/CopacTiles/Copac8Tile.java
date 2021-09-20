package PaooGame.Tiles.CopacTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Copac8Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Copac8Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.copac8, id);
    }
}



