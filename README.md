# Toss a Coin To Your Pocket - Home Budget App
### Sometimes missing money before your pay day? Or expecting different amount than you can see on your account? This app will help you keep your budget and be aware how you spend your money.

#### Content:
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#setup)
* [Inspiration](#inspiration)
## General info
This is my final project for postgrade studies - Java Web Developer. 
I like to keep my expenses under controll, so I thought it would be a great idea to use my own app instead of excel sheets. Using this app you'll to be able to enter current expenses and compensate with available balance. Optionally you'll be able to indicate some other savings, and plan near-future expensenses with possibility to estimate your balance.
## Technologies
* Programming language: *Java*.
* Frameworks: 
  * *Spring* (projects: Boot, Data, Framework), 
  * *Hibernate*. 
* Template engine: *Thymeleaf*.
* Data base: *MariaDB*.
* Other projects: *Lombok*.
## Setup
1. Create a database with any name. Your DB can be left empty, but if you wish you can insert some sample input data from *demo.sql* (suitable for MariaDB) file in app's resources.
1. Import this project into your IDE.
1. Please note that this project is operating on MariaDB data base. If you're using another one - you have to change following in source code:
   1. Dependency in *build.gradle*: Just find and change: 
      ``` implementation 'org.mariadb.jdbc:mariadb-java-client:2.1.2'``` with the one that matches your data base (you can find up-to-date dependency in [Maven Repository](https://mvnrepository.com)).
   1. Driver and dialect for your DB in *application.properties* file.
1. Another critical point is to type in correct access data to your data base in *db-template.properties* file. Don't forget to change also the file name itself into *db.properties*. 
1. Run task ```gradlew build``` in the console.
1. Open your browser and select ```localhost:8080```
1. Application is ready to use.

You can use a prepared ```resources\static\demo.sql``` file with some demo inserts for different transactions or start adding your money operations (expenses and incomes) from whenever you want in the past up to current day. It's up to you if you want to start your history right here, right now or have some history behind.
History is availabe for different views:
1. Wydatki - overall expenses,
1. Wpływy - incomes in current month,
1. Bieżacy miesiąc - all together within current month,
1. Bieżacy rok - all together within current year,
1. Statystki - check your balance (only if you  have customized the app), find the highest expense and overview your salary in current year. To be able to see salaries statistics please insert your income with mandatory description 'wynagrodzenie' (case sensitive).

There's no user active by default and it's not necessary, but you can customize your app with your name(that can be real name, nickname or whatever you type in) as well as some starting balance.
## Status
What's ready vs. what'll be ready:
- [x] Create, Read, Update and Delete of your Expenses/Incomes
- [x] Overview latest expenses, current-month incomes, all together in current-month and current-year mode
- [ ] Planned expenses with balance compensation
- [x] Statistics
- [x] User setup
## Inspiration
So far I was inspired for the name of my app with the [Witcher OST](https://youtu.be/hqbS7O9qIXE "Toss a Coin To Your Witcher") song. You can make laught, but I loved this song from its very first tone. Later on I'll share some technical references, while my code will be developed.

Working on the code I realized I must have been inspired by bank apps I used everday for my own finances. I didn't want to make commercial advertisment here, but I believed I should have mentioned here that fact.

Thanks a lot for [Baeldung](https://www.baeldung.com) team. Great tutorials. Very helpful for Spring issues.
