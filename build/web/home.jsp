<%-- 
    Document   : home
    Created on : Jan 27, 2018, 11:10:05 PM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointments</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    </head>
    <body>

        <div class="wrapper">

            <div class="content-wrapper center">

                <div class="header">
                    <h1>Appointment System</h1>
                </div>

                <div class="error-message">
                    <p id="error-fromserver"></p>
                </div>


                <div class="hidden-form">

                    <form id="form_tosubmit" class="form-horizontal" method="post">

                        <div id="input-form">

                            <!--new button and cancel button defined here--> 
                            <div class="form-group">
                                <input type="submit" value="New" class=" add btn btn-primary">&nbsp;
                                <input type="button" value="Cancel" class="cancel btn btn-warning">				
                            </div>
                            <!--end of new and cancel button defination div-->


                            <!--This is hidden form which only shows up after clicking new button-->
                            <div  id="hiddendiv" class="row form_inputs">

                                <table>

                                    <tr>
                                        <td><label for="date">Date: </label> </td>
                                        <td><input type="date" name="date" id="date" class="form-control date" cols="25" required></td>
                                        <td class="valid-message"></td>
                                    </tr>

                                    <tr>
                                        <td><label for="time">Time: </label></td>
                                        <td><input type="time" name="time" id="time" class="form-control time" cols="25" required></td>
                                        <td class="valid-message"></td>
                                    </tr>

                                    <tr>
                                        <td><label for="description">Description: </label></td>
                                        <td><textarea class="description"  id="description" name="description" class="form-control" cols="25" rows="10" cols="50" required></textarea></td>
                                        <td class="valid-message"></td>
                                    </tr>

                                </table>

                            </div>
                            <!--end of hidden form-->

                        </div>

                    </form>

                </div>

                <!--this div contains search text box and search button-->
                <div class="search">

                    <div class="center">

                        <form class="form-horizontal">

                            <div class="form-group row">

                                <input type="text"  id="search_input" class="col-md-6" >&nbsp;&nbsp;
                                <input type="button" value="Search" id="search_btn" class="btn btn-info">

                            </div>

                        </form>	

                    </div>

                </div>
                <!--end of the search text box and search button div-->

                <!--               this table is used for displaying records that is selected from database 
                               initially if database doesnot have any data than this table will be hidden and whenever user enters value to the database from form the entered value will be populated 
                               in this table and table will no longer hidden-->
                <div id="data_table">

                    <table class="table table-striped">

                        <thead>
                            <tr>
                                <th>DATE</th>
                                <th>TIME</th>
                                <th>DESCRIPTION</th>

                            </tr>

                        </thead>

                        <tbody class="table_rows">

                        </tbody>

                    </table>

                </div>
                <!--this is end of the data table-->
            </div>
        </div>

        <script type="text/javascript" language="javascript" src="resources/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="resources/js/script.js"></script>
    </body>
</html>
