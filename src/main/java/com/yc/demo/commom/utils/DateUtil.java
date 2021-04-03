package com.yc.demo.commom.utils;

import com.yc.demo.commom.utils.pojo.DateDuration;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 日期工具类
 * <p>
 * Created By Jayce on 2016/12/20
 */
public class DateUtil
{
    public enum DatePattern {

        YYYYMMDDHHmmss("yyyy-MM-dd HH:mm:ss"),
        YYYYMMDD("yyyy-MM-dd"),
        YYYYMMDDHHmmss1("yyyy/MM/dd HH:mm:ss"),
        YYYYMMDD1("yyyyMMdd"),
        YYYYMMDDHHmmss2("yyyyMMddHHmmss");
        private String value;

        DatePattern(String value) {
            this.value = value;
        }

        public String getValue() {

            return this.value;
        }
    }


    private static final int MORNING_WORK = 0;
    private static final int NIGHT_WORK = 1;


    public static final long MILLIS_DAY = 24L * 3600L * 1000L;//一天的毫秒数
    public static final long MILLIS_HOUR = 3600L * 1000L;//一小时的毫秒数
    public static final long MILLIS_MINUTE = 60L * 1000L;//一分钟的毫秒数
    public static final long MILLIS_SECOND = 1000L;//一秒的毫秒数

