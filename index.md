# jremed
## A System Menu Editor for Linux that is light-weight, based on Java

JREMED (JRE Menu Editor) is derived from LXMED, with a few changes to make it more up-to-date and generic. It is therefore subject to the lxmed GPL3 license.

JREMED is an Application Menu Editor suitable for most modern linux desktops whose menus follow the XDG menu specification.  It is Java-based, and requires **gtk 2.2+ or 3.0+ and a Java runtime environment**, but has lighter dependencies than many other menu editors.  To make changes, it also **requires root access through polkit/pkexec**.

## Dependencies

Polkit (and a polkit agent), GTK2.2+ or GTK3, JRE (Java Runtime Environment).

## Applicability

Why JREMED?  Since it works at the system level, this program is not for everyone.  It is mostly for those who want or need to change global menus or **_application_.desktop** files system-wide for all users, or for those single users who prefer the simpler option of working with only one high level set of menus, instead of the admittedly safer and more secure option of having multiple menu configs, and storing menu modifications in the user's home directory. The user will need **sudo or superuser privileges** to edit menus with this app. Like lxmed, jremed works on the global application menu entries in **/usr/share/applications**, not at the level of the local user.

## Installation

Make sure you have a **Java Runtime Environment** installed, as well as polkit, then follow these steps:

- Clone or download the "**jremed**" repo.
- Move the folder to any desired location on the local system.
- cd  /_your_location_/jremed
- chmod +x install.sh
- sudo ./install.sh
- Go to main menu -> Preferences -> JRE Menu Editor
- For running as non-root, type "jremed" from a terminal commmand line.

How to uninstall jremed?

- sudo chmod +x /opt/jremed/uninstall.sh
- sudo /opt/jremed/uninstall.sh

## Notes:

The menu entry (JRE Menu Editor) executes "pkexec /usr/bin/jremed" to get elevated privileges.  If choosing "JRE Menu Editor" from the menu does not work, the jremed polkit policy file may be improperly installed. Jremed may be run with "jremed" from a commandline as a regular user, but no menu modifications can be made. This still allows detailed information about menu entries however.

If fonts do not render well, it may be necessary to change gtk2/gtk3 settings for Root, unless running without root privileges.
