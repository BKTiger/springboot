package com.zhangtai.demo.filter;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {

        try {
            return DateUtils.parseDate(source, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
