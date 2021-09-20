package PaooGame.Tiles.ScaraTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Scara1Tile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Scara1Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.scara1, id);
    }

    @Override
    public boolean OnLadder() {
        return true;
    }
}
