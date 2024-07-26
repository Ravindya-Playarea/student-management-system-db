package lk.ijse.dep12.jpa.relationships.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationPK implements Serializable {
    private Student student;
    private Batch batch;
    private User user;
}