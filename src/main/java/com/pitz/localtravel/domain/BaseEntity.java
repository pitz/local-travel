package com.pitz.localtravel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@ToString
public abstract class BaseEntity implements Serializable {

    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version @Getter @Setter
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }
}


