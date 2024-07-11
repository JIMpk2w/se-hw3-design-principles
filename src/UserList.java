/*
 * Name: Pakawat Panklang
 * Student ID: 6510450763
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserList {
    private List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (register(user)) {
            users.add(new User(user.getName(), user.getEmail(), user.getAge()));
        }
    }

    public boolean register(User user) {
        try {
            validateName(user.getName());
            validateEmail(user.getEmail());
            validateAge(user.getAge());
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name format is incorrect");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email should not be empty");
        }

        if (!isValidEmailFormat(email)) {
            throw new IllegalArgumentException("Email format is incorrect");
        }

        if (isNotAllowedDomain(email)) {
            throw new IllegalArgumentException("Email domain is not allowed");
        }
    }

    private boolean isValidEmailFormat(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
        return validEmailPattern.matcher(email).matches();
    }

    private boolean isNotAllowedDomain(String email) {
        List<String> notAllowedDomains = Arrays.asList("dom1.cc", "dom2.cc", "dom3.cc");
        String[] emailParts = email.split("@");
        return emailParts.length == 2 && notAllowedDomains.contains(emailParts[1]);
    }

    private void validateAge(int age) {
        if (age < 20) {
            throw new IllegalArgumentException("Age should be at least 20 years");
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
