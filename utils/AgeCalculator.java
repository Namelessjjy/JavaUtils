package com.aicompose.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AgeCalculator {

    /**
     * 当前日期
     */
    private static Date date = new Date();
    private static SimpleDateFormat year = new SimpleDateFormat("yyyy");
    private static SimpleDateFormat month = new SimpleDateFormat("MM");
    private static SimpleDateFormat day = new SimpleDateFormat("dd");

    /**
     * 计算出的年龄
     */
    private static int age;

    /**
     * 当前年份
     */
    private static long currentYear =  Long.valueOf(year.format(date));

    /**
     * 当前天数
     */
    private static int currentDay = Integer.valueOf(day.format(date));

    /**
     * 当前月份
     */
    private static int currentMonth = Integer.valueOf(month.format(date));

    /**
     * 用于计算实际真实年龄
     * @param birthday 生日日期
     * @return 返回值为计算得出的实际年龄
     */
    public static int calculate(Date birthday){
        long birthYear = Long.valueOf(year.format(birthday));
        int birthDay = Integer.valueOf(day.format(birthday));
        int birthMonth = Integer.valueOf(month.format(birthday));

        //判断当前年份的生日过没过
        if(birthMonth < currentMonth){
            //若生日过了，年龄就为当前年份与生日年份相减值
            age = (int) (currentYear - birthYear);
        }else if(birthMonth == currentMonth){//若当前月份与生日月份相同，则比较天数是否超过生日天数
            if(birthDay <= currentDay) {
                //生日天数比当前天数小或相等，则已经过完了生日
                age = (int) (currentYear - birthYear);
            }else{
                //生日天数比当前天数大，则还没过今年生日
                age = (int) (currentYear - birthYear) - 1;
            }
        }else{
            age = (int) (currentYear - birthYear) - 1;
        }
        return age;
    }

}
