package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    private String employeeId;
    private String fullName;
    private String birthDay;
    private String phoneNumber;
    private String email;
    private String employeeType;
    private int employeeCount;

    public EmployeeModel(String employeeId, String fullName, String birthDay, String phoneNumber, String email, String employeeType, int employeeCount) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeType = employeeType;
        this.employeeCount = employeeCount;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                ", Full Name: " + fullName +
                ", Birth Day: " + birthDay +
                ", Phone Number: " + phoneNumber +
                ", Email: " + email +
                ", Employee Type: " + employeeType +
                ", Employee Count: " + employeeCount;
    }

    public String getName() {
        return fullName;
    }

    public static List<EmployeeModel> loadEmployeesFromFile(String filePath) {
        List<EmployeeModel> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String id = parts[0];
                    String name = parts[1];
                    String birthday = parts[2];
                    String phone = parts[3];
                    String email = parts[4];
                    String type = parts[5];
                    int count = Integer.parseInt(parts[6]);
                    EmployeeModel employee = new EmployeeModel(id, name, birthday, phone, email, type, count);
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}