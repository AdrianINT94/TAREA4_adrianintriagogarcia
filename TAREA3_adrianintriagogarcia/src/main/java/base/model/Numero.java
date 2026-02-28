package base.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "numeros")
public class Numero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double duracion;

    private int orden;

    @ManyToOne
    @JoinColumn(name = "espectaculo_id", nullable = false)
    private Espectaculo espectaculo;

    @ManyToMany
    @JoinTable(
        name = "numero_artista",
        joinColumns = @JoinColumn(name = "numero_id"),
        inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    private List<Artista> artistas;

    public Numero() {}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
	

