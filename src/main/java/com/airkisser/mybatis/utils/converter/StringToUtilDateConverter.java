package com.airkisser.mybatis.utils.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToUtilDateConverter implements Converter<String, Date> {

    public Date convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        } else {
            Date date = null;
            try {
                if(source.matches("^\\d{4}-\\d{2}-\\d{2}$")){
                    source = source + " 00:00:00";
                }
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }
}
