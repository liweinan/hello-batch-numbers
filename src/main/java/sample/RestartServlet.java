package sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static sample.StartServlet.jobOperator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "RestartServlet", urlPatterns = {"/restart"})
public class RestartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        final String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            throw new ServletException("Missing id parameter in request");
        }

        final Properties properties = new Properties();
//        properties.setProperty("jberet.restart.mode", "strict");
        final long restartId = jobOperator.restart(Long.valueOf(id), properties);
        out.printf("Restarted %s -> %s%n", id, restartId);

        out.flush();
        out.close();
    }

}