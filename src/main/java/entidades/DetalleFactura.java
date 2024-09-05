package entidades;

import java.io.Serializable;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DetalleFactura")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DetalleFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "cantidad")
    private int cantidad;

    @Column(name= "subtotal")
    private float subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
}
