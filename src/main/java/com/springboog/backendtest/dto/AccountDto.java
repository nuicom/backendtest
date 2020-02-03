package com.springboog.backendtest.dto;

import com.springboog.backendtest.config.Constants;
import com.springboog.backendtest.validation.SalaryLess;
import com.springboog.backendtest.validation.UsernameUnique;

import javax.validation.constraints.Pattern;

public class AccountDto {
    @UsernameUnique
    @Pattern(regexp = Constants.REGEXP_MOBILE_NUMBER, message = "Mobile no. must be 10 numerical digits")
    private String username;

    private String password;

    @SalaryLess
    private int salary;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
