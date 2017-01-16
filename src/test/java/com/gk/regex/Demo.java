package com.gk.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pc on 2017/1/12.
 */
public class Demo {
    @Test
    public void findNums() {
        String Line = "null(1)(1)(1)(1)(1)(1)(1)(1)(1)(1).hello";
        String pattern = "(?<delString>null\\(.*\\)\\.)(?<fileName>.*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(Line);
        if (m.find()) {
            System.out.println(m.groupCount());
            System.out.println(m.group(0));
            System.out.println(m.group("delString"));
            System.out.println(m.group("fileName"));
        }


    }

}
