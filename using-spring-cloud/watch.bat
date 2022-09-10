@ECHO OFF
:loop
  %*
  curl http://localhost:8000/test-api
  echo.
  timeout /t 1 > NUL
goto loop