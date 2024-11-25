let password = document.getElementById("password");
let confirmPassword = document.getElementById("confirm-password");
let form = document.getElementById("signup-form");
let passwordError = document.getElementById("password-error");

confirmPassword.oninput=validatePassword;
function validatePassword(){
    if(password.value.trim()=="")
        return;
    else{
  if(password.value!=confirmPassword.value) {
      displayError("YES")
  }else{
      displayError("NO")
  }
    }
}

function displayError(YesOrNo){
    if(YesOrNo=="YES"){
        if(passwordError.classList.contains("d-none"))
            passwordError.classList.replace("d-none","d-block")
    }else if(YesOrNo=="NO"){

        if(passwordError.classList.contains("d-block"))
            passwordError.classList.replace("d-block","d-none")
    }
}

form.addEventListener("submit", function(e){
    e.preventDefault();
    if(form.checkVisibility() && (password.value==confirmPassword.value)){
        form.submit();
    }
})