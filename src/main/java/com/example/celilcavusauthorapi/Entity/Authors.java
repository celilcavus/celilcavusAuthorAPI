package com.example.celilcavusauthorapi.Entity;


import jakarta.persistence.*;


import java.util.List;

@Entity
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    public String Name;
    public String Surname;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Books> book;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