    /**
     * 返回当前时间字符串
     *
     * @return
     */
    public static String getCurrentTimeString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DatePattern.YYYYMMDDHHmmss.getValue());
        return dateFormat.format(new Date());
    }

    /**
     * 根据年月日构造date
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getTime(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    /**
     * 根据年、月、日、小时构造date
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getTime(int year, int month, int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, 0);
        return calendar.getTime();
    }




    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取当前毫秒时间
     *
     * @return
     */
    public static long getCurrentDateMillis() {
        return System.currentTimeMillis();
    }


    /**
     * 字符串转时间
     *
     * @param date    需要转换的时间
     * @param pattern 格式
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String date, String pattern) throws ParseException {
        if(date!=null){
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(date);
        }
        return null;
    }


    /**
     * 日期转化为字符串
     *
     * @param date    需要转化的日期
     * @param pattern 转化格式
     * @return
     */
    public static String date2String(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 获得当前年份
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获得当前月份
     *
     * @return
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当前日
     *
     * @return
     */
    public static int getCurrentDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得当前小时数，以24小时制计算
     *
     * @return
     */
    public static int getCurrentHour() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获得当前分钟数
     *
     * @return
     */
    public static int getCurrentMinute() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取当前秒
     *
     * @return
     */
    public static int getCurrentSecond() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取当前毫秒
     *
     * @return
     */
    public static int getCurrentMilliSeccond() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * 对时间做加减法
     * 例如求
     * 2016/10/12日的5天后的时间
     * 2016/10/12 22：00 前三小时的时间
     *
     * @param date          需要计算的基础时间
     * @param amount        需要加或者减去的时间数量（负值为减）
     * @param calendarField 时间单位，支持毫秒、分钟、小时、天、年等，详见Calendar中的静态变量
     * @return
     */
    public static Date addTime(Date date, int amount, int calendarField) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarField, amount);
        return calendar.getTime();
    }

    /**
     * 对时间做加减法，支持对时间做取整
     * 例如求
     * 2016/10/12日的5天后的时间
     * 2016/10/12 22：00 前三小时的时间
     *
     * @param date          需要计算的基础时间
     * @param amount        需要加或者减去的时间数量（负值为减）
     * @param calendarField 时间单位，支持毫秒、分钟、小时、天、年等，详见Calendar中的静态变量
     * @param truncateUnit  对时间取整的单位，例如：
     *                      让输入Date(2016/12/10), 30,
     *                      传Calendar.DAY_OF_MONTH结果取整到年，传Calendar.YEAR
     *                      结果为 2017/1/1 00:00:00.000
     * @return
     */
    public static Date addTime(Date date, int amount, int calendarField, int truncateUnit) {
        Date result = addTime(date, amount, calendarField);
        result = DateUtils.truncate(result, truncateUnit);
        return result;
    }

    /**
     * 求两个日期之间相差的毫秒
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDurationMillis(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }

    /**
     * 求两个日期之间相差的时间，包含天、时、分、秒
     *
     * @param date1
     * @param date2
     * @return
     */
    public static DateDuration getDuration(Date date1, Date date2) {
        long durationMillis = getDurationMillis(date1, date2);
        return calculateDuration(durationMillis);
    }

    /**
     * 根据毫秒数计算日期间隔
     *
     * @param durationMillis 间隔毫秒数
     * @return
     */
    public static DateDuration calculateDuration(long durationMillis) {
        if (durationMillis < 1) {
            throw new IllegalArgumentException("时间间隔不能小于1");
        }
        long day = durationMillis / MILLIS_DAY;
        durationMillis -= day * MILLIS_DAY;
        long hour = durationMillis / MILLIS_HOUR;
        durationMillis -= hour * MILLIS_HOUR;
        long minute = durationMillis / MILLIS_MINUTE;
        durationMillis -= minute * MILLIS_MINUTE;
        long second = durationMillis / MILLIS_SECOND;
        durationMillis -= second * MILLIS_SECOND;
        long milliSecond = durationMillis;
        return new DateDuration(day, hour, minute, second, milliSecond);
    }

    /**
     * 根据年和月份获得该月有几周
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    public static int getWeekCount(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        int endWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return endWeek - startWeek + 1;
    }

    /**
     * 根据年和月获取该月有几天
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    public static int getDayCount(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDay = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        int endDay = calendar.get(Calendar.DAY_OF_MONTH);
        return endDay - startDay + 1;
    }






    /**
     * 获取某年/月/周的第一天，时间以当天00:00:00.000为准
     *
     * @param date          要求的时间范围，例如求1994年的第一天，则date为1994
     * @param calendarField 时间范围的类型，例如求1994年的第一天，则calendarField为Calendar.YEAR
     * @return
     */
    public static Date getFirstDay(int date, int calendarField) {
        if (!(calendarField == Calendar.YEAR || calendarField == Calendar.MONTH
                || calendarField == Calendar.WEEK_OF_MONTH || calendarField == Calendar.WEEK_OF_YEAR)) {
            throw new IllegalArgumentException("所求范围无法求第一天");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(calendarField, date);
        return calendar.getTime();
    }

    /**
     * 获取某年/月/周的最后天，时间以当天23:59:59.999为准
     *
     * @param date          要求的时间范围，例如求1994年的最后天，则date为1994
     * @param calendarField 时间范围的类型，例如求1994年的最后天，则calendarField为Calendar.YEAR
     * @return
     */
    public static Date getLastDay(int date, int calendarField) {
        if (!(calendarField == Calendar.YEAR || calendarField == Calendar.MONTH
                || calendarField == Calendar.WEEK_OF_MONTH || calendarField == Calendar.WEEK_OF_YEAR)) {
            throw new IllegalArgumentException("所求范围无法求最后1天");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(calendarField, date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new Date(calendar.getTime().getTime() - 1);
    }

    /**
     * 将日期取整（去零头）
     * 例如求 2016/10/24 12:10:30.333 对于日期取整，
     * 则calendarField为Calendar.DAY_OF_MONTH，
     * 结果为 2016/10/24 00:00:00.000
     * <p>
     * 例如求 2016/10/24 12:10:30.333 对于分钟取整，
     * 则calendarField为Calendar.HOUR，
     * 结果为 2016/10/24 12:10:00.000
     *
     * @param date          需要取整的日期
     * @param calendarField 取整单位
     * @return
     */
    public static Date truncate(Date date, int calendarField) {
        return DateUtils.truncate(date, calendarField);
    }

    /**
     * 将日期取整（进位与舍位）
     * 例如, 对时间： 2002/3/28 13:45:01.231, 若对 HOUR进行取整,
     * 结果为：2002/3/28 14:00:00.000.
     * 若对MONTH进行取整，
     * 结果为： 2002/4/1 0:00:00.000.
     *
     * @param date          需要取整的日期
     * @param calendarField 取整单位
     * @return
     */
    public static Date round(Date date, int calendarField) {
        return DateUtils.round(date, calendarField);
    }

    /**
     * 获得日期是当年的第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }


    /**
     * 获取两个日期之间的日期，包括开始结束日期 YYYYMMDD
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期集合
     */
    public static List<String> getBetweenDates(Date start, Date end) {
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        result.add(DateUtil.date2String(start, DateUtil.DatePattern.YYYYMMDD1.getValue()));
        while (tempStart.before(tempEnd)) {
            result.add(DateUtil.date2String(tempStart.getTime(), DateUtil.DatePattern.YYYYMMDD1.getValue()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        if(!DateUtil.date2String(start, DateUtil.DatePattern.YYYYMMDD1.getValue()).equals(DateUtil.date2String(end, DateUtil.DatePattern.YYYYMMDD1.getValue()))){
            result.add(DateUtil.date2String(end, DateUtil.DatePattern.YYYYMMDD1.getValue()));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }
}
