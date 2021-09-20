package PaooGame.Tiles.Lvl2.Cutie;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Cutie5Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Cutie5Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.cutie5, id);
    }

    public boolean IsSolid()
    {
        return true;
    }
}

