/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.dao;
import appointment.model.Appointment;
import appointment.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Santosh
 */
public class AppointmentDao {
// this method selects all the appointments saved on the database based on the search string passed by user. If user doesnot pass any value than it selects all the records from database
 // search is done based on the description  
    public List<Appointment> selectValue(String description) throws SQLException {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            
            List<Appointment> appointments = new ArrayList<>();
            Appointment appointment;
            String dateTime;
            String months;
            String date;
            String time;
            conn = DbConnection.getDBConnection();
            
            String query = "select * from appointment_info where description like ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + description + "%");
            ResultSet rs = ps.executeQuery();

            
            
            while (rs.next()) {
                appointment = new Appointment();
                dateTime = rs.getString("date_time");
                months = Month.of(Integer.parseInt(dateTime.substring(5, 7))).name();
                date = dateTime.substring(8, 10);
                time = LocalTime.parse(dateTime.substring(11, 16), DateTimeFormatter.BASIC_ISO_DATE.ofPattern("HH:mm")).format(DateTimeFormatter.ofPattern("hh:mm a"));

                appointment.setDate(months + " " + date);
                appointment.setTime(time);

                appointment.setDescription(rs.getString("description"));
                appointments.add(appointment);

            }
            return appointments;
        } catch (NumberFormatException | SQLException e) {
             throw new SQLException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // end of the select (search)

    
    // this method is used to insert date time and description to the database table appointment_info
    public String InsertData(Appointment appointment) throws SQLException {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = DbConnection.getDBConnection();
            String query = "insert into appointment_info (date_time, description) values (?,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, appointment.getDate() + " " + appointment.getTime());
            ps.setString(2, appointment.getDescription());
            ps.executeUpdate();

            return "successfully Inserted";
        } catch (SQLException e) {
            throw new SQLException(e);
            //return "Failed to insert";

        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //end of insertion into appointment info

}
