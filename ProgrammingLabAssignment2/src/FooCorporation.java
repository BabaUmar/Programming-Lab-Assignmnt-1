public class FooCorporation {
    public static int CalculatePay(int hoursWorked,
                                   double basePay) {
        double totalPay = 0.0;

        //Checking if the base pay is not more than $8.00
        if (basePay < 8.00)
        {
            System.out.println("$" + basePay +" is less than the minimum"
                    + " wage of $8.00");
            return 0;
        }
        //Checks if employee has not worked more than 60 hours
        else if (hoursWorked > 60)
        {
            System.out.println("Error: This person has exceeded the 60 hours maximum work hours per week");
            return 0;
        }
        if (hoursWorked > 40)
        {
            totalPay += basePay * 40;
            totalPay += (basePay * 1.5) * (hoursWorked - 40);
        }
        else
        {
            totalPay += basePay * hoursWorked;
        }
        System.out.println("Total Pay: $" + totalPay);

        return 1;
    }

    public static void main(String[] args) {

        CalculatePay(35, 7.50);
        CalculatePay(47, 8.20);
        CalculatePay(73, 10.0);

    }
}
