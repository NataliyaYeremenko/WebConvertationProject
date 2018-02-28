/**
 * Created by Nataliya on 27.03.2017.
 */
var main = {
    updateUser: function () {
        var oldPas = document.getElementById("old_password").value;
        var newPas = document.getElementById("new_password").value;
        var pas = document.getElementById("repeat_password").value;
        var email = document.getElementById("emailReg").value;
        $.ajax({
            type: "POST",
            url: "/WebConvertationProject",
            dataType: "json",
            data: {requestType: "changeInfo", old_password: oldPas, new_password: newPas, repeat_password: pas, emailReg: email},// user: userLogin},
            success: function (data) {
                console.log(data);
            }
        });

    }
}