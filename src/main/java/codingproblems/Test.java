package codingproblems;

class Test {
    public static void main(String[] args) {
        // Test with 9.02E-5
        System.out.println(roundScientificNotation(9.02E-5)); // Output: 90

        // Test with other numbers in scientific notation
        System.out.println(roundScientificNotation(1.23E-4)); // Output: 123
        System.out.println(roundScientificNotation(5.67E-4)); // Output: 567
    }

    public static long roundScientificNotation(double value) {
        // Convert the value to a string
        String stringValue = String.valueOf(value);

        // Check if the number is in scientific notation (contains "E")
        if (stringValue.contains("E")) {
            // Split the string into parts before and after "E"
            String[] parts = stringValue.split("E");

            // Get the part before "E" and remove the decimal point
            String beforeE = parts[0].replace(".", "");

            // Get the exponent part and convert to integer
            int exponent = Integer.parseInt(parts[1]);

            // Calculate the number of decimal places to move
            int decimalPlaces = -exponent;

            // If decimalPlaces is positive, move the decimal point to the right
            if (decimalPlaces > 0) {
                // Insert the decimal point at the correct position
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                if (decimalPlaces < beforeE.length()) {
                    resultBuilder.insert(beforeE.length() - decimalPlaces, '.');
                } else {
                    resultBuilder.insert(0, "0.");
                    resultBuilder.append("0".repeat(decimalPlaces - beforeE.length()));
                }

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Long.parseLong(result);
            } else {
                // If decimalPlaces is negative, move the decimal point to the left
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                resultBuilder.insert(1, '.');

                // Append zeros for decimal places
                resultBuilder.append("0".repeat(-decimalPlaces));

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Long.parseLong(result);
            }
        } else {
            // If not in scientific notation, just round the value
            return Math.round(value);
        }
    }

  /*  public static long roundScientificNotation(double value) {
        // Convert the value to a string
        String stringValue = String.valueOf(value);

        // Check if the number is in scientific notation (contains "E")
        if (stringValue.contains("E")) {
            // Split the string into parts before and after "E"
            String[] parts = stringValue.split("E");

            // Get the part before "E" and remove the decimal point
            String beforeE = parts[0].replace(".", "");

            // Get the exponent part and convert to integer
            int exponent = Integer.parseInt(parts[1]);

            // Calculate the number of decimal places to move
            int decimalPlaces = -exponent;

            // If decimalPlaces is positive, move the decimal point to the right
            if (decimalPlaces > 0) {
                // Insert the decimal point at the correct position
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                if (decimalPlaces < beforeE.length()) {
                    resultBuilder.insert(beforeE.length() - decimalPlaces, '.');
                } else {
                    resultBuilder.insert(0, "0.");
                    resultBuilder.append("0".repeat(decimalPlaces - beforeE.length()));
                }

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Math.round(Double.parseDouble(result) * 100);
            } else {
                // If decimalPlaces is negative, move the decimal point to the left
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                resultBuilder.insert(1, '.');

                // Append zeros for decimal places
                resultBuilder.append("0".repeat(-decimalPlaces));

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Math.round(Double.parseDouble(result) * 100);
            }
        } else {
            // If not in scientific notation, just round the value
            return Math.round(value * 100);
        }
    }*/
    /*public static long roundScientificNotation(double value) {
        // Convert the value to a string
        String stringValue = String.valueOf(value);

        // Check if the number is in scientific notation (contains "E")
        if (stringValue.contains("E")) {
            // Split the string into parts before and after "E"
            String[] parts = stringValue.split("E");

            // Get the part before "E" and remove the decimal point
            String beforeE = parts[0].replace(".", "");

            // Get the exponent part and convert to integer
            int exponent = Integer.parseInt(parts[1]);

            // Calculate the number of decimal places to move
            int decimalPlaces = -exponent;

            // If decimalPlaces is positive, move the decimal point to the right
            if (decimalPlaces > 0) {
                // Insert the decimal point at the correct position
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                if (decimalPlaces < beforeE.length()) {
                    resultBuilder.insert(beforeE.length() - decimalPlaces, '.');
                } else {
                    resultBuilder.insert(0, "0.");
                    resultBuilder.append("0".repeat(decimalPlaces - beforeE.length()));
                }

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Math.round(Double.parseDouble(result) * 100);
            } else {
                // If decimalPlaces is negative, move the decimal point to the left
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                resultBuilder.insert(1, '.');

                // Append zeros for decimal places
                resultBuilder.append("0".repeat(-decimalPlaces));

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Math.round(Double.parseDouble(result) * 100);
            }
        } else {
            // If not in scientific notation, just round the value
            return Math.round(value * 100);
        }
    }*/

  /*  public static long roundScientificNotation(double value) {
        // Convert the value to a string
        String stringValue = String.valueOf(value);

        // Check if the number is in scientific notation (contains "E")
        if (stringValue.contains("E")) {
            // Split the string into parts before and after "E"
            String[] parts = stringValue.split("E");

            // Get the part before "E" and remove the decimal point
            String beforeE = parts[0].replace(".", "");

            // Get the exponent part and convert to integer
            int exponent = Integer.parseInt(parts[1]);

            // Calculate the number of decimal places to move
            int decimalPlaces = -exponent;

            // If decimalPlaces is positive, move the decimal point to the right
            if (decimalPlaces > 0) {
                // Insert the decimal point at the correct position
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                if (decimalPlaces < beforeE.length()) {
                    resultBuilder.insert(beforeE.length() - decimalPlaces, '.');
                } else {
                    resultBuilder.insert(0, "0.");
                    resultBuilder.append("0".repeat(decimalPlaces - beforeE.length()));
                }

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Math.round(Double.parseDouble(result) * 100);
            } else {
                // If decimalPlaces is negative, move the decimal point to the left
                StringBuilder resultBuilder = new StringBuilder(beforeE);
                resultBuilder.insert(1, '.');

                // Append zeros for decimal places
                resultBuilder.append("0".repeat(-decimalPlaces));

                // Remove any leading zeros
                String result = resultBuilder.toString().replaceFirst("^0+(?!$)", "");

                // Return the result as a long
                return result.isEmpty() ? 0 : Math.round(Double.parseDouble(result) * 100);
            }
        } else {
            // If not in scientific notation, just round the value
            return Math.round(value * 100);
        }
    }
*/
}
