package fit.imc.models.mongo;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
    @Id
    private UUID id;
    private double weight;
    private double height;
    private String imcDescription;
    private double imc = 0.00;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getImcDescription() {
        return imcDescription;
    }

    public void setImcDescription(String imcDescription) {
        this.imcDescription = imcDescription;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void calculate() {
        System.out.println("calculate...");
        System.out.println(this.weight);
        System.out.println(this.height);

        this.imc = this.weight / Math.pow(this.height, 2);

        System.out.println(this.imc);
        if (this.imc < 18.5)
            this.imcDescription = "Magreza";
        else if (this.imc < 24.9)
            this.imcDescription = "Normal";
        else if (this.imc <= 30.0)
            this.imcDescription = "Sobrepeso";
        if (this.imc > 30.0)
            this.imcDescription = "Obesidade";
    }

    public String toString() {
        System.out.println("to string ...");
        System.out.println(this.getImc());
        System.out.println(this.getImcDescription());
        return String.format("%.2f : %s", this.getImc(), this.getImcDescription());
      }
}
