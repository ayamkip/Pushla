(function()
{
 "use strict";
 /*
   hook up event handlers 
 */
 function register_event_handlers()
 {    
     /* button  Log in */
    $(document).on("click", ".uib_w_2", function(evt)
    {
         activate_page("#Login"); 
    });
    
        /* button  Make an account */
    $(document).on("click", ".uib_w_3", function(evt)
    {
         activate_page("#Register"); 
    });
     
        /* button  Sign in */
    $(document).on("click", ".uib_w_8", function(evt)
    {
         activate_page("#home"); 
    });
    
    }
 document.addEventListener("app.Ready", register_event_handlers, false);
})();
