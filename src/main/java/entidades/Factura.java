package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "Factura")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited

public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "fecha")
    private String fecha;

    @Column(name= "numero")
    private int numero;

    @Column(name= "total")
    private float total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @Builder.Default
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
}
