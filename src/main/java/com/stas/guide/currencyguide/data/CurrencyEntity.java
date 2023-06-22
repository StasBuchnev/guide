package com.stas.guide.currencyguide.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "currency_guide", schema = "public")

public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "currency_name", nullable = false, length = 3)
    private String nameCurrency;


}
