package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "department_id_gen")
    @SequenceGenerator(name = "department_id_gen", sequenceName = "department_id_seq", allocationSize = 1)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "departments", cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = EAGER)
    private List<Doctor> doctors;

    public void addDoctor(Doctor doctor) {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }
        doctors.add(doctor);
    }

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST}, fetch = EAGER)
    private Hospital hospital;

}
