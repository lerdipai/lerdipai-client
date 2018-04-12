@echo off
set current_dir=%~dp0
pushd %current_dir%
cd ../../
echo 当前CMD默认目录：%cd%
call mvn eclipse:eclipse
pause