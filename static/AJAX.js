function changeEventHandler(value, id, image) {
    console.log(value, id, image);

    $.ajax({type : 'POST', url : '/editor/process', data : { image : image, id : id, value : value} }).done(function(response){
        console.log(response);
        document.getElementById("display_image").src=response.url + "?" + new Date().getTime();

    });

}