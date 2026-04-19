package base.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "coordinadores")
@PrimaryKeyJoinColumn(name = "id") 
public class Coordinador extends Persona {
    
    
    private boolean senior = false;
    private LocalDate fechaSenior;

    public Coordinador() {
        super();
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public LocalDate getFechaSenior() {
        return fechaSenior;
    }

    public void setFechaSenior(LocalDate fechaSenior) {
        this.fechaSenior = fechaSenior;
    }

    @Override
    public String toString() {
        
        return getNombre() != null ? getNombre() : "Coordinador sin nombre";
    }
}