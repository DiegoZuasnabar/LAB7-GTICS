package com.example.lab7;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "desembolsos")
public class Desembolso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "monto_desembolso", length = 45)
    private String montoDesembolso;

    @Column(name = "fecha")
    private Instant fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creditos_id", nullable = false)
    private Credito creditos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMontoDesembolso() {
        return montoDesembolso;
    }

    public void setMontoDesembolso(String montoDesembolso) {
        this.montoDesembolso = montoDesembolso;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Credito getCreditos() {
        return creditos;
    }

    public void setCreditos(Credito creditos) {
        this.creditos = creditos;
    }

}