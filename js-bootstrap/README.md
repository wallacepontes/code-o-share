js-bootstrap: Java Script Bootstrap   
===============================
Author: Wallace Pontes   
Level: Beginner   
Technologies: Html, CSS, Java Script Bootstrap   
Summary: Basic example of HTML, CSS and JS Bootstrap   

What is it?
-----------

This example demonstrates the use of HTML, CSS and Java Script Bootstrap.

CSS reference   
https://developer.mozilla.org/en-US/docs/Web/CSS/Reference   

Intro to HTML and CSS   
-----------------------   

### 12 columns - Defining the layout   

I suggested using a 12 column grid because it's really easy to create all of the columns that you need.    

which CSS classes should you create?   
1.  row of 100% page width   
2.  columns of 1/12 - 12/12 page width   

1/12 = 8.33%  2/12=16.66% .... 12/12=100%   

```css   
.row { width: 100%; }   
.col-1 { width: 8.33%; }   
.col-2 { width: 16.66%; }  
.col-3 { width: 25%; }   
.col-4 { width: 33.33%; }  
.col-5 { width: 41.66%; }  
.col-6 { width: 50%; }  
.col-7 { width: 58.33%; }  
.col-8 { width: 66.66%; }  
.col-9 { width: 75%; }   
.col-10 { width: 83.33%; }   
.col-11 { width: 91.66%; }   
```    

### Placehold - Quick and simple image placeholders
1.  placepuppy.it   
2.  placekitten.com   
3.  placehold.it  

```html   
<div class="row">   
    <div class="col-12">  
        <img src="http://placehold.it/960x350">  
    </div>  
</div>  
```

### Normalize.css    

Normalize.css makes browsers render all elements more consistently and in line with modern standards. It precisely targets only the styles that need normalizing.   https://necolas.github.io/normalize.css/    
```html   
<link rel="stylesheet" src="//normalize-css.googlecode.com/svn/trunk/normalize.css">    
```   

### Fonts    

www.google.com/fonts   

### CSS Resetting    

 - IE11  
 - IE8  
 - iOS  
 - Android  
 - Firefox  
 . Chrome  
 - Safari  
 - Opera   

```css
@media only screen and (max-width: 500px) and (orientation: landscape) {  
    p {
      display: none;
    }
}
```

### Markup Validation Service   

This validator checks the markup validity of Web documents in HTML, XHTML, SMIL, MathML, etc.   
https://validator.w3.org/#validate_by_input   
If you wish to validate specific content such as CSS stylesheets   
https://jigsaw.w3.org/css-validator/   


### Bootscrap   

Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile first projects on the web.    

http://getbootstrap.com/javascript/   
http://getbootstrap.com/customize/   
http://getbootstrap.com/css   

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
    
    </body>
</html>
```

### Others Java Scripts Frameworks     

1.  Susy - Power tools for the web - http://susy.oddbird.net/    
2.  960 Grid System - http://960.gs/   
3.  Yaml CSS Framework - http://www.yaml.de/   
4.  Foundation - The most advanced responsive front-end framework in the world. http://foundation.zurb.com/sites/docs/   


See more at: https://www.youtube.com/watch?v=EsBmDg_edGQ&list=PLAwxTw4SYaPmd5v7c9i883AwqVZquegHM&index=20   

System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.


Build and Deploy 
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. _  

1. Open a command line and navigate to the root directory of this project.  
2. Type this command to build the archive:  

        mvn clean package tomcat:run   

3. Test the example at http://localhost:8080/js-bootstrap/     
