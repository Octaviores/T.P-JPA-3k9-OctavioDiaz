package entidades;


import java.io.Serializable;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Domicilio")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "numero")
    private int numero;

    @Column(name= "nombreCalle")
    private String nombreCalle;
}
