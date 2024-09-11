package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "Articulo")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited

public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "precio")
    private float precio;

    @Column(name= "cantidad")
    private int cantidad;

    @Column(name= "denominacion")
    private String denominacion;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name="articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
              )
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<Categoria>();
}
