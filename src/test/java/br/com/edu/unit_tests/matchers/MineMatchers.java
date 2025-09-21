package br.com.edu.unit_tests.matchers;

import java.util.Calendar;

public class MineMatchers {

    public static OffsetDaysMatcher occursOn(Integer dayOfWeek){
        return new OffsetDaysMatcher(dayOfWeek);
    }

    public static OffsetDaysMatcher occursOnMonday(){
        return new OffsetDaysMatcher(Calendar.MONDAY);
    }

    public static OffsetDaysMatcher occursOnTuesday(){
        return new OffsetDaysMatcher(Calendar.TUESDAY);
    }

    public static OffsetDaysMatcher occursOnWednesday() {
        return new OffsetDaysMatcher(Calendar.WEDNESDAY);
    }

    public static OffsetDaysMatcher occursOnThursday(){
        return new OffsetDaysMatcher(Calendar.THURSDAY);
    }

    public static OffsetDaysMatcher occursOnFriday(){
        return new OffsetDaysMatcher(Calendar.FRIDAY);
    }

    public static OffsetDaysMatcher occursOnSaturday(){
        return new OffsetDaysMatcher(Calendar.SATURDAY);
    }

    public static OffsetDaysMatcher occursOnSunday(){
        return new OffsetDaysMatcher(Calendar.SUNDAY);
    }
}
