### Web Service

- Server running a service and a request using an endpoint 
  GET   /wordCount/<text> 
  POST  /wordCount/
        body {
            <text> 
        }
        
    {
        "wordcount": "lengthOfWord", 
        "uniquewords : "lengthOfUniqueWord"
    }
    
    create a servlet application  running
    which accept the above url 
    and returns the desired result