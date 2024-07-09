package com.eventostec.api.domain.coupon;

import com.eventostec.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue
    private UUID id;

    private Date valid;

    private Integer discount;

    @ManyToOne // Um evento pode ter vários cupons e um cupom pode pertencer a um evento
    @JoinColumn(name = "event_id") // Chave estrangeira, na tabela coupon, que referencia a tabela event vai ter o nome event_id
    // e na tabela event, a chave primária que é referenciada é id
    private Event event;
}
