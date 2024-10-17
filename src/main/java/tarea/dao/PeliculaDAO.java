package tarea.dao;

import tarea.JdbcUtils;
import tarea.models.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula>{

    public static final String INSERT_INTO_PELICULA = "insert into pelicula(titulo, año, genero)values(?, ?, ?)";
    private static Connection con = null;

    public PeliculaDAO (Connection c){
        con = c;
    }

    @Override
    public List<Pelicula> findAll() {
        var lista = new ArrayList<Pelicula>();

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from pelicula");

            while(rs.next()){
                Pelicula peli = new Pelicula();
                peli.setId(rs.getInt(1));
                peli.setTitulo(rs.getString(2));
                peli.setAño(rs.getInt(3));
                peli.setGenero(rs.getString(4));
                lista.add(peli);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public Pelicula findById(Integer id) {
        return null;
    }
    @Override
    public void save(Pelicula pelicula) {
        try(PreparedStatement ps = con.prepareStatement(INSERT_INTO_PELICULA, Statement.RETURN_GENERATED_KEYS )){
            ps.setString(1, pelicula.getTitulo());
            ps.setInt(2,pelicula.getAño());
            ps.setString(3,pelicula.getGenero());

            if (ps.executeUpdate() == 1){
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                pelicula.setId(rs.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void update(Pelicula pelicula) {

    }
    @Override
    public void delete(Pelicula pelicula) {

    }
    public Integer numTotal(){
        var resultado = 0;

        PeliculaDAO peliDao = new PeliculaDAO(JdbcUtils.getCon());
        List<Pelicula> pelis = peliDao.findAll();

        for(Pelicula p : pelis){
            if (p != null){
                resultado++;
            }
        }

        return resultado;
    }


    public List<Pelicula> filterByYear(int antes, int despues){
        var lista = new ArrayList<Pelicula>();
        Pelicula peli = null;

        try(PreparedStatement ps = con.prepareStatement("select * from pelicula where año between ? and ?")){
            ps.setInt(1,antes);
            ps.setInt(2,despues);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                peli = new Pelicula();
                peli.setId(rs.getInt(1));
                peli.setTitulo(rs.getString(2));
                peli.setAño(rs.getInt(3));
                peli.setGenero(rs.getString(4));
                lista.add(peli);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }




}
