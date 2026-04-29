package com.my.filmrent.entity;

import com.my.filmrent.entity.enums.Rating;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED")
    private Integer filmId;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_year", columnDefinition = "YEAR")
    private Short releaseYear;

    @Column(name = "rental_duration", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Short rentalDuration = 3;

    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    private BigDecimal rentalRate = new BigDecimal("4.99");

    @Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
    private Short length;

    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    private BigDecimal replacementCost = new BigDecimal("19.99");

    @Column(name = "rating", columnDefinition = "ENUM('G','PG','PG-13','R','NC-17')")
    private Rating rating;

    @Column(name = "special_features",
            columnDefinition = "SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false, insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @OneToOne(mappedBy = "film", cascade = CascadeType.ALL)
    private FilmText filmText;

    @ManyToMany
    @JoinTable(
        name = "film_actor",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "film_category",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}
