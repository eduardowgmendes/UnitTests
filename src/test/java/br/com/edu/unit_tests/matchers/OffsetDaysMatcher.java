package br.com.edu.unit_tests.matchers;

import br.com.edu.unit_tests.utils.DateUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OffsetDaysMatcher extends TypeSafeMatcher<Date> {

    private final Integer dayOfWeek;

    public OffsetDaysMatcher(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public void describeTo(Description description) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        String displayName = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        description.appendValue(displayName);
    }

    @Override
    protected boolean matchesSafely(Date date) {
        return DateUtils.verifyIfIs(date, dayOfWeek);
    }

    @Override
    protected void describeMismatchSafely(Date item, Description mismatchDescription) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(item);

        String dayName = calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,
                Calendar.LONG,
                Locale.getDefault()
        );

        mismatchDescription.appendText("Was: ").appendValue(dayName);
    }
}
