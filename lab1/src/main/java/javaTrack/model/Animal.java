package javaTrack.model;

import java.util.Objects;

public class Animal {
    private String type;
    private String classOfAnimals;
    private String family;
    private String lineage;
    private String kind;
    private String subspecies;
    private int age;
    private String coloring;

    public Animal() {
    }

    Animal(String type, String classOfAnimals, String family, String lineage, String kind, String subspecies, int age, String coloring) {
        this.type = type;
        this.classOfAnimals = classOfAnimals;
        this.family = family;
        this.lineage = lineage;
        this.kind = kind;
        this.subspecies = subspecies;
        this.age = age;
        this.coloring = coloring;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassOfAnimals() {
        return classOfAnimals;
    }

    public void setClassOfAnimals(String classOfAnimals) {
        this.classOfAnimals = classOfAnimals;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public String getColoring() {
        return coloring;
    }

    public void setColoring(String coloring) {
        this.coloring = coloring;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", classOfAnimals='" + classOfAnimals + '\'' +
                ", family='" + family + '\'' +
                ", lineage='" + lineage + '\'' +
                ", kind='" + kind + '\'' +
                ", subspecies='" + subspecies + '\'' +
                ", age=" + age +
                ", coloring='" + coloring + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(type, animal.type) &&
                Objects.equals(classOfAnimals, animal.classOfAnimals) &&
                Objects.equals(family, animal.family) &&
                Objects.equals(lineage, animal.lineage) &&
                Objects.equals(kind, animal.kind) &&
                Objects.equals(subspecies, animal.subspecies) &&
                Objects.equals(coloring, animal.coloring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, classOfAnimals, family, lineage, kind, subspecies, age, coloring);
    }
}
