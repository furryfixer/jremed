#!/bin/bash

# user must be root
if [ "$(id -u)" != "0" ]; then
   echo "Uninstallation must be run as root" 1>&2
   exit 1
fi

# remove any existing files and folders
echo Removing application...
echo
rm -r -v -f /opt/jremed
rm -v /usr/share/applications/jremed.desktop
rm -v /usr/bin/jremed
rm -v /bin/jremed
rm -v /usr/share/polkit-1/actions/org.pkexec.jremed.policy
echo
echo Application successfully removed.
