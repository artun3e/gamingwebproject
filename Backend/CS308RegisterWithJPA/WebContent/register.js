function trimfield(str) 
{ 
    return str.replace(/^\s+|\s+$/g,''); 
}
function validate()
{
     var obj1 = document.getElementById('name_field');
     var obj2 = document.getElementById('mail_field');
     var obj3 = document.getElementById('pwd_field');
         if(trimfield(obj1.value) == '') 
         {      
              alert("Please enter your name!");
              obj1.focus();
              return false;       
         }
         else if(trimfield(obj2.value) == '')
         {      
               alert("Please enter your e-mail!");
               obj2.focus();
               return false;      
        }
        else if(trimfield(obj3.value) == '')
        {      
              alert("Please enter your password!");
              obj3.focus();
              return false;       
       }

         else
           return true;
}