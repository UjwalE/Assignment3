/**
 * 
 */
package com.skillspeed.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skillspeed.entity.Movie;
import com.skillspeed.service.MovieService;

/**
 * @author Nephilim
 *
 */
public class MovieManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovieService service = new MovieService();
		
		Session session = service.getSession();
		Transaction tx = session.beginTransaction();
		service.defaultData(session);
		
		Movie movie = new Movie();
		
		movie.setTitle("Avenger");
		movie.setDirector("Joss Whedon");
		movie.setSynopsis("Nice");
		
		service.addMovie(session,movie);
		
		service.getAllMovies(session);
		
		Movie film = service.getMovieByName(session,"Batman Returns");
		
		service.diplay(film);
		tx.commit();
		session.close();
		

	}

}
