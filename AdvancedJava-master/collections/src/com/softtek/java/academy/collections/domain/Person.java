package com.softtek.java.academy.collections.domain;

public class Person extends Party {

    private String name;

    private String lastName;

    private String gender;

    private Integer age;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result =
            prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        if (age == null) {
            if (other.age != null) {
                return false;
            }
        } else if (!age.equals(other.age)) {
            return false;
        }
        if (gender == null) {
            if (other.gender != null) {
                return false;
            }
        } else if (!gender.equals(other.gender)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Person [name=" + name + ", lastName=" + lastName + ", gender="
            + gender + ", age=" + age + "]";
    }

}
