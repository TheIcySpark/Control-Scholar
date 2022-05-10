package com.ControlScholarAPI.constant;

import java.util.ArrayList;

public class LearningCenterLocations {
    public static final ArrayList<String> locations = new ArrayList<String>(){
        {
            add("Amecameca");
            add("Atlacomulco");
            add("Ecatepec");
            add("Temascaltepec");
            add("Tenalcingo");
            add("Teotihuacan");
            add("Texcoco");
            add("ValleDeChalco");
            add("ValleDeMexico");
            add("Zumpango");
            add("Nezahualcoyotl");
        }
    };

    public static boolean checkIfLocation(String location){
        return locations.contains(location);
    }
}
