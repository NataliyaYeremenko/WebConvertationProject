/**
 * Created by Nataliya on 18.03.2017.
 */
var main = {
    addComment: function () {
        var com = document.getElementById("comment").value;
        var date = new Date();//  $("#date").value;
        function getCookies() {
            var cookies = {};
            var all = document.cookie;
            if (all==="") return cookies;
            var list = all.split("; ");
            for (var i = 0; i< list.length; i++){
                var cookie = list[i];
                var p = cookie.indexOf("=");
                var name = cookie.substring(0, p);
                var value = cookie.substring(p+1);
                value = decodeURIComponent(value);
                cookies[name]=value;
            }
            return cookies;

        }
        //var userLogin = getCookies().name;
        $.ajax({
            type: "POST",
            url: "/WebConvertationProject",
            dataType: "json",
            data: {requestType: "comment", comment: com, date: date.getDate()},// user: userLogin},
            success: function (data) {
                console.log(data);
            }
        });

    }
}