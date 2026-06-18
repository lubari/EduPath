@REM ----------------------------------------------------------------------------
@REM Maven Start Up Batch script
@REM ----------------------------------------------------------------------------
@echo off
set MAVEN_PROJECTBASEDIR=%~dp0

if not exist "%USERPROFILE%\.m2\wrapper\dists" mkdir "%USERPROFILE%\.m2\wrapper\dists"

set WRAPPER_JAR="%USERPROFILE%\.m2\wrapper\maven-wrapper.jar"
set WRAPPER_PROPERTIES="%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.properties"

for /F "usebackq tokens=1,2 delims==" %%A in (%WRAPPER_PROPERTIES%) do (
    if "%%A"=="distributionUrl" set DISTRIBUTION_URL=%%B
)

set DISTRIBUTION_URL=%DISTRIBUTION_URL: =%
for %%F in ("%DISTRIBUTION_URL%") do set DIST_FILENAME=%%~nF
set DIST_DIR=%USERPROFILE%\.m2\wrapper\dists\%DIST_FILENAME%

if not exist "%DIST_DIR%\bin\mvn.cmd" (
    echo Descargando Maven...
    powershell -Command "Invoke-WebRequest -Uri '%DISTRIBUTION_URL%' -OutFile '%TEMP%\maven.zip'"
    powershell -Command "Expand-Archive -Path '%TEMP%\maven.zip' -DestinationPath '%USERPROFILE%\.m2\wrapper\dists\' -Force"
)

set PATH=%DIST_DIR%\bin;%PATH%
mvn %*
