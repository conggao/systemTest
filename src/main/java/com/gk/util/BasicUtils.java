package com.gk.util;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BasicUtils {


    public static String createDateDirTree(String root, String sysName) {
        File dir;
        String path = "";

        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        path += "/" + sysName;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        String curDateString = BasicUtils.getCurrentDateString();
        String strYear = curDateString.substring(0, 4);
        String strMonth = curDateString.substring(4, 6);
        String strDay = curDateString.substring(6, 8);

        path += "/" + strYear;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        path += "/" + strMonth;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        path += "/" + strDay;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        return path;
    }

    public static String createDateDirTree(String root) {
        File dir;
        String path = "";

        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        String curDateString = BasicUtils.getCurrentDateString();
        String strYear = curDateString.substring(0, 4);
        String strMonth = curDateString.substring(4, 6);
        String strDay = curDateString.substring(6, 8);

        path += "/" + strYear;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        path += "/" + strMonth;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        path += "/" + strDay;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        return path;
    }

    public static Short getShortRandomNumber() {
        int min = 10;
        int max = 500;
        Random random = new Random();
        int iRandom1 = random.nextInt(max) % (max - min + 1) + min;
        min = 500;
        max = 5000;
        int iRandom2 = random.nextInt(max) % (max - min + 1) + min;
        return (short) (iRandom1 + iRandom2);
    }

    public static String getLicRandomPartString() {
        Random random = new Random();
        int iRandom1 = random.nextInt(200);
        int iRandom2 = random.nextInt(10000) % 256;
        int iRandom3 = random.nextInt(65535);

        String string = String.format("%02X%02X%04X", iRandom1, iRandom2, iRandom3);
        return string.toUpperCase();
    }

    public static String getCurrentAccurateDateTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return df.format(new Date());
    }

    public static String getCurrentAccurateDateTimeStringForPrint() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return df.format(new Date());
    }

    public static String getCurrentDateTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    public static String getCurrentDateTimeString_Sql() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static String getCurrentDateString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    public static String getCurrentDateFormatString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static String getCurrentSimpleDateTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        return df.format(new Date());
    }

    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
//        try
//        {   
//            ts = Timestamp.valueOf(strTime);   
//        } 
//        catch (Exception e)
//        {   
//            e.printStackTrace();   
//        }  
    }

    public static String getTimeString(Timestamp timestamp) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String str = sdf.format(timestamp);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getSqlStringFromStringList(List<String> list) {
        if (null == list || list.size() == 0) {
            return null;
        }

        String string = "";
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) < list.size()) {
                string += "'" + list.get(i) + "', ";
            } else {
                string += "'" + list.get(i) + "'";
            }
        }
        return string;
    }

    public static String getSqlStringFromIntegerList(List<Integer> list) {
        if (null == list || list.size() == 0) {
            return null;
        }

        String string = "";
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) < list.size()) {
                string += list.get(i) + ", ";
            } else {
                string += list.get(i);
            }
        }
        return string;
    }

    public static long getDiffTime(Timestamp last) {
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());

        long nowSec = now.getTime() / 1000;
        long lastSec = last.getTime() / 1000;
        if (nowSec > lastSec) {
            return nowSec - lastSec;
        } else {
            return lastSec - nowSec;
        }
    }


    public static String createUploadDir(String root, String sysName) {
        File dir;
        String path = "";

        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            if (false == dir.mkdirs()) {
                return null;
            }
        }

        if (sysName != null) {
            path += "/" + sysName;
            dir = new File(root + path);
            if (dir != null && !dir.exists()) {
                if (false == dir.mkdirs()) {
                    return null;
                }
            }
        }

        String curDateString = BasicUtils.getCurrentDateTimeString();
        String strYear = curDateString.substring(0, 4);
        String strMonth = curDateString.substring(4, 6);
        String strDay = curDateString.substring(6, 8);
        String strHour = curDateString.substring(8, 10);

        path += "/" + strYear;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            if (false == dir.mkdirs()) {
                return null;
            }
        }

        path += "/" + strMonth;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            if (false == dir.mkdirs()) {
                return null;
            }
        }

        path += "/" + strDay;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            if (false == dir.mkdirs()) {
                return null;
            }
        }

        path += "/" + strHour;
        dir = new File(root + path);
        if (dir != null && !dir.exists()) {
            if (false == dir.mkdirs()) {
                return null;
            }
        }
        return path;
    }

//    public static  String createUploadDir(String root)
//	{	
//        return createUploadDir(root, null);
//	}


    public static String getNewFormId() {
        return BasicUtils.getCurrentSimpleDateTimeString();
    }

    public static Long getNewFormId_Long() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmssSSS");
        String strTime = df.format(new Date());
        try {
            return Long.parseLong(strTime);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }


    public static String getNewUserId() {
        return BasicUtils.getCurrentSimpleDateTimeString();
    }

//    public static void resetUploadFileInfo(List<UploadFileInfo> listFileInfo)
//    {
//    	if (listFileInfo != null
//    			&& listFileInfo.size() > 0)
//    	{
//    		for (int i = 0; i < listFileInfo.size(); i++)
//    		{
//    			UploadFileInfo uploadFileInfo = listFileInfo.get(i);
//				BasicUtils.resetUploadFileInfo(uploadFileInfo);
//    		}
//    	}        
//	}
//
//    public static void resetUploadFileInfo(UploadFileInfo uploadFileInfo)
//    {
//    	if (null != uploadFileInfo)
//		{
//			uploadFileInfo.setUserId(null);
//			uploadFileInfo.setIsdel(null);
//			if (null != uploadFileInfo.getPath() 
//					&& false == uploadFileInfo.getPath().contains(ComonConfig.getServerUrl()))
//			{
//				uploadFileInfo.setPath(ComonConfig.getServerUrl() + uploadFileInfo.getPath());
//			}
//		} 	
//	}

    private static final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {

            char ch = value.charAt(i);
            if (isChinese(ch) == true) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }


//            String temp = value.substring(i, i + 1);
//            if (temp.matches(chinese)) 
//            {
//                valueLength += 2;
//            }
//            else 
//            {
//                valueLength += 1;
//            }
        }
        return valueLength;
    }

    public static boolean isMobileNo(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0,5-9])|(18[0,5-9])|(19[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
