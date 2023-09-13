"use strict";
(()=>{
    function validate(){
       let name= document.getElementById("name").value;
        if(name.length > 100){
            alert("Too many characters in task name! Please enter less than 100 characters")
        }
        }

        let form = document.getElementById("editTask");
        form.addEventListener('submit', function(e){
            console.log("inside event listener");
            e.preventDefault();
            validate();
            form.submit();
         })

})();
