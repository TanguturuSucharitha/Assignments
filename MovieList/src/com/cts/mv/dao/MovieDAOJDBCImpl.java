package com.cts.mv.dao;

import com.cts.mv.model.Movie;
import com.cts.mv.util.ConnectionProvider;
import com.cts.mv.exception.MovieException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

public class MovieDAOJDBCImpl implements IMovieDAO {

	ConnectionProvider conProvider;
	//Logger log;

	public MovieDAOJDBCImpl() throws MovieException {
		// log = Logger.getLogger("dao");

		try {
			conProvider = ConnectionProvider.getInstance();
		} catch (ClassNotFoundException | IOException exp) {
			//log.error(exp);
			throw new MovieException("Database is not reachable");
		}
	}

	@Override
	public String add(Movie movie) throws MovieException {
		String mvid = null;
		if (movie != null) {
			try (Connection con = conProvider.getConnection();
					PreparedStatement pInsert = con
							.prepareStatement(IQueryMapper.ADD_MOVIE_QRY)) {

				pInsert.setString(1, movie.getMvId());
				pInsert.setString(2, movie.getMvName());
				pInsert.setString(3, movie.getMvHero());
				pInsert.setInt(3, movie.getCollection());
				pInsert.setDate(4, Date.valueOf(movie.getReleaseDate()));

				int rowCount = pInsert.executeUpdate();

				if (rowCount == 1) {
					mvid = movie.getMvId();
				}
			} catch (SQLException exp) {
				//log.error(exp);
				throw new MovieException("Movie is not inserted");
			}
		}
		return mvid;
	}

	@Override
	public boolean delete(String MvId) throws MovieException {
		boolean isDone = false;

		try (Connection con = conProvider.getConnection();
				PreparedStatement pDelete = con
						.prepareStatement(IQueryMapper.DEL_MOVIE_QRY)) {

			pDelete.setString(1, MvId);

			int rowCount = pDelete.executeUpdate();

			if (rowCount == 1) {
				isDone = true;
			}
		} catch (SQLException exp) {
			//log.error(exp);
			throw new MovieException("Movie is not inserted");
		}

		return isDone;
	}

	
	@Override
	public Movie get(String MvId) throws MovieException {
		Movie movie=null;
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_MOVIE_QRY)) {
ct.setString(1, MvId);

			ResultSet rs = pSelect.executeQuery();
			
			if(rs.next()){
				movie = new Movie();
				movie.setMvId(rs.getString("Mvid"));
				movie.setMvName(rs.getString("MvName"));
				movie.setMvHero(rs.getString("MvHero"));
				movie.setCollection(rs.getInt("Collections"));
				movie.setReleaseDate(rs.getDate("rdate").toLocalDate());
			}
			
		} catch (SQLException exp) {
			//log.error(exp);
			throw new MovieException("Movie is not available");
		}		
		return movie;
	}

	@Override
	public List<Movie> getAll() throws MovieException {
		List<Movie> movies=null;
		try (Connection con = conProvider.getConnection();
				PreparedStatement pSelect = con
						.prepareStatement(IQueryMapper.GET_ALL_MOVIE_QRY)) {

			ResultSet rs = pSelect.executeQuery();
			
			movies = new ArrayList<Movie>();
			
			while(rs.next()){
				Movie movie = new Movie();
				movie.setMvId(rs.getString("mvid"));
				movie.setMvName(rs.getString("mvname"));
				movie.setMvHero(rs.getString("mvhero"));
				movie.setCollection(rs.getInt("Collections"));
				movie.setReleaseDate(rs.getDate("rdate").toLocalDate());
				movies.add(movie);
			}
			
		} catch (SQLException exp) {
			//log.error(exp);
			throw new MovieException("No Movies are available.");
		}		
		return movies;	
	}

	@Override
	public boolean update(Movie movie) throws MovieException {
		boolean isDone = false;
		if (movie != null) {
			try (Connection con = conProvider.getConnection();
					PreparedStatement pUpdate = con
							.prepareStatement(IQueryMapper.MODIFY_MOVIE_QRY)) {

				
				pUpdate.setString(1, movie.getMvId());
				pUpdate.setString(2, movie.getMvName());
				pUpdate.setString(2, movie.getMvHero());
				pUpdate.setDate(3, Date.valueOf(movie.getReleaseDate()));
				pUpdate.setString(4, movie.getMvId());
				

				int rowCount = pUpdate.executeUpdate();

				if (rowCount == 1) {
					isDone = true;
				}
			} catch (SQLException exp) {
				//log.error(exp);
				throw new MovieException("movie is not updated.");
			}
		}
		return isDone;
	}

	@Override
	public void persist() throws MovieException {
		/* no implementation required */
		
	}

	@Override
	public Movie searchId(String mvId) throws MovieException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie searchName(String mvName) throws MovieException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie searchHero(String mvHero) throws MovieException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie searchDate(LocalDate releaseDate) throws MovieException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie searchCollection(Double collection) throws MovieException {
		// TODO Auto-generated method stub
		return null;
	}
}