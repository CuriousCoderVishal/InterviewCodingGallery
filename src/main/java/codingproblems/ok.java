    package codingproblems;

    import java.util.Scanner;

    class Rocket {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numStages = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            double speed = 0;
            double totalMass = 0;

            for (int i = 0; i < numStages; i++) {
                int stageEmptyMass = scanner.nextInt();
                int fuelMass = scanner.nextInt();
                int thrust = scanner.nextInt();
                int fuelConsumption = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Calculate the initial total mass
                totalMass += stageEmptyMass + fuelMass;

                // Simulate burning the fuel in this stage
                while (fuelMass > 0) {
                    // Calculate net force (thrust - weight)
                    double weight = totalMass * 9.8; // Weight due to gravity
                    double netForce = thrust - weight;

                    if (netForce <= 0) break; // Stop if net force is negative

                    // Calculate the acceleration
                    double acceleration = netForce / totalMass; // m/s^2

                    // Calculate the time taken to burn 1 kg of fuel
                    double time = (double) fuelConsumption / thrust; // seconds

                    // Update the speed using v = u + at
                    speed += acceleration * time;

                    // Reduce the fuel and update total mass for next iteration
                    fuelMass -= fuelConsumption;
                    totalMass -= fuelConsumption;
                }
            }

            // Output the result rounded to the nearest meter per second
          //  long roundedValue = roundDecimal(speed, 6);

          //  System.out.println(roundedValue);
           System.out.println(roundScientificNotation(speed));

            scanner.close();
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

    }
