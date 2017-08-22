package com.example.isaac.weatherapp.info;

/**
 * Created by isaac on 8/22/17.
 */

public class InfoSupport {
    private String locationCodes[][] =
        {
            {"Mexico City","3530597"},
            {"Paris", "2968815"},
            {"Madrid", "6359304"},
            {"Caracas", "3646738"},
            {"London", "2643744"}
        };

    public String getCodeFromLocation (String location) {
        for (int i=0; i<locationCodes.length; i++) {
            String city = locationCodes[i][0];
            String code = locationCodes[i][1];
            if (city.equals(location)) {
                return code;
            }
        }
        System.out.println("Error: City not found");
        return "0";
    }
}
