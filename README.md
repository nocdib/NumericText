# NumericText
Java library to convert whole numbers to English text and English text into its numeric value.
(Text-to-number coming soon)

**NOTE:** This library was built for Java 7 but will work with Java 8 if you remove the underscores from the constant values.

### Number-To-Text Example
    tn = new NumberToText(-1234456);
    System.out.println(tn); // "Negative One Million Two Hundred Thirty-Four Thousand Four Hundred Fifty-Six");

    tn.getText(0);
    System.out.println(tn); // "Zero"

    tn.getText(9999);
    System.out.println(tn); // "Nine Thousand Nine Hundred Ninety-Nine"

    tn.getText(12300067800L);
    System.out.println(tn); // "Twelve Billion Three Hundred Million Sixty-Seven Thousand Eight Hundred"

