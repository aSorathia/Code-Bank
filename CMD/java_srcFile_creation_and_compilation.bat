@echo off
:again
echo **********************************
echo 1.create
echo 2.compile
echo 3.Run
echo 4.Exit
echo choose your option
echo ************************************
SET /p choise=Please Enter Your Choise :
echo You choose "%choise%"
IF "%choise%"=="1" GOTO :create
IF "%choise%"=="2" GOTO :compile
IF "%choise%"=="3" GOTO :Run
IF "%choise%"=="4" EXIT
GOTO :invalid
:create
cls
SET /p f=Enter Your File name :
set file=%f%.java
echo class %f%>%file%
echo { >>%file%
echo public static void main(String args[]) >>%file%
echo { >>%file%
echo You are at create %file%
goto again
:compile
cls
echo Compiling please wait.....
set path="E:\Program Files\Java\jdk1.6.0_31\bin"
javac %file%
goto again
:Run
echo You are at Run
goto p
:invalid
cls
echo You are at Invalid
goto again
:p
pause>NULL