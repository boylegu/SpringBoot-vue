[![jdkversions](https://img.shields.io/badge/Java-1.7%2B-yellow.svg)]()
[![vueversions](https://img.shields.io/badge/vue.js-2.2.x-brightgreen.svg)]()
[![es2015](https://img.shields.io/badge/ECMAScript-6-green.svg)]()
[![ver](https://img.shields.io/badge/release-v0.1-red.svg)]()
[![MIT](https://img.shields.io/badge/license-MIT-ff69b4.svg)]()


<p align="center">
  <a href ="##"><img alt="sanic_vue" src="https://github.com/boylegu/SpringBoot-vue/blob/master/images/newlogo.jpg?raw=true"></a>

<h4 align="center" style="color:	#3399FF">
Convenient & efficient and better performance for Java microservice full stack.
</h4>

<p align="center" style="color: #FF66FF">Commemorate the 6 anniversary of enter the profession.</p>

<p align="center" style="color: #FF9933">Give beginner as a present.</p>

<p align="right" style="color: #3399FF">———————By Boyle Gu</p>


## overview

This‘s a CRUD demo example base Spring Boot with Vue2 + webpack2. I hope pass thought this project for express Java microservice full stack base web practice.

## Why Spring Boot

Spring is a very popular Java-based framework for building web and enterprise applications. Unlike many other frameworks, which focus on only one area, Spring framework provides a wide verity of features addressing the modern business needs via its portfolio projects.

In relation to Spring, 
Spring Boot aims to make it easy to create Spring-powered, production-grade applications and services with minimum fuss. It takes an opinionated view of the Spring platform so that new and existing users can quickly get to the bits they need.

The diagram below shows Spring Boot as a point of focus on the larger Spring ecosystem. It presents a small surface area for users to approach and extract value from the rest of Spring:


The primary goals of Spring Boot are:

- To provide a radically faster and widely accessible ‘getting started’ experience for all Spring development.

- To be opinionated out of the box, but get out of the way quickly as requirements start to diverge from the defaults.

- To provide a range of non-functional features that are common to large classes of projects (e.g. embedded servers, security, metrics, health checks, externalized configuration).

**Spring Boot does not generate code and there is absolutely no requirement for XML configuration.**

Below are this project code snippet. Do you think simple? 

~~~~java
@RestController
@RequestMapping("/api/persons")
public class MainController {

    @RequestMapping(
            value = "/detail/{id}", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public ResponseEntity<Persons> getUserDetail(@PathVariable Long id) {

        /*
        *    @api {GET} /api/persons/detail/:id  details info
        *    @apiName GetPersonDetails
        *    @apiGroup Info Manage
        *    @apiVersion 1.0.0
        *
        *    @apiExample {httpie} Example usage:
        *
        *        http GET http://127.0.0.1:8000/api/persons/detail/1
        *
        *    @apiSuccess {String} email
        *    @apiSuccess {String} id
        *    @apiSuccess {String} phone
        *    @apiSuccess {String} sex
        *    @apiSuccess {String} username
        *    @apiSuccess {String} zone
        */

        Persons user = personsRepository.findById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
~~~~

## Why MVVM

Although it seems similar to MVC (except with a "view model" object in place of the controller), there's one major difference — the view owns the view model. Unlike a controller, a view model has no knowledge of the specific view that's using it.

This seemingly minor change offers huge benefits:

1. View models are testable. Since they don't need a view to do their work, presentation behavior can be tested without any UI automation or stubbing.

2. View models can be used like models. If desired, view models can be copied or serialized just like a domain model. This can be used to quickly implement UI restoration and similar behaviors.

3. View models are (mostly) platform-agnostic. Since the actual UI code lives in the view, well-designed view models can be used on the iPhone, iPad, and Mac, with only minor tweaking for each platform.

4. Views and view controllers are simpler. Once the important logic is moved elsewhere, views and VCs become dumb UI objects. This makes them easier to understand and redesign.
In short, replacing MVC with MVVM can lead to more versatile and rigorous UI code.

>  *In short, replacing MVC with MVVM can lead to more versatile and rigorous UI code.*

## Why to choose Vue.js

Vue.js is relatively new and is gaining lot of traction among the community of developers. VueJs works with MVVM design paradigm and has a very simple API. Vue is inspired by AngularJS, ReactiveJs and updates model and view via two way data binding.

Components are one of the most powerful features of Vue. They help you extend basic HTML elements to encapsulate reusable code. At a high level, components are custom elements that Vue’s compiler attaches behavior to. 

<p align="center">
  <a href ="##"><img style="box-shadow: 8px 8px 5px #888888;"alt="sanic_vue" src="http://i2.muimg.com/536217/5ae4b10becac44b0.png"></a>
  
## What's Webpack

Webpack is a powerful tool that bundles your app source code efficiently and loads that code from a server into a browser. It‘s excellent solution in frontend automation project.

## Demo


This's a sample ShangHai people information system as example demo.

### Feature (v0.1)
- Spring Boot (Back-end) 

  - Build RestFul-API on SpringBoot with `@RequestMapping` and base CRUD logic implementation

  - Handle CORS(Cross-origin resource sharing) 

  - Unit test on SpringBoot

  - Support hot reload

  - Add interface documents about it's rest-api

  - Pagination implementation of RestFul-API with JPA and SpringBoot

- VueJS & webpack (front-end)

  - Follow ECMAScript 6

  - What about coding by single file components in vueJS
  
  - Simple none parent-child communication and parent-child communication 

  - Interworking is between data and back-end
  
  - How grace import third JS package in vue
  
  - Handle format datetime
  
  - Pagination implementation
  
  - Reusable components
  
     - DbHeader.vue
     - DbFooter.vue  (sticky footer) 
     - DbFilterinput.vue
     - DbModal.vue
     - DbSidebar.vue
     - DbTable.vue

  - Config front-end env on webpack2 (include in vue2, handle static file, build different environment...... with webpack2)

### Main technology stack

- Java 1.7
- Spring Boot 1.5.x
- Maven
- sqlite (not recommend, only convenience example)
- vueJS 2.x
- webpack 2.x
- element ui
- axios

### Preparation

- Please must install Java 1.7  or even higher version


### Installation  
        
- Build front-end environment

        cd sanic_crudvue/frontend

        npm install 

### Usage

- Run back-end server

        cd springboot_vue/target/

        java -jar springboot_vue-0.0.1-SNAPSHOT.jar

- Run Front-end Web Page

        cd springboot_vue/frontend

        npm run dev


> You can also run `cd sanic_crudvue/frontend;npm run build` and it's with Nginx in the production environment

## My Final Thoughts

```
      .   ____          _
     /\\ / ___'_ __ _ _(_)_ __  __ _
    ( ( )\___ | '_ | '_| | '_ \/ _` |
     \\/  ___)| |_)| | | | | || (_| |
      '  |____| .__|_| |_|_| |_\__, |
\  ===========|_|==============|___/== ▀
\- ▌          SpringBoot-vue             ▀
 - ▌                            (o)        ▀
/- ▌            Go Go Go !               ▀
/  =================================== ▀
                    ██


```