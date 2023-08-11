package com.anaselrayan.tweezer.security.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Override
    public String getAuthority() {
        return name;
    }
}
