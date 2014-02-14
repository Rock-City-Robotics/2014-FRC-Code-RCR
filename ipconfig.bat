@echo off
color 00
title Connect to robot.

:: BatchGotAdmin
:-------------------------------------
REM  --> Check for permissions
>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"

REM --> If error flag set, we do not have admin.
if '%errorlevel%' NEQ '0' (
    echo Requesting administrative privileges...
    goto UACPrompt
) else ( goto gotAdmin )

:UACPrompt
    echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
    set params = %*:"=""
    echo UAC.ShellExecute "cmd.exe", "/c %~s0 %params%", "", "runas", 1 >> "%temp%\getadmin.vbs"

    "%temp%\getadmin.vbs"
    del "%temp%\getadmin.vbs"
    exit /B

:gotAdmin
    pushd "%CD%"
    CD /D "%~dp0"
:--------------------------------------

:start
echo Welcome, %USERNAME%
goto laterstart

:laterstart
echo What would you like to do?
echo .
echo Wifi settings
echo 1. Set connection settings for connecting to robot.
echo 2. Set connection settings for connnecting to internet.
echo 3. Set connection settings for Axis camera.
echo .
echo Ethernet settings
echo 4. Set connection settings for connecting to robot.
echo 5. Set connection settings for connnecting to internet.
echo 6. Set connection settings for Axis camera.
echo 7. Set connection settings for flashing the CRIO.
echo .
echo 0. Quit
echo.
 
set /p choice="Enter your choice: "
if "%choice%"=="1" goto setStatic
if "%choice%"=="2" goto setDHCP
if "%choice%"=="3" goto setCam
if "%choice%"=="4" goto setEStatic
if "%choice%"=="5" goto setEDHCP
if "%choice%"=="6" goto setECam
if "%choice%"=="7" goto setFlash
if "%choice%"=="0" exit
echo Invalid choice: %choice%
echo.
pause
cls
goto laterstart

:setStatic
netsh interface ip set address "Wi-Fi" static 10.48.49.5 255.0.0.0
echo Done.
set /p done="Quit: Y/N "
if "%done%"=="N" goto laterstart
if "%done%"=="Y" exit
if "%done%"=="n" goto laterstart
if "%done%"=="y" exit
echo Invalid choice: %done%
echo .
echo Now quiting
pause
exit

:setEStatic
netsh interface ip set address "Ethernet" static 10.48.49.5 255.0.0.0
echo Done.
set /p done4="Quit: Y/N "
if "%done4%"=="N" goto laterstart
if "%done4%"=="Y" exit
if "%done4%"=="n" goto laterstart
if "%done4%"=="y" exit
echo Invalid choice: %done4%
echo .
echo Now quiting
pause
exit

:setDHCP
netsh interface ip set address "Wi-Fi" dhcp
echo Done.
set /p done2="Quit: Y/N "
if "%done2%"=="N" goto laterstart
if "%done2%"=="Y" exit
if "%done2%"=="n" goto laterstart
if "%done2%"=="y" exit
echo Invalid choice: %done2%
echo .
echo Now quiting
pause
exit

:setEDHCP
netsh interface ip set address "Ethernet" dhcp
echo Done.
set /p done5="Quit: Y/N "
if "%done5%"=="N" goto laterstart
if "%done5%"=="Y" exit
if "%done5%"=="n" goto laterstart
if "%done5%"=="y" exit
echo Invalid choice: %done5%
echo .
echo Now quiting
pause
exit

:setCam
netsh interface ip set address "Wi-Fi" static 10.48.49.6 255.0.0.0
echo Done.
set /p done3="Quit: Y/N "
if "%done3%"=="N" goto laterstart
if "%done3%"=="Y" exit
if "%done3%"=="n" goto laterstart
if "%done3%"=="y" exit
echo Invalid choice: %done3%
echo .
echo Now quiting
pause
exit

:setECam
netsh interface ip set address "Ethernet" static 10.48.49.6 255.0.0.0
echo Done.
set /p done6="Quit: Y/N "
if "%done6%"=="N" goto laterstart
if "%done6%"=="Y" exit
if "%done6%"=="n" goto laterstart
if "%done6%"=="y" exit
echo Invalid choice: %done6%
echo .
echo Now quiting
pause
exit

:setFlash
netsh interface ip set address "Ethernet" static 10.48.49.5 255.255.255.0
echo Done.
set /p done7="Quit: Y/N "
if "%done7%"=="N" goto laterstart
if "%done7%"=="Y" exit
if "%done7%"=="n" goto laterstart
if "%done7%"=="y" exit
echo Invalid choice: %done7%
echo .
echo Now quiting
pause
exit