package com.suncode;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tabela_testowa")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Row {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "kolumna1")
    @NotNull
    private String column1;

    @Column(name = "kolumna2")
    @NotNull
    private String column2;

    @Column(name = "kolumna3")
    @NotNull
    private String column3;

    @Column(name = "kolumna4")
    @NotNull
    private Long column4;
}
