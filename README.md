# mobileproject

This a base Project for Mobile Automation from the course that I did which is: "Testes funcionais de aplicações Android com Appium"

> The link for the course on Udemy: https://www.udemy.com/course/testes-appium/

## 💻 Setup

Before begin you should download and setup those steps:

* Install JDK
* Install Maven
* Install NodeJS
* Install NPM
* Install Appium Desktop
* Install Android Studio
* Install IDE
* Android Emulator
* Test

## 🚀 Steps to run locally

Steps to run this project locally:

* Clone this project
* Set the Environment Variables
* Start the Appium
* Start the Android Emulator
* In the root of the project run: 'mvn clean install -U'
* To run all the tests type: 'mvn -Dtest="ctappium/teste/**" test'
* To run one test type: 'mvn -Dtest={Any Teste Class} test'
* To run the report: 'mvn clean install test surefire-report:report'


## ☕ Refferences

There are some refferences to guide you through this project:

* Appium:
  * https://github.com/clarabez/appium
  * https://www.swtestacademy.com/appium-tutorial/
  * https://www.browserstack.com/guide/appium-tutorial-for-testing
  * https://appiumpro.com/editions/91-getting-started-with-appium-for-android-on-windows
  * https://support.smartbear.com/testcomplete/docs/app-testing/mobile/device-cloud/configure-appium/android-on-windows.html
  * https://github.com/appium/appium-desktop/releases


* Java Development Kit
  * https://www.oracle.com/java/technologies/downloads/
  * https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-61460339-5500-40CC-9006-D4FC3FBCFC0D


* Android
  * https://developer.android.com/studio
  * https://www.automationtestinghub.com/setup-android-environment-variables/


* Maven
  * https://mkyong.com/maven/how-to-install-maven-in-windows/
  * https://maven.apache.org/download.cgi
