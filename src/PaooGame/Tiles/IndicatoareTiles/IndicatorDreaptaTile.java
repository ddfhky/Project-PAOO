package PaooGame.Tiles.IndicatoareTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class IndicatorDreaptaTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public IndicatorDreaptaTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.indicatorDreapta, id);
    }

    @Override
    public boolean NextMap() {
        return true;
    }
}
