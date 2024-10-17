package tarea;

import tarea.dao.PeliculaDAO;
import tarea.models.Pelicula;

public class Main {
    public static void main(String[] args) {
        PeliculaDAO peliDao = new PeliculaDAO(JdbcUtils.getCon());

        Pelicula nuevaPeli = new Pelicula();
        nuevaPeli.setTitulo("La vida de Brian");
        nuevaPeli.setAño(1979);
        nuevaPeli.setGenero("Humor");

        peliDao.save(nuevaPeli);


        peliDao.filterByYear(1990,2010).forEach(System.out::println);
        System.out.println("=========================================");


        System.out.println(peliDao.numTotal());
        System.out.println("=========================================");

        peliDao.findAll().forEach(System.out::println);

    }
}
