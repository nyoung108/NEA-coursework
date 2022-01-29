package libraryFunctions;

import java.util.regex.Pattern;

public class formatChecks {

        public static boolean validEmail(String email) {
// need to use method to check for high level domain
//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
        
         boolean valid = true;
        if (email.length() > 64) {
            
                valid = false;
                return valid;
            
        }
       String regularPattern = ".+@.+\\....+";
       valid = Pattern.compile(regularPattern).matcher(email).matches();
        return valid;
    }

    public static boolean validPassword(String password, String passwordCheck) {
        
        boolean valid = true; //starts of assuming password is valid

        valid = passwordEqual(valid, password, passwordCheck); //method to check if both passwords are the same when entered
        if (valid == false) {
            return valid; //all of the checks need to be passed so as soon as one is false it returns false;
        }
        if (password.length() <= 20 && valid == true) {
           //checks to make sure password is not too long
        } else {
            valid = false;
            return valid;
        }
        valid = passwordContainUpperCase(valid, password); //method to check for upper case
        if (valid == false) {
            return valid;
        }
        valid = passwordContainSymbol(valid, password); // method to check for symbol
        if (valid == false) {
            return valid;
        }

        return valid;
    }

    public static boolean passwordEqual(Boolean valid, String password, String passwordCheck) {

       
        if (password.equals(passwordCheck)&&(valid == true)) {      // compares first password to second password    
            return valid;
        }
        else{
            valid = false; //if not true then sets valid to false
        }
        return valid;
    }

    public static boolean passwordContainUpperCase(boolean valid, String password) {
        String passwordToLowerCase = password.toLowerCase(); //converts password to lowercase and saves as a new String
        if (password.equals(passwordToLowerCase)) { //if the password is equal to the lowercase password, then the original did not have an uppercase
            valid = false; //if not true then sets valid to false
        } 
        return valid;
    }

    public static boolean passwordContainSymbol(boolean valid, String password) {
        char[] characters = password.toCharArray(); //changes all the chars in the password into a char array

        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            int asciiValue = (int) character; //converts chars to their ascii value
            if ((asciiValue >= 33 && asciiValue <= 47) || (asciiValue >= 58 && asciiValue <= 64)  
                    || (asciiValue >= 91 && asciiValue <= 96) || (asciiValue >= 123 && asciiValue <= 126)) {
                // all the brackets are acceptable symbols so it is checking if any of the ascii values in
                //the char array are within these parameters and returns true if they are
                
                return valid;
            } else {
                valid = false; //if not true then sets valid to false
            }
        }
        return valid;
    }
    public static boolean lastNameValid(String lastName) {
        boolean valid = true;
        if(lastName.length()>30){
            valid = false;
            return valid;
        }
        char[] characters = lastName.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            int asciiValue = (int) character;
            if(asciiValue==3){  //need to change to correct values
                
            }
            
    }
    return valid;
    }
}
