package parse.txt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "c_gbdfl_person")
public class Person {
    private String iin;
    private String surname;
    private String firstName;
    private String secondName;
    private Date birthDate;

    @Id
    @Column(name = "iin_")
    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    @Column(name = "surname_")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "firstname_")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "secondname_")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(name = "birth_date_")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Person(){

    }
    public Person(String iin, String surname, String firstName, String secondName, Date birthDate) {
        this.iin = iin;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "iin='" + iin + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + firstName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}