package com.my.filmrent.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED")
    private Integer storeId;

    @Column(name = "last_update", nullable = false, insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id", nullable = false, unique = true)
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<Staff> staffMembers = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Inventory> inventories = new ArrayList<>();
}
