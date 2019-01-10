
package net.ramon.helper;

public class ValidateData {
    public static boolean validateId(String entero){
        return entero.matches("^[1-9][0-9]*$");
    }
}