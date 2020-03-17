package fr.eni.javaee.tp.chifoumi_v3;

import fr.eni.javaee.tp.chifoumi_v3.bo.ActionsPossibles;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;



/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/jouez")
public class ServletChifoumi extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChifoumi() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("choix") != null) {
            processRequest(request, response);
        } else {
            // Délégues la reponse a a JSP jeu.jsp
            RequestDispatcher rd = request.getRequestDispatcher("/WEB_INF/jeu.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int choixJoueur = Integer.parseInt(request.getParameter("choix"));
        int choixServeur = new Random().nextInt(3) + 1;

        /* Choix Joueur CJ = choix Serveur CS => EGALITE
         * CJ = CHI et CS = MI  => Victoire Joueur
         * CJ = FOU et CS = CHI => Victoire Joueur
         * CJ = MI  et CS = FOU => Victoire Joueur
         * Sinon Victoire Serveur
         *
         * resultat : 0 (egal), 1 (vict joueur), -1 (vict serveur)
         */
        int resultat;

        if (choixJoueur == choixServeur) {
            resultat = 0;     // egalite
        } else if ((choixJoueur == ActionsPossibles.CHI && choixServeur == ActionsPossibles.MI) ||
                (choixJoueur == ActionsPossibles.FOU && choixServeur == ActionsPossibles.CHI) ||
                (choixJoueur == ActionsPossibles.MI && choixServeur == ActionsPossibles.FOU)
        ) {
            resultat = 1;    // victoire joueur
        } else {
            resultat = -1;    // victoire serveur
        }

        // Definir les informations à renvoyer à la JSP (resultat.jsp)
        request.setAttribute("resultat", resultat);
        request.setAttribute("choixJoueur", choixJoueur);
        request.setAttribute("choixServeur", choixServeur);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/resultat.jsp");
        if (rd != null) {
            rd.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}