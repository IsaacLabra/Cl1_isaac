package pe.edu.i202214108.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202214108.entity.City;
import pe.edu.i202214108.entity.Country;
import pe.edu.i202214108.entity.CountryLanguage;

import java.math.BigDecimal;
import java.util.Arrays;


public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = new Country("MRN","Murciana","Europa",
                "Southeast Europa",new BigDecimal("295681"),Short.valueOf((short) 1999),
                Integer.valueOf(278357000),new BigDecimal("77"),new BigDecimal("8370700"),new BigDecimal("8190910"),
                "Murciana", "Republic","Bush",
                3492,"TR",null,null);

        City city1 = new City(null,"Galango","Galango",350000,country);
        City city2 = new City(null,"Rustan","Rustan",190000,country);
        City city3 = new City(null,"Powerand","Powerand",550000,country);

        CountryLanguage countryLanguage1 = new CountryLanguage(country.getCode(),"Engloan",true,90.0,country);
        CountryLanguage countryLanguage2 = new CountryLanguage(country.getCode(),"Glomansh",true,58.0,country);

        country.setCityList(Arrays.asList(city1,city2,city3));
        country.setCountryLanguageList(Arrays.asList(countryLanguage1,countryLanguage2));

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
    }
}
