package com.ControlScholarAPI.constant;

import java.util.ArrayList;
import java.util.Set;

public class Roles {
    private static final ArrayList<String> privilegeRoles = new ArrayList<String>(){
        {
            add("ROLE_LIBRARY_MANAGER");
        }
    };
    public static final ArrayList<String> locationRoles = new ArrayList<String>(){
        {
            add("ROLE_ATLACOMULCO Atlacomulco");
            add("ROLE_AMECAMECA Amecameca");
            add("ROLE_ECATEPEC Ecatepec");
            add("ROLE_TEMASCALTEPEC Temascaltepec");
            add("ROLE_TENALCINGO Tenalcingo");
            add("ROLE_TEOTIHUACAN Teotihuacan");
        }
    };
}
