"use strict";
(()=>{
    function validate(){
       let name= document.getElementById("name").value;
        if(name.length > 100){
            alert("Too many characters in task name! Please enter less than 100 characters")
        }
        }

        let form = document.getElementById("edit-task-form");
        form.addEventListener('submit', (e)=>{
            console.log("inside event listener");
            e.preventDefault();
            validate();
            if(validate()){
                form.submit();
            } else {
                e.preventDefault();
            }
         })

})();
