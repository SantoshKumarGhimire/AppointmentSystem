

$(document).ready(function () {
    $("#data_table").hide();
    $("#hiddendiv").hide();
    $(".cancel").hide();
    getAppointments();
});

//on the click of search button this will call getAppointmentMethod to select appointment through AJAX call to the server
$("#search_btn").click(function () {
    getAppointments();
});



$(".add").click(function () {


//after click of new button the button value will changed into add and cancel button will be shown and hidden input form will be shown 
    if (this.value == "New") {
        $("#hiddendiv").show();
        $(".cancel").show();
        this.value = 'Add';

    } else {

       
// this is used for validation of data, time and description 
        validator = $('#form_tosubmit').validate({
            rules: {
                date: "required",
                time: "required",
                description: "required"
            },
            messages: {
                date: "please enter valid date !",
                time: "please enter valid time !",
                description: "please enter description !"
            },
            errorPlacement: function (error, element) {
                error.appendTo(element.parent("td").next("td"));
            },
            
            // after completion of validation this will call the server to send data from post method by ajax request to Appointment Servlet
            submitHandler: function () {
                var date = $("#date").val();
                var time = $("#time").val();
                var description = $("#description").val();

                $.post('AppointmentServlet', {date: date, time: time, desc: description}, function () {
                    getAppointments();
                    $("#date").val("");
                    $("#time").val("");
                    $("#description").val("");
                    $('#form_tosubmit').reset();
                });
            }
        });
    }
});

// if cancel button get clicked input form will hide , cancil button itself will hide and Add button becoms new button
$(".cancel").click(function () {
    $("#hiddendiv").hide();
    $(".cancel").hide();
    $(".add").val("New");

});

// this doesnot allow date picker to select previous date
var date_time_now = new Date().toISOString().slice(0, 10);
$("#date").attr("min", date_time_now);


// this methods selects avaliable valaues from database doing ajax call to the server
function getAppointments() {
    var search_value = $("#search_input").val();
    $.get('AppointmentServlet', {search_value: search_value}, function (responseJson) {
        var row = "";
        var flag = false;
        $.each(responseJson, function (key, value) {
            flag = true;
            row += "<tr><td>" + value.date + "</td><td>" + value.time + "</td><td>" + value.description + "</td></tr>";
        });
        if (flag == true) {
            $('.table_rows').html(row);
            $("#data_table").show();
        }
 });
}

            