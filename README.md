# java_selenium
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [IDE](#ide)
* [Setup](#setup)

## General info
This project is the implementation of the Selenium automatic tests for login (positive) and registration (negative) on the Spotify application.

## Technologies
Project is created with:
* Java 16.0.2
* ChromeDriver 92.0.4515.43
* Selenium 3.4
* Maven 

## IDE
Project is launched with:
* IntelliJ 2021.1.3

## Setup
The easiest way to run the tests:
1. Download Java 16
2. Install IntelliJ 2021.1.3
3. Download ChromeDriver in version exactly the same as the chrome version you are using. 
4. Import this project into IntelliJ.
5. Let IntelliJ download all dependency it needs.
6. To "project" folder add .env file with content:
   * EMAIL=yourSpotifyEmail@email.com
   * PASSWORD=yourSpotifyPassword
   * CHROME_DRIVER_PATH=X://absolute//path//to//chromedriver.exe
7. Open Maven panel (it is located on the right side of IntelliJ) and navigate to project-> Lifecycle.
8. Double click "clean" option and then "test" option.
9. The tests are run in the browser and the results are displayed in the console window.


