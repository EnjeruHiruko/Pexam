package Pexam;

import Pexam.data.Moves.Moves;
import Pexam.data.Pokemon.Nature;
import Pexam.data.Pokemon.Pokemon;
import Pexam.data.Pokemon.Species;
import Pexam.data.utility.Damage.DamageBase;
import Pexam.data.utility.Damage.DamageClass;
import Pexam.data.utility.Describtions.Gender;
import Pexam.data.utility.Enums.Freq;
import Pexam.data.utility.Enums.Frequency;
import Pexam.data.utility.Enums.Type;

public class Main{
    public static void main(String[] args){
        /*
        WorldConfiguration con = new WorldConfiguration("WorldConfiguration.txt");
        System.out.printf(con.toString());
        */
        //test if Species works
        String test = "1.0\n" +
                "1\n" +
                "BULBASAUR\n" +
                "5 5 5 7 7 5\n" +
                "GRASS POISON\n" +
                "BA Confidence Photosynthesis\n" +
                "AA Chlorophyll Leaf$Guard\n" +
                "HA Courage\n" +
                "EV BULBASAUR#0 IVISAUR#15 VENUSAUR#30\n" +
                "0.7 6.9 87.5 Monster/Plant 10 Herbivore/Phototroph Forest/Grassland/Rainforest\n" +
                "cl Overland#5 Swim#3 Highjump#0 Longjump#2 Power#2 Naturewalk(Grassland/Forest) Underdog\n" +
                "3#2 2#0 2#0 2#0 2#0 2#1\n" +
                "ml 1#Tackle 3#Growl 7#Leech#Seed 9#Vine#Whip 13#Poison#Powder 13#Sleep#Powder 15#Take#Down 19#Razor#Leaf 21#Sweet#Scent 25#Growth 27#Double-Edge 31#Worry#Seed 33#Synthesis 37#Seed#Bomb\n" +
                "tml 1337#1#Cut 1337#4#Strength 06#Toxic 09#Venoshock 10#Hidden#Power 11#Sunny#Day 16#Light#Screen 17#Protect 20#Safeguard 21#Frustration 22#Solar#Beam 27#Return 32#Double#Team 36#Sludge#Bomb 42#Facade 44#Rest 45#Attract 48#Round 49#Echoed#Voice 53#Energy#Ball 70#Flash 75#Swords#Dance 86#Grass#Knot 87#Swagger 88#Sleep#Talk 90#Substitute 94#Rock#Smash 96#Nature#Power 100#Confide\n" +
                "el Amnesia Charm Curse Endure Giga#Drain Grass#Whistle Grassy#Terrain Ingrain Leaf#Storm Light#Screen Magical#Leaf Nature#Power Petal#Dance Power#Whip Safeguard Skull Bash Sludge\n" +
                "tl Bind Body#Slam Bullet#Seed Defense#Curl Fury#Cutter Giga#Drain Grass#Pledge Knock#Off Mud-Slap Natural#Gift Secret#Power Seed#Bomb Sleep#Talk Snore String#Shot Synthesis Worry#Seed\n" +
                "1.0";
        Species Bulbasur = new Species(test);
        //System.out.printf(Bulbasur.toString());

        //Test if update works
        Moves charm = new Moves("Charm");
        charm.setType(Type.FAIRY);
        charm.setFrequency(new Frequency(Freq.EOT, 0));
        charm.setAC(2);
        charm.setDamageClass(DamageClass.STATUS);
        charm.setRange("6, 1 Target, Social");
        charm.setEffect("Charm lowers the target's Attack 2 Combat Stages");
        charm.setContestType("Cute");
        charm.setContestEffect("Excitement");
        //System.out.printf(charm.toString());

        Bulbasur.update_Filler(charm);
        //System.out.printf(Bulbasur.toString());

        //test if a move on 2 list will be updateted with one operation
        Moves Seedbomb = new Moves("Seed Bomb");
        Seedbomb.setType(Type.GRASS);
        Seedbomb.setFrequency(new Frequency(Freq.AW, 0));
        Seedbomb.setAC(2);
        Seedbomb.setDamageClass(DamageClass.PHYSICAL);
        Seedbomb.setDB(DamageBase.DB8);
        Seedbomb.setRange("8, 1 Target");
        Seedbomb.setEffect("None");
        Seedbomb.setContestEffect("Steady Performance");
        Seedbomb.setContestType("Smart");

        Moves TakeDown = new Moves("Take Down");
        TakeDown.setType(Type.NORMAL);
        TakeDown.setFrequency(new Frequency(Freq.EOT, 0));
        TakeDown.setAC(5);
        TakeDown.setDamageClass(DamageClass.PHYSICAL);
        TakeDown.setDB(DamageBase.DB9);
        TakeDown.setRange("Melee, 1 Target, Dash, Recoil 1/3");
        TakeDown.setEffect("You may perform a Trip Maneuver...");
        TakeDown.setContestEffect("Steady Performance");
        TakeDown.setContestType("Tough");

        Bulbasur.update_Filler(Seedbomb);
        Bulbasur.update_Filler(TakeDown);
        //System.out.printf(Bulbasur.toString());

        // test Pokemon class

        Pokemon YEEEz = new Pokemon(Bulbasur);
        YEEEz.genderBender(Gender.female);
        YEEEz.name_change("YEEEz");
        YEEEz.LevelGain(29);
        //System.out.println("sdoiueiuqgizeizefizevfizevfizevfizevfizevfizevfizvezfveizfvezfve");
        YEEEz.update_Nature(Nature.Brave);

        YEEEz.update_Stats(0, 4);
        YEEEz.update_Stats(1, 50);

        YEEEz.learnMove("Tackle", 0, 0);
        YEEEz.learnMove("Growl", 0, 0);
        YEEEz.learnMove("Leech Seed", 0, 0);
        YEEEz.learnMove("Poison Powder", 5, 0);
        YEEEz.learnMove("Growth", 5, 0);
        YEEEz.learnMove("Take Down", 4, 0);
        YEEEz.learnMove("Razor Leaf", 0, 0);

        YEEEz.learnMove("Rest", 4 , 0);
        YEEEz.learnMove("Rest", 3, 0);


        YEEEz.learnMove("Sunny Day", 1, 0);

        YEEEz.learnMove("Seed Bomb", 1 , 4);
        System.out.printf(YEEEz.toString());
        System.out.println();

        YEEEz.resolveIncomingDamage(YEEEz.AttackWithMove("Take Down", 0, true, true, false));

    }


}

/*
7 + 24

31 - 5 = 26

2x res -> 0,25mod

26 * 0,25 = 6




 */