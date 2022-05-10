package com.ControlScholarAPI.constant;

import java.util.ArrayList;
import java.util.Set;

public class Roles {
    public static final ArrayList<String> privilegeRoles = new ArrayList<String>(){
        {
            add("ROLE_ADMIN");
            add("ROLE_STUDENT");
            add("ROLE_LIBRARY_MANAGER");
            add("ROLE_MASTER");
            add("ROLE_MEMBER");
        }
    };
    public static final ArrayList<String> locationRoles = new ArrayList<String>(){
        {
            add("ROLE_AMECAMECA");
            add("ROLE_ATLACOMULCO");
            add("ROLE_ECATEPEC");
            add("ROLE_TEMASCALTEPEC");
            add("ROLE_TENALCINGO");
            add("ROLE_TEOTIHUACAN");
            add("ROLE_TEXCOCO");
            add("ROLE_VALLE_DE_CHALCO");
            add("ROLE_VALLE_DE_MEXICO");
            add("ROLE_ZUMPANGO");
            add("ROLE_NEZAHUALCOYOTL");
        }
    };
}
