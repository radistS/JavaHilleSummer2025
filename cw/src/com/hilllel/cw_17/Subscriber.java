package com.hilllel.cw_17;

public class Subscriber {
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private String phoneNumber;
    private String contractNumber;
    private double balance;
    private double cityCallDurationMin;
    private double interCityCallDurationMin;
    private double internetTrafficGb;

    public Subscriber() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCityCallDurationMin() {
        return cityCallDurationMin;
    }

    public void setCityCallDurationMin(double cityCallDurationMin) {
        this.cityCallDurationMin = cityCallDurationMin;
    }

    public double getInterCityCallDurationMin() {
        return interCityCallDurationMin;
    }

    public void setInterCityCallDurationMin(double interCityCallDurationMin) {
        this.interCityCallDurationMin = interCityCallDurationMin;
    }

    public Double getInternetTrafficGb() {
        return internetTrafficGb;
    }

    public void setInternetTrafficGb(double internetTrafficGb) {
        this.internetTrafficGb = internetTrafficGb;
    }
}
