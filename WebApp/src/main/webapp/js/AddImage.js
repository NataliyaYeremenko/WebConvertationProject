/**
 * Created by Abakumov on 05.09.2016.
 */
var main = {
    addInputFile: function () {
        var imageType = document.getElementById("imageType").value;
        var date =$("#date").value; //document.getElementById("date").value;
        var imageName = document.getElementById("imageName").value;
        var inputPath = document.getElementById("inputPath").value;
        var formatFile = document.getElementById("formatFile").value;
        var type = "add_Image";
        var  index = 1;
        $.ajax({
            type: "POST",
            url: "/WebConvertationProject",
            dataType: "json",
            data: {requestType: "image", type: type, index: index, imageType: imageType, date: date,
                    imageName: imageName, inputPath: inputPath, formatFile: formatFile},
            success: function (data) {
                if(data.State == "error")
                console.log("error");
            }
        });
    },

    addOutputFile: function () {
        var imageType = document.getElementById("imageType").value;
        var date =$("#date").value; //document.getElementById("date").value;
        var imageName = document.getElementById("imageName").value;
        var inputPath = document.getElementById("inputPath").value;
        var formatFile = document.getElementById("formatFile").value;
        var operationType = document.getElementById("operationType").value;
        var newImageName = document.getElementById("newImageName").value;
        var outputPath = document.getElementById("outputPath").value;
        var quality = document.getElementById("quality").value;

        var type = "changeImage";
        var  index = 1;
        $.ajax({
            type: "POST",
            url: "/WebConvertationProject",
            dataType: "json",
            data: {requestType: "image", type: type, index: index, imageType: imageType, date: date,
                imageName: imageName, inputPath: inputPath, formatFile: formatFile, operationType: operationType,
                newImageName: newImageName, outputPath: outputPath, quality: quality},
            success: function (data) {
                if(data.State == "error")
                    console.log("error");
            }
        });
    }
};