@echo off
set current_dir=%~dp0
pushd %current_dir%
cd ../../
echo ��ǰCMDĬ��Ŀ¼��%cd%
call mvn eclipse:eclipse
pause