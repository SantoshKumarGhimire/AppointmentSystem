/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.controller;

import appointment.dao.AppointmentDao;
import appointment.model.Appointment;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santosh
 */
public class AppointmentServlet extends HttpServlet {

    // This method is used to call the Aoppointment Dao class to select saved appointments based on the user search value 
    // this methods converts java List object into Json object (convertion is done by google Gson)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("search_value") != null) {

            try {

                AppointmentDao appointmentDao = new AppointmentDao();

                String search_value = request.getParameter("search_value");

                List<Appointment> apointments = appointmentDao.selectValue(search_value);
                Gson gson = new Gson();
                JsonElement element = gson.toJsonTree(apointments, new TypeToken<List<Appointment>>() {
                }.getType());
                JsonArray jsonArray = element.getAsJsonArray();
                response.setContentType("application/json");
                response.getWriter().print(jsonArray);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }

    }
    // end of select method

//==================================================================================================================================================
// this method is used for post operation i.e insert operation 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("date") != null || request.getParameter("time") != null || request.getParameter("desc") != null) {

            try {
                AppointmentDao appointmentDao = new AppointmentDao();
                Appointment appointment = new Appointment();
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                String desc = request.getParameter("desc");

                appointment.setDate(date);
                appointment.setTime(time);
                appointment.setDescription(desc);

                String successMessage = appointmentDao.InsertData(appointment);
                Gson gson = new Gson();
                String js = gson.toJson(successMessage);
                response.setContentType("application/json");
                response.getWriter().print(js);
               

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

// end of post method

