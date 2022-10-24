#!/bin/bash
##########################################################################
# This script installs jremed application to your system. It adds
# a shortcut to your main menu in
# Preferences -> JRE Menu Editor
# or
# System -> Preferences -> JRE Menu Editor
# depending on your distribution
#
# Modified from lxmed by William Rueger (furryfixer), 2022
# Original Author: Marko Čičak
##########################################################################

# user must be root
if [ "$(id -u)" != "0" ]; then
   echo "Installation must be run as root" 1>&2
   exit 1
fi

echo Installing application...
echo

# remove any existing files and folders
echo Removing any previous installed files and folders...
rm -r -v -f /opt/jremed
rm -v /usr/share/applications/jremed.desktop
rm -v /usr/bin/jremed
rm -v /usr/share/polkit-1/actions/org.pkexec.jremed.policy

# copy new files
mkdir -v /opt/jremed
cp -v content/jremed /usr/bin/
chmod -v +x /usr/bin/jremed
cp -v content/JREmenuEditor.jar /opt/jremed/
cp -v content/uninstall.sh /opt/jremed/
chmod -v +x /opt/jremed/uninstall.sh
cp -v content/lxmed.png /opt/jremed/
cp -v content/jremed.desktop /usr/share/applications/
cp -v org.pkexec.jremed.policy /usr/share/polkit-1/actions/
echo
echo "Installation sucessfully completed. Enter jremed to run application or check Preferences -> JRE Menu Editor in your main menu"
echo
