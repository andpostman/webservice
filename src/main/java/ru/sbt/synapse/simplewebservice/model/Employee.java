package ru.sbt.synapse.simplewebservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "employee", schema = "simple_company", indexes = @Index(name = "employee_id_idx",columnList = "id"))
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("first_name",firstName)
                .append("last_name",lastName)
                .append("email_id",emailId)
                .toString();
    }
}
