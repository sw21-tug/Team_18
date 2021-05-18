# SaveUp Backend README
This Restful API is intended to be as simple as possible, because this lecture is about creating applications in Kotlin and not to design and develop Restful API's. Due to that, I decided to not use some of Laravel's useful helpers such as Models, DB migrations, Eloquent as ORM, ... If you're interested in API design, proper Authentication, ... or Laravel/Lumen in general, you can check out the great documentation online or shoot me an E-Mail at kilian@weisl.cc :)

## Local Dependencies
- PHP 7.3
- [Composer](https://getcomposer.org/) is required for handling vendor packages
- Recommended: [Laravel Valet](https://lumen.laravel.com/docs/8.x), [Postman](https://www.postman.com/)
## Contributing
- Clone Repository
- ```composer install``` in root directory 
- Configure Laravel Valet (or whatever you use) for testing purposes
- ! copy the content from .env.example into a file called .env in project root

### Adding Endpoints
- in routes/web.php

## Deployment
- Changes get deployed to the server on push and pull-requests to master
- GitHub Actions with [RSYNC](https://github.com/marketplace/actions/rsync-deployments-action) are used for deployment

## Database 
- I decided to have one DB for development, testing and for production use. You can of course configure a local database for development and connect to it in the .env file
- Database credentials:
  - Host: e118093-mysql.services.easyname.eu
  - User: u182913db2
  - DB: u182913db2
  - PW: ef...cw (you can find it in .env.example - only content within "")
- You can have a phpmyadmin instance at [here](https://e118093-phpmyadmin.services.easyname.eu/) (just login with the credentials above)

## Workflow
- Create new branch from master, create PR when ready, at least one reviewer.

## Tools

Some information about the tools we use.

### Laravel Lumen Framework

[![Build Status](https://travis-ci.org/laravel/lumen-framework.svg)](https://travis-ci.org/laravel/lumen-framework) [![Total Downloads](https://img.shields.io/packagist/dt/laravel/framework)](https://packagist.org/packages/laravel/lumen-framework) [![Latest Stable Version](https://img.shields.io/packagist/v/laravel/framework)](https://packagist.org/packages/laravel/lumen-framework) [![License](https://img.shields.io/packagist/l/laravel/framework)](https://packagist.org/packages/laravel/lumen-framework)

Laravel Lumen is a stunningly fast PHP micro-framework for building web applications with expressive, elegant syntax. We believe development must be an enjoyable, creative experience to be truly fulfilling. Lumen attempts to take the pain out of development by easing common tasks used in the majority of web projects, such as routing, database abstraction, queueing, and caching.

Documentation for the Lumen PHP Framework can be found on the [Lumen website](https://lumen.laravel.com/docs).

The Lumen framework is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).

### Valet
- After installing Laravel Valet switch to the ```public``` directory and type ```valet link saveup-backend```
- Access saveup-backend.test in your browser and you should see the version of this API.
- Type ```valet secure saveup-backend``` to serve the site over encrypted TLS using HTTP/2

## License
This project is licensed under the [MIT license](https://opensource.org/licenses/MIT).

