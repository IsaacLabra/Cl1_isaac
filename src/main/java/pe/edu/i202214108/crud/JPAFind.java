package pe.edu.i202214108.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202214108.entity.City;
import pe.edu.i202214108.entity.Country;

import java.util.List;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        List<City> cityList = em.createQuery(
                        "SELECT c FROM City c WHERE c.country = :country", City.class)
                .setParameter("country", country)
                .getResultList();

        cityList.forEach(city -> {
            if (city.getPopulation() > 700000) {
                System.out.println(city.getName() + " " + city.getPopulation());

            }
        });
//

    }
}
