package es.iessaladillo.pedrojoya.pr01.bmi;

/**
 * Allow Bmi calculation and clasification
 */
public class BmiCalculator {

    /**
     * @param weightInKgs Weight of the person in kgs
     * @param heightInMeters Height of the person in meters
     * @return The body mass index (BMI)
     */
    public float calculateBmi(float weightInKgs, float heightInMeters) {
        float bmi;
        bmi = (float)(weightInKgs/(Math.pow(heightInMeters,2)));
        return bmi;
        // TODO
    }

    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        BmiClasification calculatedBmi;
        if (bmi < 18.5) {
            calculatedBmi = BmiClasification.LOW_WEIGHT;
        }else if (bmi >= 18.5 && bmi < 25) {
            calculatedBmi = BmiClasification.NORMAL_WEIGHT;
        }else if (bmi >= 25 && bmi < 30) {
            calculatedBmi = BmiClasification.OVERWWEIGHT;
        }else if (bmi >= 30 && bmi < 35) {
            calculatedBmi = BmiClasification.OBESITY_GRADE_1;
        }else if (bmi >= 35 && bmi < 40) {
            calculatedBmi = BmiClasification.OBESITY_GRADE_2;
        }else{
            calculatedBmi = BmiClasification.OBESITY_GRADE_3;
        }
        return calculatedBmi;
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}
