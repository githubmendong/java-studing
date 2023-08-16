package chapter04;

import java.util.Calendar;

// 상속을 못함 final
public class CalenderTest {
    //    publicic final void m(){
//
//    }
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

//        final int i = 10;
//        i = 10 + 9;

        printDate(cal);

        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, 11); //12월 (month - 1)
        cal.set(Calendar.DATE, 25);

        printDate(cal);

        cal.set(2013, 12, 26);
        cal.add(Calendar.DATE, 100);
        printDate(cal);
    }

    private static void printDate(Calendar cal) {
//        final Book
        final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0~11, +1
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);  // 1(일) ~ 7(토)
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        int day = cal.get(Calendar.DAY_OF_WEEK);

//        System.out.println(
//                year + "/" + month +"/"+ date + " " + hour +"시 "+ minute +"분"  + second +"초"
//                +"\n오늘은 "+ DAYS[day-1] + "요일 입니다."
//        );

        System.out.println(
                year + "/" + month +"/"+ date + " " + hour +"시 "+ minute +"분"  + second +"초"
                        +"\n오늘은 "+ DAYS[day] + "요일 입니다."
        );
    }

}
