package com.nixsolutions.ponarin.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.nixsolutions.ponarin.annotation.PasswordMatches;

@PasswordMatches
public class UserForm {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$", message = "Incorrect login format"
            + " (3-15 symbols, only letters and digits")
    private String login;

    @NotBlank
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!?@#$%]).{6,20})", message = "Incorrect password format, must contain al least 6 symbols"
            + " 1 lowercase, 1 uppercase, 1 special symbol (!?@#$%)")
    private String password;

    @NotBlank
    @Length(min = 2, max = 50, message = "MatchingPassword must between 2 and 50 symbols")
    private String matchingPassword;

    @NotBlank
    @Email(regexp = "[\\w-]+@([\\w-]+\\.)+[\\w-]+", message = "Incorrect e-mail format")
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)", message = "Invalid date format, (dd-MM-yyyy) format required")
    private String birthDay;

    private String role;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
