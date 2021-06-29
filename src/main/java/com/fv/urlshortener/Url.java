package com.fv.urlshortener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "shortUrl")
    private String shortUrl;

    @NotBlank
    @Column(name = "originalUrl")
    private String originalUrl;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;


}

