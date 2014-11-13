set PROJECT_ROOT=%~dp0
call %PROJECT_ROOT%..\..\env.bat
cd ..
call mvn -Declipse.workspace=. eclipse:configure-workspace