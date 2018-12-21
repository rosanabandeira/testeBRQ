package br.com.rosana.testebrq.utils;

import org.junit.Test;

import static br.com.rosana.testebrq.utils.DateUtil.formatDate;
import static org.junit.Assert.assertEquals;

public class DateUtilTest {
    @Test
    public void testDateIsValid() {
        String date = formatDate("1967-02-27T00:00:00Z");
        assertEquals("27/02/1967", date);
    }
}