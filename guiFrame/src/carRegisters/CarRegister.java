package carRegisters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

public class CarRegister implements Serializable {

    private static final long serialVersionUID = 1L;

    String carBrand;

    public static final String P_carBrand = "CarBrand";

    String model;

    public static final String P_model = "Model";

    int releaseYear;

    public static final String P_releaseYear = "ReleaseYear";

    String color;

    public static final String P_color = "Color";

    double price;

    public static final String P_price = "Price";

    String registerNumber;

    public static final String P_registerNumber = "RegisterNumber";
    
    public static final String AREA_DEL = "\n";

    public String getRegisterNumber() {
        return registerNumber;
    }
    
    public String getCarBrand() {
        return carBrand;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getReleaseYear() {
        return releaseYear;
    }
    
    public String getColor() {
        return color;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public final void setRegisterNumber(String carNumber) {
        if (!isValidCarNumber(carNumber)) {
            throw new IllegalArgumentException("Illegal Car Number!");
        }
        this.registerNumber = carNumber;
    }

    static Boolean isValidCarNumber(String str) {
        if (str.length() != 7) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        for (int i = 4; i < 6; i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch) || !Character.isUpperCase(ch)) {
                return false;
            }
        }
        char lastChar = str.charAt(6);
        return Character.isDigit(lastChar);
    }

    static boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static CarRegister read(Scanner fin, PrintStream out) throws IOException,
            NumberFormatException {
        String str;
        CarRegister register = new CarRegister();
        register.carBrand = fin.nextLine().trim();

        if (!nextRead(P_model, fin, out)) {
            return null;
        }
        register.model = fin.nextLine();
        if (!nextRead(P_releaseYear, fin, out)) {
            return null;
        }
        register.releaseYear = Integer.parseInt(fin.nextLine());
        if (!nextRead(P_color, fin, out)) {
            return null;
        }
        register.color = fin.nextLine();

        if (!nextRead(P_price, fin, out)) {
            return null;
        }
        register.price = Double.parseDouble(fin.nextLine());

        if (!nextRead(P_registerNumber, fin, out)) {
            return null;
        }
        register.registerNumber = fin.nextLine();

        return register;
    }

    public CarRegister() {
    }

    public static final String areaDel = "\n";

    public String toString() {
        return new String(
                carBrand + areaDel +
                        model + areaDel +
                        releaseYear + areaDel +
                        color + areaDel +
                        price + areaDel +
                        registerNumber
        );
    }


}
