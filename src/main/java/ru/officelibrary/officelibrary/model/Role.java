package ru.officelibrary.officelibrary.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {

    @Id
    @OneToOne
    @JoinColumn(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    @Column
    private String role;


}
