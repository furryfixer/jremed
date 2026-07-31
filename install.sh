#!/bin/bash
##########################################################################
echo "
# This script installs the jremed application to your system.
# It adds a shortcut to your main menu in
# Preferences -> JRE Menu Editor, or
# System -> Preferences -> JRE Menu Editor
# depending on your distribution.
#
# Modified from lxmed by William Rueger (furryfixer), 2026
# Original Author: Marko Čičak

Press <Enter> to continue
"
##########################################################################
read a
# user must be root
if [ "$(id -u)" != "0" ]; then
   echo "STOP! Installation must be run as root
" 1>&2
   exit 1
fi

echo Installing application...
echo

# remove any existing files and folders
echo Removing any previous installed files and folders...
rm -r -v -f /opt/jremed
rm -f /usr/share/applications/jremed.desktop
rm -f /usr/bin/jremed*
rm -f /usr/share/polkit-1/actions/org.pkexec.jremed.policy
echo 
# copy new files
cp -v content/jremed /usr/bin/
chmod -v +x /usr/bin/jremed
cp -v content/jremed-bin /usr/bin/
chmod -v +x /usr/bin/jremed-bin
cp -v content/jremed.desktop /usr/share/applications/
cp -v content/org.pkexec.jremed.policy /usr/share/polkit-1/actions/
mkdir -p -v /opt/jremed
cp -v README.md /opt/jremed/
cp -v LICENSE /opt/jremed/
cp -v content/JREmenuEditor.jar /opt/jremed/
cp -v content/lxmed.png /opt/jremed/
cp -v content/uninstall.sh /opt/jremed/
chmod -v +x /opt/jremed/uninstall.sh
touch /var/log/jremed.log
chmod 0666 /var/log/jremed.log
echo
echo "Installation sucessfully completed. Enter jremed to run  application
or check Preferences -> JRE Menu Editor in your main menu
"
exit
