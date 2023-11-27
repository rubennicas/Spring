package es.jsomoza.customjpaquery;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
    private String name;
    private Double diameter;
    
    @OneToMany
  @JoinColumn(name="planet_id")
  private List<Moon> moons = new ArrayList<Moon>();

  public Planet() {
  }

  public Planet(Long id, String name, Double diameter) {
    this.id = id;
    this.name = name;
    this.diameter = diameter;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getDiameter() {
    return diameter;
  }

  public void setDiameter(Double diameter) {
    this.diameter = diameter;
  }

  public List<Moon> getMoons() {
    return moons;
  }

  public void setMoons(List<Moon> moons) {
    this.moons = moons;
  }

  @Override
  public String toString() {
    return "Planet [id=" + id + ", name=" + name + ", diameter=" + diameter + ", moons=" + moons + "]";
  }
}