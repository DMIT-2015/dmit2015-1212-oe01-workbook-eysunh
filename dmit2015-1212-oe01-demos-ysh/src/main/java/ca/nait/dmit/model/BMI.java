package ca.nait.dmit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BMI {

    private double weight;
    private double height;

    public double bmi() {

        return 703 * weight / Math.pow(height, 2);
    }

    public String bmiCategory() {
        double bmiResult = bmi();
        String toReturn = "";

        if (bmiResult < 18.5){
            toReturn = "underweight";
        } else if (bmiResult >= 18.5 && bmiResult <= 24.9){
            toReturn = "normal";
        } else if (bmiResult >= 25 && bmiResult <= 29.9){
            toReturn = "overweight";
        } else if (bmiResult > 30) {
            toReturn = "obese";
        }

        return toReturn;
    }
}
