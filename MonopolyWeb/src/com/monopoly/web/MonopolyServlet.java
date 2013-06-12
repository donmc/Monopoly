package com.monopoly.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monopoly.domain.Game;

/**
 * Servlet implementation class MonopolyServlet
 */
@WebServlet({ "/MonopolyServlet", "/Monopoly", "/Play" })
public class MonopolyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MonopolyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean newGame = Boolean.parseBoolean(request.getParameter("newGame"));
		Game game = (Game)request.getSession().getAttribute("game");
		
		if(newGame)
		{
			int numberOfPlayers = Integer.parseInt(request.getParameter("numberOfPlayers"));
		
			game = new Game(numberOfPlayers);
			request.getSession().setAttribute("game", game);
		} 
		else 
		{
			game.playRound();
		}
		
		request.getRequestDispatcher("game.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
