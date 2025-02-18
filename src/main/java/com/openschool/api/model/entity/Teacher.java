package com.openschool.api.model.entity;

import com.openschool.api.model.Address;
import com.openschool.api.model.dtos.request.TeacherRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="Teacher")
@Table(name="teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Embedded
    private Address address;

    private String cpf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Teacher(TeacherRequestDTO teacherData, Subject subject) {
        this.name = teacherData.name();
        this.email = teacherData.email();
        this.address = new Address(teacherData.address());
        this.cpf = teacherData.cpf();
        this.subject = subject;
    }
}
