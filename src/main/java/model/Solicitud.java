package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "team_id",nullable = false)
    Equipo equipo;
}
