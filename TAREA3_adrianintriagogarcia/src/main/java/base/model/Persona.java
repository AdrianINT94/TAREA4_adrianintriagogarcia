
package base.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 50)
    private String nacionalidad;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private Credencial credencial;

    public Persona() {}

    public Persona(String nombre, String email, String nacionalidad) {
        this.nombre = nombre;
        this.email = email;
        this.nacionalidad = nacionalidad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
	
	
		
