package com.shatokhina.controlwork.doctors;

import com.shatokhina.controlwork.Administrator;

import java.time.LocalDateTime;
import java.util.Map;

public class Surgeon implements Doctor{

    @Override
    public Map<LocalDateTime, String> viewRecords(Administrator administrator) {
        return null;
    }
}
