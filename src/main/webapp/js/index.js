
document.addEventListener("DOMContentLoaded", () => {
	const promise = getTasks();
    promise.then(onTasksReceived);
}); 


 
//  function validateName() {
//     var name = document.forms["myForm"]["Name"].value;
//     var lastName = document.forms["myForm"]["lastName"].value;
//     if (name == "" || lastName == "") {
//       alert("Field can not be empty");
//       return false;
//     }else return true;
    
//   }
 
//   function validatePhoneNumber() {
//     var tel = document.forms["myForm"]["phoneNum"].value;
//     var phoneNum = parseInt(tel, 10);
//     if (isNaN(phoneNum)) {
//         alert("Input not valid");
//         return false;
//       }
//     if (tel.length < 5 || tel.length > 10 ) {
//         alert("check the number length");
//         return false;
//       }else return true;

//   }

//     function onTasksReceived(array) {
//     array.forEach(element => {
//         var option = document.createElement('OPTION');
//         var txt = element.courseName;
//         option.textContent = txt;
//         option.appendChild =(txt);
//         option.setAttribute("value",txt);
//       //  select.add(option);
//     });
//  }
    
// function validateSelectedValue() {
//  var selectedValue = document.querySelector("#select").value;
//  if (selectedValue == "" || selectedValue == null) {
//   alert("Make selection");
//   return false;
// }else return true;
// }

function post() {
  const data = {

      message:  document.querySelector("#datatask").value,

  }
  
      sendMessage(data);
   

}
