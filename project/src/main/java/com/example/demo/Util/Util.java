package com.example.demo.Util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp dateToTimestamp(Date date) {
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
}
