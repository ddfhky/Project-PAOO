package PaooGame.Tiles.Lvl2.tufis;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Tufis6Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Tufis6Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.tufis6, id);
    }
}

