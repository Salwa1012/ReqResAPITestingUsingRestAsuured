package helpers;

public class ApiHelper {

    public static String UserPayload(String name, String job) {
        return "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";
    }

    public static String UpdateUserNamePayload(String name) {
        return "{ \"name\": \"" + name+ "\"}";
    }

    public static String UpdateUserJobPayload(String job) {
        return "{ \"job\": \"" + job + "\" }";
    }

    public static String SuccessfulPayload(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }

    public static String UnSuccessfulMissingPassPayload(String email) {
        return "{ \"email\": \"" + email + "\"}";
    }

    public static String UnSuccessfulMissingEmailPayload(String password) {
        return "{\"password\": \"" + password + "\" }";
    }

    public static String UpdateResourceNamePayload(String name) {
        return "{ \"name\": \"" + name + "\" }";
    }

    public static String CreateResourcePayload(String name, String color) {
        return "{ \"name\": \"" + name + "\", \"color\": \"" + color + "\" }";
    }


    public static String UpdateResourceColorPayload(String color) {
        return "{ \"color\": \"" + color + "\" }";
    }
}
