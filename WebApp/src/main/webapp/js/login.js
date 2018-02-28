/**
 * Created by Nataliya on 27.02.2017.
 */
var main = {

    setCookie: function (login, value, options) {
        options = options || {};

        var expires = options.expires;

        if (typeof expires == "number" && expires) {
            var d = new Date();
            d.setTime(d.getTime() + expires * 1000);
            expires = options.expires = d;
        }
        if (expires && expires.toUTCString) {
            options.expires = expires.toUTCString();
        }

        value = encodeURIComponent(value);

        var updatedCookie = login + "=" + value;

        for (var propName in options) {
            updatedCookie += "; " + propName;
            var propValue = options[propName];
            if (propValue !== true) {
                updatedCookie += "=" + propValue;
            }
        }

        document.cookie = updatedCookie;
    },


    registration: function () {
        var log = document.getElementById("logReg").value;
        var email = document.getElementById("mailReg").value;
        var pass = document.getElementById("passReg").value;
        $.ajax({
            type: "POST",
            url: "/WebConvertationProject",
            dataType: "json",
            data: {requestType: "registration", login: log, email: email, password: pass},
            success: function (data) {
                console.log(data);
                document.location.href = 'User_cabinet.html';
            }
        });
    },

    log_in: function () {
        var log = document.getElementById("login").value;
        var pass = document.getElementById("password").value;
        //var userLogin = localStorage.login;
        function setCookie(name, value, daysToLive) {
            var cookie = name + "=" + encodeURIComponent(value);
            if (typeof daysToLive === "number")
                cookie += "; max-age=" + (daysToLive*60*60*24);
            document.cookie = cookie;

        }
        setCookie("login", log);
        $.ajax({
            type: "POST",
            url: "/WebConvertationProject",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
             success: function (data) {
                if(data.name == "error")
                    document.location.href = 'errorPage.html';
                else
                    document.location.href = 'User_cabinet.html';
                    window.onload = function() {
                        document.getElementById("name").innerHTML = data.name;
                        document.getElementById("index").innerHTML = data.indexNumber;
                        localStorage.login = log;
                        // var userLogin = localStorage.login;
                        // alert(document.cookie);
                }
            }
        });

        //alert(log);
    }




};