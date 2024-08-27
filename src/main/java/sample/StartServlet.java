package sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;

@WebServlet(name = "StartServlet", urlPatterns = {"/start"})
public class StartServlet extends HttpServlet {
    final static JobOperator jobOperator = BatchRuntime.getJobOperator();
    final static String job = "numbers";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String jobName = request.getParameter("job");
        if (jobName == null || jobName.isEmpty()) {
            jobName = job;
        }
        final long jobExecutionId = jobOperator.start(jobName, null);
        out.println("Started job execution: " + jobName + " " + jobExecutionId);
        out.flush();
        out.close();
    }

}