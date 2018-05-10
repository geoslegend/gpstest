package com.android.gpstest;

import com.android.gpstest.util.UIUtils;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UIUtilsTest {

    /**
     * Left margin range for the C/N0 indicator ImageViews in gps_sky_signal_meter is from -5dp (10 dB-Hz) to 145dp (45 dB-Hz).
     */
    @Test
    public void testCn0ToLeftMargin() {
        float marginDp;

        // CN0 value of 27.5 dB-Hz is 50% between 10 and 45, so output should be halfway between -5dp and 145dp, which is 70dp
        marginDp = UIUtils.cn0ToIndicatorLeftMarginDp(27.5f);
        assertEquals(70.0f, marginDp);

        // CN0 value of 45.0 dB-Hz is 100% of 45, so output should be 100% of 145dp, which is 145dp
        marginDp = UIUtils.cn0ToIndicatorLeftMarginDp(45.0f);
        assertEquals(145.0f, marginDp);

        // CN0 value of 10.0 dB-Hz is 0% (min value of CN0), so output should be 0% of dp range, which is -5
        marginDp = UIUtils.cn0ToIndicatorLeftMarginDp(10.0f);
        assertEquals(-5.0f, marginDp);
    }
}
