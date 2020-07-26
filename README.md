# Honest Login
> just an API with user auth and a frontend with a login

## Description of the challenge
```
Aqui tienes el “mini test”

We don't mind which tech stack you use, but it needs to be easy to work with. Please prepare a template project, 
just an API with user auth and a frontend with a login, just a working example of your preferred stack. 
It needs to be a project easy to clone and launch for the first time, so consider using docker or similar.

Tienes 48 horas para completarlo.

Muchas gracias.
```

## Running the app (assuming you have a Mac or Linux machine)

**Starting the app with docker**: 

if you have docker installed and wish to run the app's docker image directly, simply run: 
```
./docker-run.sh
```

This script will build the app's docker image and run it in the background

**Starting the app using Java**: 

if you have Java installed and prefer running a standalone JAR file, run:
```
./run.sh
```
This will build the JAR file and run the app in your local environment.

**Trying the web app**:

Once the app is started, browse to http://localhost:8080. A greetings page will be displayed, through which you can log 
into the app. Please use `user` and `password` as credentials. 

After logging in, you'll be presented with a very simple screen that shows a list of menu items, as if this would be used
for ordering food in a restaurant.

**Trying the API**:

As requested, this project also exposes a REsTful endpoint, through which the same list of menu items is made available
to API consumers. Just like the web app, it's mandatory to be requested when interacting with this endpoint. The following 
command can be used to issue a `GET` request with proper Basic Auth credentials to the API:

```
curl http://localhost:8080/api/menu/item -v --user user:password
```

## Trying the app on the cloud

Alternatively, in case you don't want to install or start anything locally, you can try either the web app or the API directly from 
the cloud, just use https://honestlogin.herokuapp.com/ as the base URL -- it might take a while to load it for the first time,
I kindly ask you for a bit of patience if you choose this option :)

## Implementation details

This project was developed using the Spring Framework for both backend and frontend components. Spring Boot 2.x was used 
for bootstrapping development.

On the backend side it uses Kotlin as programming language. On the front end it uses a mix of HTML and Thymeleaf as 
templating engine, which is the default for Spring MVC apps.

The backend exposes business functionalities via 2 controllers: `MenuItemController` (which serves `/api/` HTTP calls) and
`MenuItemWebController`, used to serve the web UI.

Apart from the controllers, there's not much more. The `domain` package holds the classes that represent the 2 main concepts
being manipulated in this app (namely `User` and `MenuItem`), along with their respective repositories, which are responsible
for data manipulation operations.

The `security` package holds classes used to bridge the gap between the application's code and Spring Security requirements, 
whereas `config` contains classes responsible for customizing how Spring Security and Spring MVC are used in the app.

Finally, on persistence layer, an in-memory H2 instance was the tool of choice. First because there was no specific requirement
about the persistence layer and second because of its seamless integration with Spring Boot. Please check `src/main/resources/data.sql`
for the DDL and DML queries used in H2.

### Design decisions

#### Overall considerations
My north star in this project was simplicity. I chose languages and frameworks that I find interesting and that enable me
to deliver fast. As I didn't have too much time over the weekend due to previous arrangements, I wouldn't be able to put
too much effort into learning things on the fly. 

Hence I picked Kotlin (which integrates seamlessly with my IDE of choice, IntelliJ, besides being one of my favourite languages), 
Spring Boot (for its wide range of integrations and internal frameworks) and Thymeleaf (as it's the default choice for Spring MVC).

#### Front end code
I must admit I'm not a specialist in the realms of front end development. I wish I could deliver a super fancy SPA using React
but I wouldn't have enough time to deliver something good enough, so I focused on getting free HTML templates from the internet
and mixing them with Thymeleaf.

A more specialized developer will certainly say the static assets in the project are not optimized and they would be 
absolutely right. I did the conscious decision of investing more carefully on backend code, due to my own familiarity, and
being a bit less careful on the frontend side. I tried to counterbalance that by picking HTML templates that would bring
a "wow factor", while allowing me to have some fun :) 

#### Tests
This app is far from having 100% test coverage, and that was done on purpose. My rationale was to focus on classes where
there actually was something to test.

For instance, on `MenuItemWebController` there are no decisions, no branches, not anything, just a series of commands. I 
decided to trust that Spring MVC is doing is job properly, as there was nothing specific to be tested there.

On the other hand, `UserService` has some (minimal) behaviour, there's an exception possibly being thrown, so I thought 
a unit test would add some value here.

Finally, to guarantee that the whole authentication / authorization plumbing is working at all times, along with all other 
components, I decided to write `MenuItemControllerIntegrationTest` and test scenarios would auth would fail and succeed.

## Feedback

I believe feedback is a crucial part of any human interaction. If you got this far, could I ask you to give me some feedback about your experience trying out this app? I'm totally open to constructive feedback, just let me know your thoughts!
