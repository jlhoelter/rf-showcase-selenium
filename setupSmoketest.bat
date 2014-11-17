set PROJECT_ROOT=%~dp0
call %PROJECT_ROOT%..\..\env.bat
call mvn -Dtest=InitalSetupSmoketest test