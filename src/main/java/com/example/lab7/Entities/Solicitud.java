package com.example.lab7.Entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "solicitud_producto", length = 45)
    private String solicitudProducto;

    @Column(name = "solicitud_monto")
    private Double solicitudMonto;

    @Column(name = "solicitud_fecha")
    private Instant solicitudFecha;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuariosId;

    @Column(name = "solicitud_estado", length = 45)
    private String solicitudEstado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSolicitudProducto() {
        return solicitudProducto;
    }

    public void setSolicitudProducto(String solicitudProducto) {
        this.solicitudProducto = solicitudProducto;
    }

    public Double getSolicitudMonto() {
        return solicitudMonto;
    }

    public void setSolicitudMonto(Double solicitudMonto) {
        this.solicitudMonto = solicitudMonto;
    }

    public Instant getSolicitudFecha() {
        return solicitudFecha;
    }

    public void setSolicitudFecha(Instant solicitudFecha) {
        this.solicitudFecha = solicitudFecha;
    }

    public String getSolicitudEstado() {
        return solicitudEstado;
    }

    public void setSolicitudEstado(String solicitudEstado) {
        this.solicitudEstado = solicitudEstado;
    }

    public Usuario getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuario usuariosId) {
        this.usuariosId = usuariosId;
    }
}