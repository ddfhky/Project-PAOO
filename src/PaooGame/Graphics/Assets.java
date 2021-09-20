package PaooGame.Graphics;

import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;


/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.

    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;

    public static BufferedImage scara1,scara2,scara3,scara4; //4 dale. scara este impartita in 4 dale
    public static BufferedImage piatra;
    public static BufferedImage floare;
    public static BufferedImage cufar;
    public static BufferedImage iedera1,iedera2;
    public static BufferedImage indicatorDreapta;
    public static BufferedImage indicatorAmbele1, indicatorAmbele2;
    public static BufferedImage copac1,copac2,copac3,copac4,copac5,copac6,copac7,copac8,copac9,copac10,copac11,copac12;
    public static BufferedImage pamant1,pamant2,pamant3,pamant4,pamant5,pamant6;
    public static BufferedImage felinar1,felinar2;
    public static BufferedImage iarba;
    public static BufferedImage transparent;
    public static BufferedImage pamant1_solidTile, pamant4_solidTile;
    public static BufferedImage iarbaStgJos,iarbaDrJos;
    public static BufferedImage Monstrulet_Verde_stg, Monstrulet_Verde_dr;
    public static BufferedImage Monstrulet_Rosu_stg, Monstrulet_Rosu_dr;

    public static BufferedImage[] Player_Right;
    public static BufferedImage[] Player_Left;
    public static BufferedImage[] Player_Down;
    public static BufferedImage[] Player_Up;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_exit;
    public static BufferedImage[] btn_storage;
    public static BufferedImage[] Monstrulet_VerdeTransformare_stg, Monstrulet_VerdeTransformare_dr; //transformare spre stanga sau dreapta;
                                                                                                     //in functie de cum ii atinge eroul
    public static BufferedImage[] Monstrulet_RosuTransformare_stg, Monstrulet_RosuTransformare_dr;

    public static BufferedImage BluePotion;
    public static BufferedImage WhiteDiamond, BlueDiamond, RedDiamond;
    public static BufferedImage coin;

    public static Font font28;


    public static BufferedImage pam1,pam2,pam3,pam4,pam5,pam6,pam7,pam8,pam9,pam10,pam11,pam12,pam13,pam14,pam15,
                                pam16, pam17, pam18, pam19, pam20, pam21;
    public static BufferedImage tufis1,tufis2,tufis3,tufis4,tufis5,tufis6;
    public static BufferedImage apa1,apa2,apa3,apa4;
    public static BufferedImage ind1,ind2,ind3,ind4;
    public static BufferedImage ciuperca1,ciuperca2;
    public static BufferedImage piatr,radacina;
    public static BufferedImage cutie1,cutie2,cutie3,cutie4,cutie5;
    public static BufferedImage cop1,cop2,cop3,cop4,cop5,cop6,cop7,cop8,cop9,cop10,cop11,cop12,cop13,cop14,cop15,cop16;
    public static BufferedImage pam4_nesol,pam5_nesol,pam6_nesol,pam7_nesol,pam8_nesol,pam9_nesol;

    public static BufferedImage castle1,castle2,castle3,castle4,castle5,castle6,castle7,castle8,castle9,castle10,
            castle11,castle12,castle13,castle14,castle15,castle16,castle17,castle18,castle19,castle20,castle21;

    public static BufferedImage mesajNegustor;

    public static BufferedImage puzzle1,puzzle2,puzzle3,puzzle4;

    public static BufferedImage[] Explosion;
    public static BufferedImage negustor;
    public static BufferedImage Anne;


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        /*SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        */


        //---------------------------------------------------------------------------------------------
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("res/textures/nature_tilesetOpenGameTransparent.png"));

        scara1=sheet.crop(0,0); scara2=sheet.crop(0,1); scara3=sheet.crop(0,2); scara4=sheet.crop(0,3);
        piatra=sheet.crop(1,1);
        floare=sheet.crop(1,2);
        cufar=sheet.crop(1,3);
        iedera1=sheet.crop(2,1); iedera2=sheet.crop(2,2);
        indicatorDreapta= sheet.crop(3,2);
        indicatorAmbele1= sheet.crop(5,1); indicatorAmbele2= sheet.crop(5,2);
        pamant1=sheet.crop(3,4); pamant2= sheet.crop(4,4); pamant3=sheet.crop(4,5);
        pamant4=sheet.crop(3,5); pamant5=sheet.crop(2,5); pamant6=sheet.crop(2,4);
        felinar1= sheet.crop(6,4); felinar2= sheet.crop(6,5);
        copac1= sheet.crop(7,0); copac2= sheet.crop(8,0); copac3= sheet.crop(6,1);
        copac4= sheet.crop(7,1); copac5= sheet.crop(8,1); copac6= sheet.crop(9,1);
        copac7= sheet.crop(6,2); copac8= sheet.crop(7,2); copac9= sheet.crop(8,2);
        copac10= sheet.crop(9,2); copac11= sheet.crop(7,3); copac12= sheet.crop(8,3);
        iarba=sheet.crop(3,3);
        transparent=sheet.crop(4,0);
        iarbaStgJos=sheet.crop(8,4); iarbaDrJos=sheet.crop(9,5);


        //SOLIDE:

        pamant1_solidTile=sheet.crop(3,4);
        pamant4_solidTile=sheet.crop(3,5);


        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetGilbert=new SpriteSheet(ImageLoader.LoadImage("res/Caractere/Gilbert_32x32.png"));
        Player_Right=new BufferedImage[3];
        Player_Right[0]=sheetGilbert.crop(0,1);
        Player_Right[1]=sheetGilbert.crop(1,1);
        Player_Right[2]=sheetGilbert.crop(2,1);
        Player_Left=new BufferedImage[3];
        Player_Left[0]=sheetGilbert.crop(0,3);
        Player_Left[1]=sheetGilbert.crop(1,3);
        Player_Left[2]=sheetGilbert.crop(2,3);
        Player_Down=new BufferedImage[3];
        Player_Down[0]=sheetGilbert.crop(0,2);
        Player_Down[1]=sheetGilbert.crop(1,2);
        Player_Down[2]=sheetGilbert.crop(2,2);
        Player_Up=new BufferedImage[3];
        Player_Up[0]=sheetGilbert.crop(0,0);
        Player_Up[1]=sheetGilbert.crop(1,0);
        Player_Up[2]=sheetGilbert.crop(2,0);

        SpriteSheet sheetNegustor=new SpriteSheet(ImageLoader.LoadImage("res/Caractere/Negustor.png"));

        negustor=sheetNegustor.crop(0,0);

        SpriteSheet sheetAnne=new SpriteSheet(ImageLoader.LoadImage("res/Caractere/Anne.png"));
        Anne=sheetAnne.crop(0,0);

        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetMenu=new SpriteSheet(ImageLoader.LoadImage("res/Menu/menutiles.png"));
        btn_storage=new BufferedImage[2];
        btn_storage[0]=sheetMenu.crop2Width(2,0);
        btn_storage[1]=sheetMenu.crop2Width(2,1);
        btn_exit=new BufferedImage[2];
        btn_exit[0]=sheetMenu.crop2Width(1,0);
        btn_exit[1]=sheetMenu.crop2Width(1,1);
        btn_start=new BufferedImage[2];
        btn_start[0]=sheetMenu.crop2Width(0,0);
        btn_start[1]=sheetMenu.crop2Width(0,1);


        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetMonstruleti=new SpriteSheet(ImageLoader.LoadImage("res/Caractere/Monstruletii.png"));
        Monstrulet_VerdeTransformare_stg=new BufferedImage[6];
        Monstrulet_VerdeTransformare_dr=new BufferedImage[6];
        for(int i=0;i<6;i++)
            Monstrulet_VerdeTransformare_stg[i]=sheetMonstruleti.crop(i,0);
        for(int i=0;i<6;i++)
            Monstrulet_VerdeTransformare_dr[i]=sheetMonstruleti.crop(i,1);

        Monstrulet_RosuTransformare_dr=new BufferedImage[6];
        Monstrulet_RosuTransformare_stg=new BufferedImage[6];
        for(int i=0; i<6; i++)
            Monstrulet_RosuTransformare_dr[i]=sheetMonstruleti.crop(i,2);
        for(int i=0; i<6; i++)
            Monstrulet_RosuTransformare_stg[i]=sheetMonstruleti.crop(i,3);

        Monstrulet_Verde_stg=sheetMonstruleti.crop(5,0);
        Monstrulet_Verde_dr=sheetMonstruleti.crop(5,1);
        Monstrulet_Rosu_stg=sheetMonstruleti.crop(5,3);
        Monstrulet_Rosu_dr=sheetMonstruleti.crop(5,2);


        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetInventar=new SpriteSheet(ImageLoader.LoadImage("res/Inventar/inventartiles.png"));
        BluePotion=sheetInventar.crop(0,0);
        WhiteDiamond=sheetInventar.crop(4,0);
        BlueDiamond=sheetInventar.crop(5,0);
        RedDiamond=sheetInventar.crop(6,0);
        coin=ImageLoader.LoadImage("res/Inventar/coin_01.png");
        //coin=sheetInventar.crop(7,0);



        //---------------------------------------------------------------------------------------------
        font28=FontLoader.LoadFont("res/Fonts/SFAtarianSystem.ttf",28);

        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetLvl2=new SpriteSheet(ImageLoader.LoadImage("res/textures/SpriteSheetLvl2.png"));
        pam1=sheetLvl2.crop(0,0); pam2=sheetLvl2.crop(1,0); pam3=sheetLvl2.crop(2,0);
        pam4=sheetLvl2.crop(0,1); pam5=sheetLvl2.crop(1,1); pam6=sheetLvl2.crop(2,1);
        pam7=sheetLvl2.crop(0,2); pam8=sheetLvl2.crop(1,2); pam9=sheetLvl2.crop(2,2);
        pam10=sheetLvl2.crop(4,0); pam11=sheetLvl2.crop(5,0); pam12=sheetLvl2.crop(6,0);
        pam13=sheetLvl2.crop(7,0); pam14=sheetLvl2.crop(3,1); pam15=sheetLvl2.crop(4,1);
        pam16=sheetLvl2.crop(5,1); pam17=sheetLvl2.crop(6,1); pam18=sheetLvl2.crop(7,1);
        pam19=sheetLvl2.crop(3,2); pam20=sheetLvl2.crop(4,2); pam21=sheetLvl2.crop(5,2);

        pam4_nesol=sheetLvl2.crop(0,1); pam5_nesol=sheetLvl2.crop(1,1); pam6_nesol=sheetLvl2.crop(2,1);
        pam7_nesol=sheetLvl2.crop(0,2); pam8_nesol=sheetLvl2.crop(1,2); pam9_nesol=sheetLvl2.crop(2,2);



        tufis1=sheetLvl2.crop(0,3); tufis2=sheetLvl2.crop(1,3); tufis3=sheetLvl2.crop(2,3);
        tufis4=sheetLvl2.crop(3,3); tufis5=sheetLvl2.crop(4,3); tufis6=sheetLvl2.crop(5,3);

        apa1=sheetLvl2.crop(8,0); apa2=sheetLvl2.crop(9,0); apa3=sheetLvl2.crop(8,1);
        apa4=sheetLvl2.crop(9,1);

        ind1=sheetLvl2.crop(6,2); ind2=sheetLvl2.crop(7,2); ind3=sheetLvl2.crop(6,3);
        ind4=sheetLvl2.crop(7,3);

        ciuperca1=sheetLvl2.crop(9,2); ciuperca2=sheetLvl2.crop(9,3);

        piatr=sheetLvl2.crop(0,4); radacina=sheetLvl2.crop(1,4);

        cutie1=sheetLvl2.crop(9,5); cutie2=sheetLvl2.crop(7,4); cutie3=sheetLvl2.crop(8,4);
        cutie4=sheetLvl2.crop(7,5); cutie5=sheetLvl2.crop(8,5);

        SpriteSheet sheetLvl2Copac=new SpriteSheet(ImageLoader.LoadImage("res/textures/SpriteSheetLvl2Copac.png"));
        cop1=sheetLvl2Copac.crop(0,2); cop2=sheetLvl2Copac.crop(1,2); cop3=sheetLvl2Copac.crop(0,1);
        cop4=sheetLvl2Copac.crop(1,1); cop5=sheetLvl2Copac.crop(2,1); cop6=sheetLvl2Copac.crop(0,0);
        cop7=sheetLvl2Copac.crop(1,0); cop8=sheetLvl2Copac.crop(2,0); cop9=sheetLvl2Copac.crop(3,0);
        cop10=sheetLvl2Copac.crop(4,0); cop11=sheetLvl2Copac.crop(5,0); cop12=sheetLvl2Copac.crop(3,1);
        cop13=sheetLvl2Copac.crop(4,1); cop14=sheetLvl2Copac.crop(5,1); cop15=sheetLvl2Copac.crop(4,2);
        cop16=sheetLvl2Copac.crop(5,2);

        //---------------------------------------------------------------------------------------------
        puzzle1=ImageLoader.LoadImage("res/Puzzle/piesa1.png");
        puzzle2=ImageLoader.LoadImage("res/Puzzle/piesa2.png");
        puzzle3=ImageLoader.LoadImage("res/Puzzle/piesa3.png");
        puzzle4=ImageLoader.LoadImage("res/Puzzle/piesa4.png");


        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetExplosion=new SpriteSheet(ImageLoader.LoadImage("res/Explosion/explosion.png"));
        Explosion=new BufferedImage[16];
        for(int i=0;i<4;i++)
            Explosion[i]=sheetExplosion.crop(i,0);
        for(int i=0;i<4;i++)
            Explosion[i+4]=sheetExplosion.crop(i,1);
        for(int i=0;i<4;i++)
            Explosion[i+8]=sheetExplosion.crop(i,2);
        for(int i=0;i<4;i++)
            Explosion[i+12]=sheetExplosion.crop(i,3);


        //---------------------------------------------------------------------------------------------
        SpriteSheet sheetCastle=new SpriteSheet(ImageLoader.LoadImage("res/textures/castle.png"));
        castle1=sheetCastle.crop(0,5); castle2=sheetCastle.crop(1,5); castle3=sheetCastle.crop(2,5);
        castle4=sheetCastle.crop(3,5); castle5=sheetCastle.crop(4,5); castle6=sheetCastle.crop(0,4);
        castle7=sheetCastle.crop(1,4); castle8=sheetCastle.crop(2,4); castle9=sheetCastle.crop(3,4);
        castle10=sheetCastle.crop(4,4); castle11=sheetCastle.crop(0,3); castle12=sheetCastle.crop(1,3);
        castle13=sheetCastle.crop(2,3); castle14=sheetCastle.crop(3,3); castle15=sheetCastle.crop(4,3);
        castle16=sheetCastle.crop(0,2); castle17=sheetCastle.crop(1,2); castle18=sheetCastle.crop(2,2);
        castle19=sheetCastle.crop(3,2); castle20=sheetCastle.crop(4,2); castle21=sheetCastle.crop(2,1);

        //---------------------------------------------------------------------------------------------

        mesajNegustor=ImageLoader.LoadImage("res/textures/mesaj.png").getSubimage(0,0,3* Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT);
    }
}
