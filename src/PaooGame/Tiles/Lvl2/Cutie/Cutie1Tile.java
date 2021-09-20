package PaooGame.Tiles.Lvl2.Cutie;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Cutie1Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Cutie1Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.cutie1, id);
    }

    public boolean IsSolid()
    {
        return true;
    }
}

