#!/bin/bash
echo "
#
# This script will uninstall and remove all components of
# the Jremd System Menu Editor.
#
Proceed? (y/n)<Enter>"
read yn
if [[ $yn != [Yy] ]]; then
	echo "Exiting..."	
	exit
fi
# user must be root
if [ "$(id -u)" != "0" ]; then
   echo "Uninstallation must be run as root" 1>&2
   exit 1
fi
cd ..
# remove any existing files and folders
echo Removing application...
echo
rm -r -v -f /opt/jremed
rm -v /usr/share/applications/jremed.desktop
rm -v /usr/bin/jremed*
rm -v /usr/share/polkit-1/actions/org.pkexec.jremed.policy
echo
echo Application successfully removed.
