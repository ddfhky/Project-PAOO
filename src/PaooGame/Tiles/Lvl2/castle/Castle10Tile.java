package PaooGame.Tiles.Lvl2.castle;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Castle10Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Castle10Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.castle10, id);
    }
}

