====================================== HOW TO SET UP A PROJECT ========= ===================================

Required tools:
- jdk11 https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- allure-commandline - to generate a report locally https://github.com/allure-framework/allure2/releases
- maven - to run tests through the maven https://maven.apache.org/download.cgi
- IDE - for working with code https://www.jetbrains.com/ru-ru/idea/?host=intellijidea.org
- GIT https://git-scm.com/download/win

================= Running tests =====================

    1) Open IDE
    2) Open project
        There are two ways to run tests:
        1) Change the line # selenium.grid.host = http: // localhost: 4444 / wd / hub in the file /src/main/resources/browser.properties and comment out the line selenium.grid.host = http: // shub-crm.ritperm.rt.ru:4444/wd/hub
            In the IDEAS terminal, enter "mvn clean test -Pchrome-remote" - will run on the local node
            -P - select a profile, then write the id of the maven profile

            Depending on the profile, tests will run in different conditions
            options - chrome-local - locally on Chrome without selenium grid (default if you don't enter -PprofileId)
                        firefox-local - locally on Firefox without selenium grid

        2) Click pkm on src / test / resources / testng.xml and click Run src / test / resources / testng.xml ...
            In this case, tests will run on firefox locally

================= View Allure reports =====================

    1) Install Allure
    2) In the terminal, go to the target folder of the project
    3) Run: allure serve -h localhost -p 9999
============================================================
