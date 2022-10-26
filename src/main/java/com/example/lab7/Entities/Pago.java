package com.example.lab7.Entities;

import com.example.lab7.Entities.Credito;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "monto")
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario_id;

    @Column(name = "tipo_pago", length = 45)
    private String tipoPago;

    @Column(name = "fecha")
    private Instant fecha;

    @ManyToOne
    @JoinColumn(name = "creditos_id", nullable = false)
    private Credito creditos_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }


    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Credito getCreditos_id() {
        return creditos_id;
    }

    public void setCreditos_id(Credito creditos_id) {
        this.creditos_id = creditos_id;
    }
}