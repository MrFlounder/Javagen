# Project Title
Javagen
## Version
1.0-SNAPSHOT
## Instruction
This is a code generator engine written in java, consume json file giving specifications about client-server communication rules, output source code for simple http client and server that follow the same specification defined in json.
### Play with it
#### Code generate engine
Build pom first, then run the generator Javagen\gen-engine\src\main\java\GeneratorHandlebars.java.

Output cource code file will be located at Javagen\client-server\src\main\java.

Generator engine itself is standalone java application.
#### Deploy service to server
After server and client source code generated, you can deploy server code to a web app container. And then run client code as standalone java app to see results in console.
Servlet config details are defined here: Javagen\client-server\web\WEB-INF\web.xml
You can use tomcat to run the service endpoints. Just add the deployment to tomcat, and start tomcat.
Check if you service is up using a rest client is recommanded.
### Json Support
Now the engine supports example json specifications like:
```json
[
  {
    "endpoint": "OrderFood",
    "arguments": {
      "food": "string",
      "amount": "number"
    },
    "method": "POST"
  },

  {
    "endpoint": "RateFood",
    "arguments": {
      "food": "string",
      "rating": "number"
    },
    "method": "POST"
  },

  {
    "endpoint": "newEndPoint",
    "arguments": {
      "food": "string",
      "rating": "number",
      "somethingelse": "string"
    },
    "method": "GET"
  }

  {
    "endpoint": "someputEndPoint",
    "arguments": {
      "food": "string",
      "rating": "number",
      "somethingelse": "string"
    },
    "method": "PUT"
  }
]
```
You can define http put/post/get methods, argument type supports string and number, no limit to arguments key value pair number.

### Version 1.0-SNAPSHOT Limits
Http delete is not supported yet.
Only java template is avalaible for now. Not supporting selecting dynamic output language.

### External Framework and Libs
#### Json support
simple.json, org.json
#### Server framework
jersey
#### Template
handlebars.java

## To be implemented
* Multi-language output ( with a template manager take user input/config indicating which language is wanted )
* Static typing af conmmunication standard with reflection
* Support http delete method
* Re-constructe code utilize best OOD practice

## Authors

* **Guangshuo Zang**
