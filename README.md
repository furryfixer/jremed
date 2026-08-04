# jremed
## A System Menu Editor for Linux, Wayland or X11, based on Java

JREMED (JRE Menu Editor) is derived from LXMED, with a few changes to make it more up-to-date and generic. It is therefore subject to the lxmed GPL3 license.

JREMED is an Application Menu Editor suitable for most modern linux desktops whose menus follow the XDG menu specification.  It is Java-based, and requires **gtk 3.0+ and a Java runtime environment**, but has lighter dependencies than some other menu editors. Previously incompatible with Xwayland, but now works on both **X11 and Wayland** (with Xwayland). To make changes, it **requires root access through polkit/pkexec**. It has been tested and working on X11 systems, including **Gnome, Plasma, LXQt, Mate, XFCE, i3**, and working on Wayland with **Wayfire, Sway, Niri, Labwc, LXQt-wayland**. Until better Java support arrives for Wayland, Xwayland is needed.

## Applicability

Why JREMED?  Since it works at the system level, this program is not for everyone.  It is mostly for those who want or need to change global menus or **_application_.desktop** files system-wide for all users, or for those single users who prefer the simpler option of working with only one high level set of menus, instead of the admittedly safer and more secure option of having multiple menu configs, and storing menu modifications in the user's home directory. The user will need **sudo or superuser privileges** to edit menus with this app. Like lxmed, jremed works on the global application menu entries in **/usr/share/applications**, not at the level of the local user.


## Dependencies

For all:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Bash, Polkit**, and a **polkit agent**, **GTK2.2+** or **GTK3, JRE** (Java Runtime Environment)<br/> 
For Wayland:&nbsp;&nbsp;**Xwayland** and **xhost**. xhost may be in an "x11-xserver-utils" or "xorg-xhost" package, depending on distribution.

The polkit agent of your choice must be running to use jremed from the menu, although it may still run from a terminal window command line without it. Xwayland must be installed and available (that is the default for most Wayland desktops). Niri also requires xwayland-satellite.

## Installation

Make sure you have a **Java Runtime Environment** installed, as well as polkit, then follow these steps:

- git clone the "**jremed**" repo.
- Move the folder to any desired location on the local system.
- cd  /_your_location_/jremed
- chmod +x install.sh
- sudo ./install.sh

How to uninstall jremed?

- sudo chmod +x /opt/jremed/uninstall.sh
- sudo /opt/jremed/uninstall.sh

## How to Use

From the menu:

- Main Menu -> Preferences -> JRE Menu Editor
  
From a terminal window:
- jremed&nbsp;&nbsp;# runs with normal user privileges
- jremed -r (or jremed --root)&nbsp;&nbsp;# Uses pkexec to elevate privileges
- jremed --help&nbsp;&nbsp;# This basic info

## Notes:

The menu entry (JRE Menu Editor) executes "jremed -r" to get elevated privileges.  If choosing "JRE Menu Editor" from the menu does not work, a policykit agent may not be running. jremed should still run from the command line in that case. Running "jremed" with no options is safer when the user wishes to examine menu entries or .desktop files in detail without making changes. "jremed -r" is required to edit, reorganize, add or remove menu entries. You must invoke "jremed -r" as a regular user, NOT ALREADY ROOT, and allow pkexec to confirm superuser access with a password.

Menu items that cannot be edited will be red in color (instead of green). Errors will be logged to<br/>
"/var/log/jremed.log".

If fonts do not render well, it may be necessary to change gtk2/gtk3 settings for Root, unless running without root privileges.

Sway may occasionally open jremed with a blank tile. Repositioning the tile will force proper rendering.
