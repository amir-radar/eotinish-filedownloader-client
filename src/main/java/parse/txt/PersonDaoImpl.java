package parse.txt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonDaoImpl implements PersonDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void savePerson(Person person) {
        em.createNativeQuery(
                "insert into c_gbdfl_person " +
                        "    (iin_, surname_, firstname_, secondname_, birth_date)" +
                        "    VALUES (" +
                        "            :iin," +
                        "            :surname," +
                        "            :firstName," +
                        "            :secondName" +
                        "            :birthDate" +
                        "            )"
        ).setParameter("iin", person.getIin())
                .setParameter("surname", person.getSurname())
                .setParameter("firstName", person.getFirstName())
                .setParameter("secondName", person.getSecondName())
                .setParameter("birthDate", person.getBirthDate())
                .executeUpdate();
    }
}
