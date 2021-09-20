package PaooGame.States.Levels;

import PaooGame.Items.Hero;

import java.util.Arrays;

public class LevelFlags {

    public static boolean[] level1_piese=new boolean[]{
            false, false, false, false
    };
    public static boolean level2_part1_coinsPaid=false;
    public static boolean level2_part2_coinsPaid=false;

    public static boolean level1_passed(){


        for (boolean b : level1_piese) {
            if (!b)
                return false;
        }

        Hero.getStorage().getStorageElements().removeIf(it->it.getId()==4 ||  it.getId()==5 || it.getId()==6 || it.getId()==7) ;

        return true;
    }

    public static boolean level2_part1_passed(){

        return level2_part1_coinsPaid;

    }

    public static boolean level2_part2_passed(){

        return level2_part2_coinsPaid;

    }






}
