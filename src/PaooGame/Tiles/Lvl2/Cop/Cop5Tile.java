package PaooGame.Tiles.Lvl2.Cop;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Cop5Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Cop5Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.cop5, id);
    }
}

