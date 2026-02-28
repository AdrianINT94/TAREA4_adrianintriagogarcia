package base.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String apodo;

    @OneToOne
    @JoinColumn(name = "persona_id", nullable = false, unique = true)
    private Persona persona;

    public Artista() {}

    public Long getId() {
        return id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}