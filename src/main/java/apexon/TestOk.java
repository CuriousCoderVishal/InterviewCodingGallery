package apexon;

 class DecimalExtractor {

    public static double extractDecimal(double num) {
        // Handle negative numbers
        if (num < 0) {
            num = Math.abs(num);
        }

        // Remove the integer part using multiplication and subtraction
        double exponent = Math.floor(Math.log10(num));
        return num * Math.pow(10, exponent) * Math.pow(10, -2);
    }

    public static void main(String[] args) {
        double number1 = 9.02E-5;
        double number2 = 123.456;
        double number3 = -789.0;

        System.out.println("Extracted decimal for " + number1 + ": " + extractDecimal(number1));
        System.out.println("Extracted decimal for " + number2 + ": " + extractDecimal(number2));
        System.out.println("Extracted decimal for " + number3 + ": " + extractDecimal(number3));
    }
}

