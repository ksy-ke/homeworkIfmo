package com.shatokhina.controlwork.doctors;

import com.shatokhina.controlwork.Administrator;

import java.time.LocalDateTime;
import java.util.Map;

public class Neurologist implements Doctor {
    @Override
    public Map<LocalDateTime, String> viewRecords(Administrator administrator) {
        for (String doc : administrator.getVisits().values()){
            if (doc.equals("neurologist")) {

            }
        }
        return null;
    }
}
