package com.shatokhina.controlwork.doctors;

import com.shatokhina.controlwork.Administrator;

import java.time.LocalDateTime;
import java.util.Map;

public interface Doctor {
     Map<LocalDateTime, String> viewRecords(Administrator administrator);
}