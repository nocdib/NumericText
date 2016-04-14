package com.nocdib.numerictext;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NumberToTextTest {

    private NumberToText tn;

    @Test
    public void testValues() {

        tn = new NumberToText(Long.MIN_VALUE); // -9_223_372_036_854_775_808
        Assert.assertEquals(tn.toString(), "Negative Nine Quintillion Two Hundred Twenty-Three Quadrillion " +
                                            "Three Hundred Seventy-Two Trillion Thirty-Six Billion " +
                                            "Eight Hundred Fifty-Four Million Seven Hundred Seventy-Five Thousand " +
                                            "Eight Hundred Eight");
        tn.getText(-1234456);
        Assert.assertEquals(tn.toString(), "Negative One Million Two Hundred Thirty-Four Thousand Four Hundred Fifty-Six");

        tn.getText(0);
        Assert.assertEquals(tn.toString(), "Zero");

        tn.getText(9999);
        Assert.assertEquals(tn.toString(), "Nine Thousand Nine Hundred Ninety-Nine");

        tn.getText(12300067800L);
        Assert.assertEquals(tn.toString(), "Twelve Billion Three Hundred Million Sixty-Seven Thousand Eight Hundred");

        tn.getText(1_000_915_000_309_020_456L);
        Assert.assertEquals(tn.toString(),  "One Quintillion Nine Hundred Fifteen Trillion Three Hundred Nine Million Twenty Thousand " +
                                            "Four Hundred Fifty-Six");

        tn.getText(Long.MAX_VALUE);  // 9,223,372,036,854,775,807
        Assert.assertEquals(tn.toString(),  "Nine Quintillion Two Hundred Twenty-Three Quadrillion Three Hundred Seventy-Two Trillion " +
                                            "Thirty-Six Billion Eight Hundred Fifty-Four Million Seven Hundred Seventy-Five Thousand " +
                                            "Eight Hundred Seven");
    }

}
