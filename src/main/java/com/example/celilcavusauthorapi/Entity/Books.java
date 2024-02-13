package com.example.celilcavusauthorapi.Entity;

import jakarta.persistence.*;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    public String Name;
    public String PageCount;
    public String Point;

    @OneToOne()
    public Authors AuthorId;
    @OneToOne()
    public Types TypeId;
}
