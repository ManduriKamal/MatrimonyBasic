package com.Matrimony;

public class Candidate extends Person {

    private String profession;
    private String city;
    private String preferenceCity;

    public Candidate(String name, int age, String gender,
                     String profession, String city, String preferenceCity) {

        super(name, age, gender);
        this.profession = profession;
        this.city = city;
        this.preferenceCity = preferenceCity;
    }

    public String getProfession() { return profession; }
    public String getCity() { return city; }
    public String getPreferenceCity() { return preferenceCity; }

    @Override
    public String toString() {
        return getName() + " | " + getAge() + " | " + getGender() +
                " | " + profession + " | " + city +
                " | Prefers: " + preferenceCity;
    }
}

