package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited

public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "denominacion")
    private String denominacion;

    @ManyToMany(mappedBy ="categorias")
    @Builder.Default
    private List<Articulo> articulos = new ArrayList<Articulo>();
}
